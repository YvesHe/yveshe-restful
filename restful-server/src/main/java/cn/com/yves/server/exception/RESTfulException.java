/**   
 * Filename:    RESTfulException.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.exception;

import org.springframework.http.HttpStatus;

/**
 * RESTful异常
 * 
 * @author Yves He
 * 
 */
public class RESTfulException extends Exception {

    private static final long serialVersionUID = -836576178280015977L;

    private final HttpStatus httpStatus;

    public RESTfulException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
