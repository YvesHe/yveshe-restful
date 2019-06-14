/**   
 * Filename:    RDManager.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-5
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.yves.module.core.logger.InfraLogger;

/**
 * 关系型数据库管理类 (Mybatis数据库管理类)
 * 
 * @author Yves He(功能等待完善...)
 * 
 */
public class RDBManager {

    private final InfraLogger logger = new InfraLogger(RDBManager.class);

    private static RDBManager manager = null;
    private SqlSessionFactory factory = null;
    private String databaseId = null;

    /* mybatis的属性配置 */
    private static Properties dbConfs = new Properties();// mybatis 的单独配置
    private static String MYBATIS_USERNAME = "username";

    /* 内部的默认配置 */
    private static final String MYBATIS_DEFAULT_CONF_FILE__IN_JAR = "cn/com/yves/module/persist/rdb/mybatis/mybatis-default.xml";
    private static final String MYBATIS_DEFAULT_CONF_FILE_NAME = "mybatis-default.xml";

    /* 一个线程对应一个SqlSession对象 */
    private final ThreadLocal<SqlSession> sessionLocal = new ThreadLocal<SqlSession>() {
        @Override
        protected SqlSession initialValue() {
            return RDBManager.this.createSession();// createSession 不是getSession
                                                   // ,否则会进入死循环.
        };
    };

    /* 数据库单独的配置属性 */
    private static Properties dbProperties = new Properties();

    private RDBManager() {
        try {
            this.init();
        } catch (RDBException e) {
            logger.error("RDBManager error,message:" + e.getMessage());
        }
    }

    /**
     * 配置mybatis
     * 
     * 
     * <br>
     * (将mybatis的一些属性定义为static属性变量,在执行RDBManager初始化之前,调用这个方法配置mybatis的配置参数,
     * 然后通过init来将最新的配置启动生效)
     * 
     * 
     */
    public synchronized static void config(Map<String, String> properties) {
        for (Entry<String, String> entry : properties.entrySet()) {
            if (MYBATIS_USERNAME.equals(entry.getKey())) {
                dbConfs.put(MYBATIS_USERNAME, entry.getValue());
            } else {
                // 也可以指定一个配置文件conf_file
                // .....配置多个配置项
            }
        }
    }

    /**
     * 初始化操作:
     * 
     * <br>
     * 完成对mybatis的设置.
     * 
     * @throws RDBException
     * @throws IOException
     */
    public void init() throws RDBException {
        /* 主要是给用户提供一个配置数据库的方式,然后通过程序来修改mybatis的配置文件 ,暂时先通过配置mybatis的原文件来设置数据库部分. */
        // 高级定制部分(数据库配的配置: 外部的xml配置文件.)
        // 查找方式: 如果没有配置数据库属性, 并且也没有指定默认文件, 默认文件也找不到的情况, 使用jar包中的默认文件
        // 命令行的设置属性的优先级高于配置文件, 所以要替换配置文件中相应的参数.

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("module-mybatis.xml");
        } catch (IOException e) {
        }
        factory = builder.build(in);// 内部已经关流.
        databaseId = factory.getConfiguration().getDatabaseId();
        if (databaseId == null) {
            throw new RDBException("can't get the databaseId.");
        }
    }

    /**
     * 单例模式获取RDBManager
     * 
     * @return
     * @throws RDBException
     */
    public synchronized static RDBManager getRDBManager() {// 单例作用,主要是提高性能
        if (manager == null) {
            manager = new RDBManager();
        }
        return manager;
    }

    /**
     * 创建一个SqlSession
     * 
     * @return
     */
    private SqlSession createSession() {
        return factory.openSession(false);
    }

    /**
     * 获取当前线程的SqlSession
     * 
     * <br>
     * 当前线程无SqlSession就新建.
     * 
     * @return
     */
    public SqlSession getSession() {
        SqlSession sqlSession = sessionLocal.get();
        if (sqlSession == null) {
            sqlSession = this.createSession();
            sessionLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 获取一个新的SqlSession,此对象与ThreadLocal中的SqlSession无关
     * 
     * @return
     */
    public SqlSession getSessionWithoutThreadLocal() {
        return this.createSession();
    }

    /**
     * 关闭当前线程的SqlSession,关闭之后不能使用.
     */
    public void closeSession() {
        SqlSession sqlSession = sessionLocal.get();
        if (sqlSession != null) {
            try {
                sqlSession.close();
            } catch (Throwable e) {
                logger.error("close session error,message:" + e.getMessage());
            }
        }

        sessionLocal.set(null);
    }

    /**
     * 关闭指定的SqlSession,此对象与ThreadLocal中的SqlSession无关
     * 
     * @param sqlSession
     */
    public void closeSessionWithoutThreadLocal(SqlSession sqlSession) {
        if (sqlSession != null) {
            try {
                sqlSession.close();
            } catch (Throwable e) {
                logger.error("close session error,message:" + e.getMessage());
            }
        }
    }

    /**
     * 提交当前线程的SqlSession
     * 
     * <br>
     * 默认关闭Session
     */
    public void commit() {
        this.commit(true);
    }

    /**
     * 提交当前线程的SqlSession
     * 
     * @param closeSession
     *            根据参数,是否关闭Session
     */
    public void commit(boolean closeSession) {
        SqlSession sqlSession = sessionLocal.get();
        try {
            sqlSession.commit();
        } catch (Throwable e) {
            logger.error("commit session error,message:" + e.getMessage());
        }

        if (closeSession == true) {
            this.closeSession();
        }
    }

    /**
     * 提交数据
     * 
     * @param sqlSession
     *            此Session与ThreadLocal中的数据无关
     * 
     * @param closeSession
     *            是否关闭session
     */
    public void commitWithoutThreaLocal(SqlSession sqlSession, boolean closeSession) {
        if (sqlSession != null) {
            try {
                sqlSession.commit();
            } catch (Throwable e) {
                logger.error("commit session error,message:" + e.getMessage());
            }

            if (closeSession == true) {
                this.closeSession();
            }
        }
    }

    /**
     * 回滚数据,通过当前线程中的SqlSession
     * 
     * <br>
     * 默认是关闭Session
     */
    public void rollback() {
        this.rollback(true);
    }

    /**
     * 回滚数据,通过当前线程中的SqlSession
     * 
     * @param closeSession
     *            是否关闭session
     */
    public void rollback(boolean closeSession) {
        SqlSession sqlSession = sessionLocal.get();
        if (sqlSession != null) {
            try {
                sqlSession.rollback();
            } catch (Throwable e) {
                logger.error("rollback error,message:" + e.getMessage());
            }

        }

        if (closeSession == true) {
            this.closeSession();
        }
    }

    /**
     * 回滚指定SqlSession,与ThreadLocal中的Session无关.
     * 
     * @param sqlSession
     * @param closeSession
     */
    public void rollbackWithoutThreadLocal(SqlSession sqlSession, boolean closeSession) {
        if (sqlSession != null) {
            try {
                sqlSession.rollback();
            } catch (Throwable e) {
                logger.error("rollback error,message:" + e.getMessage());
            }
        }

        if (closeSession == true) {
            this.closeSessionWithoutThreadLocal(sqlSession);
        }
    }

    public String getDataBaseId() {
        return this.databaseId;
    }

    /**
     * 数据库连接测试
     */
    public static void testConnection() {
        RDBManager rdbManager = RDBManager.getRDBManager();
        SqlSession session = rdbManager.getSession();
    }

    public static void main(String[] args) {
        testConnection();
    }
}
