/**   
 * Filename:    StatusGET.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-11
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.status;

import org.springframework.http.HttpStatus;

public class StatusGET extends RESTfulStatusGen {

    @Override
    public HttpStatus newSuccess() {
        return this.newOk();
    }

    @Override
    public HttpStatus newForbidden() {
        return super.newForbidden();
    }

    @Override
    public HttpStatus newGone() {
        return super.newGone();
    }

    @Override
    public HttpStatus newNotFound() {
        return super.newNotFound();
    }

    @Override
    public HttpStatus newOk() {
        return super.newOk();
    }

}
