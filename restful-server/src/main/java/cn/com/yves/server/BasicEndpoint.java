/**   
 * Filename:    BasicEndPoint.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import cn.com.yves.module.core.exception.InfraException;
import cn.com.yves.server.exception.RESTfulException;
import cn.com.yves.server.operation.OptionDELETE;
import cn.com.yves.server.operation.OptionGET;
import cn.com.yves.server.operation.OptionPOST;
import cn.com.yves.server.operation.OptionPUT;
import cn.com.yves.server.status.RESTfulStatusGen;

/**
 * Endpoint基类
 * 
 * 其他所有的业务相关的Endpoint都是继承该类,该类定义了一些共用的方法.
 * 
 * @author Yves He
 * 
 */
public abstract class BasicEndpoint {

    /*
     * 属性bean交由spring管理,request在容器中已经存在,不需要在Application.xml写?
     */
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;// 给每一个请求都给一个状态码

    /**
     * 定义所有的操作,方便子类调用:GET,POST,PUT,DELTE
     */
    public static final OptionPOST OPTIONS_POST = new OptionPOST();
    public static final OptionDELETE OPTIONS_DELETE = new OptionDELETE();
    public static final OptionPUT OPTIONS_PUT = new OptionPUT();
    public static final OptionGET OPTIONS_GET = new OptionGET();

    public RESTfulResult success(HttpStatus status) {
        response.setStatus(status.value());
        return this.success(status, null);
    }

    public RESTfulResult success(HttpStatus status, Object data) {
        return this.success(status, data, null);
    }

    public RESTfulResult success(HttpStatus status, Object data, Integer totalSize) {
        response.setStatus(status.value());
        Integer datasize = null;
        // 判断是否为集合
        if (data != null) {
            if (data instanceof Collection) {
                datasize = ((Collection<?>) data).size();
            } else if (data instanceof Object[]) {
                datasize = ((Object[]) data).length;
            }
        }
        return new RESTfulResult(status.value(), status.getReasonPhrase(), true, "Successful", data, datasize, totalSize);
    }

    public RESTfulResult error(HttpStatus status, String message) {
        response.setStatus(status.value());
        return new RESTfulResult(status.value(), status.getReasonPhrase(), true, message, null, null, null);
    }

    /**
     * 根据异常-确定异常的类型
     * 
     * @param e
     * @return
     */
    public RESTfulResult error(Throwable e) {// For: 确认异常的status
        HttpStatus status = null;
        if (e instanceof RESTfulException) {// resful-server:restful异常
            status = ((RESTfulException) e).getHttpStatus();
        }

        if (status == null) {
            status = this.buzError(e);
        }

        if (status == null) {
            if (e instanceof cn.com.yves.module.core.exception.InfraException) {// core:服务器内部异常
                // 根据内部的异常类别,细分该异常的status
                int type = ((cn.com.yves.module.core.exception.InfraException) e).getType();
                if (type == InfraException.PERSIST || type == InfraException.INVALID || type == InfraException.NOT_FOUND_BO) {
                    status = RESTfulStatusGen.STATUS_ALL.newUnprocessableEntity();
                }
            }
        }

        if (status == null) {
            status = RESTfulStatusGen.STATUS_ALL.newInternalServerError();
        }

        return this.error(status, e.getMessage());
    }

    /**
     * 根据业务需求, 自定义httpstatus
     * 
     * @return
     */
    public HttpStatus buzError(Throwable e) {
        // TODO
        return null;
    }
}
