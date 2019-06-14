/**   
 * Filename:    StatusPUT.java   
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

public class StatusPUT extends RESTfulStatusGen {

    @Override
    public HttpStatus newSuccess() {
        return this.newOk();
    }

    @Override
    public HttpStatus newOk() {
        return super.newOk();
    };

    @Override
    public HttpStatus newBadRequest() {
        return super.newBadRequest();
    }

    @Override
    public HttpStatus newUnauthorized() {
        return super.newUnauthorized();
    }

}
