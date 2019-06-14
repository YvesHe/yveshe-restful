/**   
 * Filename:    BasicOption.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.operation;

import cn.com.yves.server.exception.RESTfulExceptionGen;
import cn.com.yves.server.status.RESTfulStatusGen;

/**
 * 每一个操作对应 : 一个异常和一个状态
 * 
 * @author Yves He
 * 
 */
public abstract class RESTfulBasicOption {

    public abstract RESTfulExceptionGen exception();

    public abstract RESTfulStatusGen status();

}
