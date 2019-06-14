/**   
 * Filename:    RESTfulStatusGen.java   
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

/*
 * 基本常用的httpstatus
 */
public class RESTfulStatusGen {

    public static final AllRESETfulStatus STATUS_ALL = new AllRESETfulStatus();
    public static final StatusPOST STATUS_POST = new StatusPOST();
    public static final StatusDELETE STATUS_DELETE = new StatusDELETE();
    public static final StatusPUT STATUS_PUT = new StatusPUT();
    public static final StatusGET STATUS_GET = new StatusGET();

    /**
     * 默认的成功状态,子类重写该方法.
     * 
     * @return
     */
    public HttpStatus newSuccess() {
        return null;
    }

    /**
     * 200 - 服务器成功返回用户数据.
     * 
     * @return
     */
    public HttpStatus newOk() {
        return HttpStatus.OK;
    }

    /**
     * 201 - 新建或修改数据成功.
     * 
     * @return
     */
    public HttpStatus newCreated() {
        return HttpStatus.CREATED;
    }

    /**
     * 202 - 表示一个请求已计入后台排队.
     * 
     * @return
     */
    public HttpStatus newAccepted() {
        return HttpStatus.ACCEPTED;
    }

    /**
     * 204 - 用户删除数据成功.
     * 
     * @return
     */
    public HttpStatus newNoContent() {
        return HttpStatus.NO_CONTENT;
    }

    /**
     * 400 - 请求有误,服务器没有进行新增或修改数据的操作.
     * 
     * @return
     */
    public HttpStatus newBadRequest() {
        return HttpStatus.BAD_REQUEST;
    }

    /**
     * 401 - 表示用户没有权限(令牌,用户名,密码错误)
     * 
     * @return
     */
    public HttpStatus newUnauthorized() {
        return HttpStatus.UNAUTHORIZED;
    }

    /**
     * 403 -用户得到授权,但是访问是被禁止.
     * 
     * @return
     */
    public HttpStatus newForbidden() {
        return HttpStatus.FORBIDDEN;
    }

    /**
     * 404 -用户请求的对象不存在,服务器没有进行操作.
     * 
     * @return
     */
    public HttpStatus newNotFound() {
        return HttpStatus.NOT_FOUND;
    }

    /**
     * 406 -用户请求的格式不合法.
     * 
     * @return
     */
    public HttpStatus newNotAcceptable() {
        return HttpStatus.NOT_ACCEPTABLE;
    }

    /**
     * 410 -用户请求的资源被删除.
     * 
     * @return
     */
    public HttpStatus newGone() {
        return HttpStatus.GONE;
    }

    /**
     * 422 - 用户创建一个对象时,验证错误.
     * 
     * @return
     */
    public HttpStatus newUnprocessableEntity() {

        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

    /**
     * 500 - 服务器内部错误.
     * 
     * @return
     */
    public HttpStatus newInternalServerError() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
