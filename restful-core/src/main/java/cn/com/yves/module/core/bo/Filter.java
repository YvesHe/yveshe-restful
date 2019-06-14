/**   
 * Filename:    Filter.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-12
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.bo;

/**
 * 条件查询的根
 * 
 * @author Yves He
 * 
 */
public abstract class Filter {

    /* 排序 */
    private String[] sorts;

    /* 起始下标 */
    private Integer offset;

    /* 长度 */
    private Integer rowCount;

    public String[] getSorts() {
        return sorts;
    }

    public void setSorts(String[] sorts) {
        this.sorts = sorts;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

}
