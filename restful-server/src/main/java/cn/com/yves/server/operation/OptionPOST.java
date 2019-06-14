/**   
 * Filename:    OptionPOST.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.operation;

import cn.com.yves.server.exception.ExceptionPOST;
import cn.com.yves.server.exception.RESTfulExceptionGen;
import cn.com.yves.server.status.RESTfulStatusGen;
import cn.com.yves.server.status.StatusPOST;

/**
 * 
 * @author Yves He
 * 
 */
public class OptionPOST extends RESTfulBasicOption {

    @Override
    public ExceptionPOST exception() {
        return RESTfulExceptionGen.EXCEPTION_POST;
    }

    @Override
    public StatusPOST status() {
        return RESTfulStatusGen.STATUS_POST;
    }
}
