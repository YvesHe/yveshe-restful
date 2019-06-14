/**   
 * Filename:    AbstractBoFilter.java   
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

public class AbstractBoFilter implements BoFilter {

    /**
     * 排序字段(比如 sorts=-name&sorts=desc)
     */
    private List<String> sorts;

    /**
     * 数据的起始偏移量(从结果中的第几天数据开始截取)
     */
    private Integer limitoffset;

    /**
     * 总共要查询的数量(查询出的数据可能小于该数)
     */
    private List<String> limitRowCount;

    /**
     * 查询的关键字
     */
    private List<String> keys;

    private final Class<? extends Bo> clazz;

    public AbstractBoFilter(Class<? extends Bo> clazz) {
        this.clazz = clazz;
    }

    public List<String> getSorts() {
        return sorts;
    }

    public void setSorts(List<String> sorts) {
        this.sorts = sorts;
    }

    public Integer getLimitoffset() {
        return limitoffset;
    }

    public void setLimitoffset(Integer limitoffset) {
        this.limitoffset = limitoffset;
    }

    public List<String> getLimitRowCount() {
        return limitRowCount;
    }

    public void setLimitRowCount(List<String> limitRowCount) {
        this.limitRowCount = limitRowCount;
    }

    public List<String> getKeys() {
        return keys;
    }

    public Class<? extends Bo> getClazz() {
        return clazz;
    }

    public SeniorFilter createSeniorFilter() {
        return new SeniorFilter(clazz, sorts, limitoffset, limitRowCount, keys);
    }

}
