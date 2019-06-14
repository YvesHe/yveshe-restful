/**   
 * Filename:    Bo.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.bo;

import java.io.Serializable;

/**
 * 业务Bean根
 * 
 * snapshot方法是为了解决 系统默认的clone方法有异常抛出而自定义的的一个快照方法.
 * 
 * @author Yves He
 * 
 */
public interface Bo extends Cloneable, Serializable {
    Bo snapshot();
}
