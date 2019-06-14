/**   
 * Filename:    OptionGET.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.operation;

import cn.com.yves.server.exception.ExceptionGET;
import cn.com.yves.server.exception.RESTfulExceptionGen;
import cn.com.yves.server.status.RESTfulStatusGen;
import cn.com.yves.server.status.StatusGET;

/**
 * 
 * @author Yves He
 * 
 */
public class OptionGET extends RESTfulBasicOption {

    @Override
    public ExceptionGET exception() {
        return RESTfulExceptionGen.EXCEPTION_GET;
    }

    @Override
    public StatusGET status() {
        return RESTfulStatusGen.STATUS_GET;
    }
}
