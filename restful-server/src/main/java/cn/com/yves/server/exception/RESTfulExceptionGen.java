/**   
 * Filename:    RESTfulExceptionGen.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server.exception;

import cn.com.yves.server.status.RESTfulStatusGen;

/**
 * RESTful 异常生成类(定义常用异常,项目中能用到的所有异常.)
 * 
 * @author Yves He
 * 
 */
public class RESTfulExceptionGen {

    public static final AllRESTfulException EXCEPTION_ALL = new AllRESTfulException();
    public static final ExceptionPOST EXCEPTION_POST = new ExceptionPOST();
    public static final ExceptionDELETE EXCEPTION_DELETE = new ExceptionDELETE();
    public static final ExceptionPUT EXCEPTION_PUT = new ExceptionPUT();
    public static final ExceptionGET EXCEPTION_GET = new ExceptionGET();

    /* 定义所有的异常 */

    /**
     * 400 - 请求有误,服务器没有进行新增或修改数据的操作.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newBadRequest(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newBadRequest(), msg);
    }

    /**
     * 401 - 表示用户没有权限(令牌,用户名,密码错误)
     * 
     * @param msg
     * @return
     */
    public RESTfulException newUnauthorized(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newUnauthorized(), msg);
    }

    /**
     * 403 -用户得到授权,但是访问是被禁止.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newForbidden(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newForbidden(), msg);
    }

    /**
     * 404 -用户请求的对象不存在,服务器没有进行操作.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newNotFound(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newNotFound(), msg);
    }

    /**
     * 406 -用户请求的格式不合法.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newNotAcceptable(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newNotAcceptable(), msg);
    }

    /**
     * 410 -用户请求的资源被删除.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newGone(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newGone(), msg);
    }

    /**
     * 422 - 用户创建一个对象时,验证错误.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newUnprocessableEntity(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newUnprocessableEntity(), msg);
    }

    /**
     * 500 - 服务器内部错误.
     * 
     * @param msg
     * @return
     */
    public RESTfulException newInternalServerError(String msg) {
        return new RESTfulException(RESTfulStatusGen.STATUS_ALL.newInternalServerError(), msg);
    }

}
