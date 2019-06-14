/**   
 * Filename:    Test.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-5
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.mybatis;

import org.apache.ibatis.session.SqlSession;

public class TestConnection {
    public static void main(String[] args) {
        // 测试连接
        RDBManager rdbManager = RDBManager.getRDBManager();
        SqlSession session = rdbManager.getSession();
    }

    // 测试高级查询(Mybatis的标签使用)

}
