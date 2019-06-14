/**   
 * Filename:    UserDaoImpl.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-5
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.mybatis.impl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import cn.com.yves.module.bo.filter.UserFilter;
import cn.com.yves.module.core.logger.InfraLogger;
import cn.com.yves.module.core.utils.UUIDUtil;
import cn.com.yves.module.persist.rdb.mybatis.ModelDao;
import cn.com.yves.module.persist.rdb.mybatis.RDBException;
import cn.com.yves.module.persist.rdb.mybatis.RDBManager;
import cn.com.yves.module.persist.rdb.mybatis.client.UserModelMapper;
import cn.com.yves.module.persist.rdb.mybatis.model.UserModel;

/**
 * 普通的表操作 + 有联合主键的表操作
 * 
 * 
 * <br>
 * 数据库中不管理事务, 不对资源做多线程处理.
 * 
 * @author Yves He
 * 
 */
public class UserModelDaoImpl extends ModelDao<UserModel, String> {

    private final InfraLogger logger = new InfraLogger(UserModelDaoImpl.class);

    private static final String TABLE_NAME = "user";

    private static UserModelDaoImpl instance = null;

    private final ReentrantReadWriteLock readwrite = new ReentrantReadWriteLock();
    private final Lock read = readwrite.readLock();// 暂时没用
    private final Lock write = readwrite.writeLock();

    /*
     * 单例模式方式二: public static UserModelDaoImpl instance =new UserModelDaoImpl();
     * 
     * 有小概率出现线程不安全.
     */

    /* 单例模式,节约资源 */

    private UserModelDaoImpl() {

    }

    public static UserModelDaoImpl getInstance() {
        if (instance == null) {
            synchronized (UserModelDaoImpl.class) {
                instance = new UserModelDaoImpl();
            }
        }
        return instance;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String save(UserModel model) throws RDBException {
        logger.debug("invoke save.");
        if (model == null) {
            logger.debug("user-model is null.");
            throw new RDBException("user-model is null.");
        }

        String id = null;
        RDBManager manager = RDBManager.getRDBManager();
        SqlSession session = manager.getSession();
        if (session == null) {
            logger.debug("the sql-session related to this thread has bean closed.");
            throw new RDBException("the sql-session related to this thread has bean closed.");
        }
        UserModelMapper mapper = session.getMapper(UserModelMapper.class);

        try {
            write.lock();
            if (model.getId() != null && mapper.selectByPrimaryKey(model.getId()) != null) {
                logger.debug("do update.");
                mapper.updateByPrimaryKey(model);
                id = model.getId();
            } else {
                String genId = UUIDUtil.UUIDGen();
                if (StringUtils.isNotBlank(model.getId())) {
                    logger.debug("do insert,message:the new id is " + genId + ",the source id is " + model.getId());
                }
                model.setId(genId);
                mapper.insert(model);
                id = genId;
            }
        } finally {
            write.unlock();
        }

        logger.debug("out save.");
        return id;
    }

    @Override
    public void del(String key) throws RDBException {
        logger.debug("invoke del.");
        if (StringUtils.isBlank(key)) {
            logger.debug("key is blank.");
            return;
        }

        RDBManager manager = RDBManager.getRDBManager();
        SqlSession session = manager.getSession();
        if (session == null) {
            logger.debug("the sql-session related to this thread has bean closed.");
            throw new RDBException("the sql-session related to this thread has bean closed.");
        }
        UserModelMapper mapper = session.getMapper(UserModelMapper.class);
        try {
            write.lock();
            mapper.deleteByPrimaryKey(key);
        } finally {
            write.unlock();
        }
    }

    @Override
    public UserModel getByPrimaryKey(String key) throws RDBException {
        logger.debug("invoke getByPrimaryKey.");
        if (StringUtils.isBlank(key)) {
            logger.debug("key is blank.");
            return null;
        }

        RDBManager manager = RDBManager.getRDBManager();
        SqlSession session = manager.getSession();
        if (session == null) {
            logger.debug("the sql-session related to this thread has bean closed.");
            throw new RDBException("the sql-session related to this thread has bean closed.");
        }
        UserModelMapper mapper = session.getMapper(UserModelMapper.class);
        UserModel modle = mapper.selectByPrimaryKey(key);
        return modle;
    }

    @Override
    public List<UserModel> getAll() throws RDBException {
        logger.debug("invoke getAll.");
        RDBManager manager = RDBManager.getRDBManager();
        SqlSession session = manager.getSession();
        if (session == null) {
            logger.debug("the sql-session related to this thread has bean closed.");
            throw new RDBException("the sql-session related to this thread has bean closed.");
        }
        UserModelMapper mapper = session.getMapper(UserModelMapper.class);
        List<UserModel> result = mapper.listAll();
        return result;
    }

    /* 定制条件查询 */
    public List<UserModel> listByFilter(UserFilter filter) throws RDBException {
        logger.debug("invoke listByFilter.");
        RDBManager manager = RDBManager.getRDBManager();
        SqlSession session = manager.getSession();
        if (session == null) {
            logger.debug("the sql-session related to this thread has bean closed.");
            throw new RDBException("the sql-session related to this thread has bean closed.");
        }
        UserModelMapper mapper = session.getMapper(UserModelMapper.class);
        List<UserModel> result = mapper.listByFilter(filter);
        return result;
    }

}
