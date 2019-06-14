/**   
 * Filename:    SeniorFilter.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-10-23
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.bo.filter;

import java.util.List;

import cn.com.yves.module.core.bo.Bo;

/**
 * 高级查询结构体:
 * 
 * @author Yves He
 * 
 */
public class SeniorFilter {

    private final List<String> sorts;

    private final Integer limitoffset;
    private final List<String> limitRowCount;

    private final List<String> keys;

    /**
     * 构造方法: 高级查询的结构体来自 Bo层的结构
     * 
     * @param clazz
     * @param sorts
     * @param limitoffset
     * @param limitRowCount
     * @param keys
     */
    public SeniorFilter(Class<? extends Bo> clazz, List<String> sorts, Integer limitoffset, List<String> limitRowCount, List<String> keys) {
        super();// 代码自动生成的
        this.sorts = sorts;
        this.limitoffset = limitoffset;
        this.limitRowCount = limitRowCount;
        this.keys = keys;

    }

    public List<String> getSorts() {
        return sorts;
    }

    public Integer getLimitoffset() {
        return limitoffset;
    }

    public List<String> getLimitRowCount() {
        return limitRowCount;
    }

    public List<String> getKeys() {
        return keys;
    }

    /**
     * 是否包括key
     * 
     * @return
     */
    public boolean containsKeys() {
        return ((keys != null) && !keys.isEmpty());
    }
}
