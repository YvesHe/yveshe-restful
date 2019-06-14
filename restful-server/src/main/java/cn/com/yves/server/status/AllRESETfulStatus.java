/**   
 * Filename:    AllRESETfulStatus.java   
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

/**
 * 方法全部来自父类
 * 
 * @author Yves He
 * 
 */
public class AllRESETfulStatus extends RESTfulStatusGen {

    @Override
    public HttpStatus newBadRequest() {
        return super.newBadRequest();
    }

    @Override
    public HttpStatus newAccepted() {
        return super.newAccepted();
    }

    @Override
    public HttpStatus newCreated() {
        return super.newCreated();
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
    public HttpStatus newInternalServerError() {
        return super.newInternalServerError();
    }

    @Override
    public HttpStatus newNoContent() {
        return super.newNoContent();
    }

    @Override
    public HttpStatus newNotAcceptable() {
        return super.newNotAcceptable();
    }

    @Override
    public HttpStatus newNotFound() {
        return super.newNotFound();
    }

    @Override
    public HttpStatus newOk() {
        return super.newOk();
    }

    @Override
    public HttpStatus newSuccess() {
        return super.newSuccess();
    }

    @Override
    public HttpStatus newUnauthorized() {
        return super.newUnauthorized();
    }

    @Override
    public HttpStatus newUnprocessableEntity() {
        return super.newUnprocessableEntity();
    }

}
