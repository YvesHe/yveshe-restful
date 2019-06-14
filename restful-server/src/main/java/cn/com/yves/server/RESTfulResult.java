/**   
 * Filename:    RESTfulResult.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.server;

import java.io.Serializable;

/*
 *  除去下载文件,系统返回的数据结构都是RESTfulResult的结构体形式 
 */
public class RESTfulResult implements Serializable {

    private static final long serialVersionUID = 7544975979376795203L;

    // HTTP状态码,设置在HTTP Response中，比如＂200＂
    private int status;

    // 小短语,对HTTP状态码的描述, 比如:＂OK＂
    private String resonPhrase;

    // 是否成功,true/false
    private boolean success;

    // 结果描述,比如"message"
    private String message;

    // 返回结果数据, 数据为[] ,个体对象为{}
    private Object data;

    // 当data是数组时,datasize代表数组的大小
    private Integer datasize;

    // 当get请求包含分页参数(offset 和row_count)时,表示总记录数?
    private Integer totalsize;

    public RESTfulResult() {

    }

    public RESTfulResult(int status, String resonPhrase, boolean success, String message, Object data, Integer datasize, Integer totalsize) {
        super();
        this.status = status;
        this.resonPhrase = resonPhrase;
        this.success = success;
        this.message = message;
        this.data = data;
        this.datasize = datasize;
        this.totalsize = totalsize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResonPhrase() {
        return resonPhrase;
    }

    public void setResonPhrase(String resonPhrase) {
        this.resonPhrase = resonPhrase;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getDatasize() {
        return datasize;
    }

    public void setDatasize(Integer datasize) {
        this.datasize = datasize;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
    }

}
