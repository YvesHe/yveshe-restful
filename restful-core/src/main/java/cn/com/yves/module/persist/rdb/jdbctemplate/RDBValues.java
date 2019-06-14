/**   
 * Filename:    RDBValues.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-10-23
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.jdbctemplate;

import java.util.LinkedList;

/**
 * RDB的值 存放的是数据库字段对应的值.
 * 
 * @author Yves He
 * 
 */
public class RDBValues {

    private final LinkedList<Object> values = new LinkedList<Object>();

    /**
     * 在列表之前增加
     * 
     * @param value
     */
    public void before(Object value) {
        values.addFirst(value);
    }

    /**
     * 在列表之后增加
     * 
     * @param value
     */
    public void after(Object value) {
        values.addLast(value);
    }

    public Object[] toArray() {
        return values.toArray();
    }

    /**
     * To Array
     * 
     * @return
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * 静态方法 合并值
     * 
     * @param v1
     * @param v2
     * @param others
     * @return
     */
    public static final RDBValues merageRDBValues(RDBValues v1, RDBValues v2, RDBValues... others) {
        RDBValues result = new RDBValues();
        result.values.addAll(v1.values);
        result.values.addAll(v2.values);

        if (others != null && others.length > 0) {
            for (RDBValues other : others) {
                result.values.addAll(other.values);
            }
        }
        return result;
    }
}
