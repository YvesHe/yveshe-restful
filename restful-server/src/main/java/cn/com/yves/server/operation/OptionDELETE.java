/**   
 * Filename:    OptionDELETE.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.operation;

import cn.com.yves.server.exception.ExceptionDELETE;
import cn.com.yves.server.exception.RESTfulExceptionGen;
import cn.com.yves.server.status.RESTfulStatusGen;
import cn.com.yves.server.status.StatusDELETE;

/**
 * 
 * @author Yves He
 * 
 */
public class OptionDELETE extends RESTfulBasicOption {

    @Override
    public ExceptionDELETE exception() {
        return RESTfulExceptionGen.EXCEPTION_DELETE;
    }

    @Override
    public StatusDELETE status() {
        return RESTfulStatusGen.STATUS_DELETE;
    }
}
