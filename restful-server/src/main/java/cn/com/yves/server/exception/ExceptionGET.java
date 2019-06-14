/**   
 * Filename:    ExceptionGET.java   
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
 * Exception GET 操作异常(覆盖父类方法.)
 * 
 * @author Yves He
 * 
 */
public class ExceptionGET extends RESTfulExceptionGen {

    @Override
    public RESTfulException newBadRequest(String msg) {
        return super.newBadRequest(msg);
    }

    @Override
    public RESTfulException newUnprocessableEntity(String msg) {
        return super.newUnprocessableEntity(msg);
    }

    @Override
    public RESTfulException newNotAcceptable(String msg) {
        return super.newNotAcceptable(msg);
    }

}
