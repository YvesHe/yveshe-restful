/**   
 * Filename:    OptionPUT.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.operation;

import cn.com.yves.server.exception.ExceptionPUT;
import cn.com.yves.server.exception.RESTfulExceptionGen;
import cn.com.yves.server.status.RESTfulStatusGen;
import cn.com.yves.server.status.StatusPUT;

/**
 * 
 * @author Yves He
 * 
 */
public class OptionPUT extends RESTfulBasicOption {

    @Override
    public ExceptionPUT exception() {
        return RESTfulExceptionGen.EXCEPTION_PUT;
    }

    @Override
    public StatusPUT status() {
        return RESTfulStatusGen.STATUS_PUT;
    }
}
