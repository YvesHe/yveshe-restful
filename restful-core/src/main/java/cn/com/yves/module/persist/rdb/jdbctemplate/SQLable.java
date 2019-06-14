/**   
 * Filename:    SQLable.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-10-23
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.jdbctemplate;

/**
 * SQL部分的总接口
 * 
 * @author Yves He
 * 
 */
public interface SQLable {

    /**
     * 添加SQL语句
     * 
     * @param sql
     * @param values
     */
    void joinSQL(StringBuffer sql, RDBValues values);

}
