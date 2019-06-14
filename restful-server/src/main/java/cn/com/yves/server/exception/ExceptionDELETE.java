/**   
 * Filename:    ExceptionDELETE.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.exception;

/**
 * Exception DELETE 操作异常(覆盖父类方法.)
 * 
 * @author Yves He
 * 
 */
public class ExceptionDELETE extends RESTfulExceptionGen {

    @Override
    public RESTfulException newInternalServerError(String msg) {
        return super.newInternalServerError(msg);
    }

    @Override
    public RESTfulException newGone(String msg) {
        return super.newGone(msg);
    }
}
