/**   
 * Filename:    BoFilter.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-10-23
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.bo.filter;

/**
 * 高级查询-接口
 * 
 * @author Yves He
 * 
 */
public interface BoFilter {

    /**
     * 创建一个高级查询
     * 
     * @return
     */
    SeniorFilter createSeniorFilter();

}
