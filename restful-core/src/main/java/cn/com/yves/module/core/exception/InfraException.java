/**   
 * Filename:    InfraException.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-8-8
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.exception;

/**
 * 异常框架:InfraException
 * 
 * Exception extends Throwable-Throwable implements Serializable : 异常框架可以序列化.
 * 
 * @author Yves He
 * 
 */
public class InfraException extends Exception {

    private static final long serialVersionUID = 6457774533050499067L;

    public static final int DEFAULT = 0x0;
    public static final int PERSIST = 0x100;
    public static final int INVALID = 0x200;
    public static final int NOT_FOUND_BO = 0x300;

    private int type = DEFAULT;

    /* 构造方法 */
    public InfraException(String message) {
        super(message);
    }

    public InfraException(int type, String message) {
        super(message);
        this.type = type;
    }

    public InfraException(InfraException infraException) {
        super(infraException);
        this.type = infraException.type;
    }

    public InfraException(String message, InfraException infraException) {
        super(message, infraException);
        this.type = infraException.type;
    }

    /* get */
    public int getType() {
        return type;
    }

    /* toString */
    @Override
    public String toString() {
        switch (type) {
        case PERSIST:
            return "Persist Exception : " + super.toString();
        case INVALID:
            return "Invalid Bo Exception : " + super.toString();
        case NOT_FOUND_BO:
            return "Not Found Bo Exception : " + super.toString();
        }
        return super.toString();
    }
    /*
     * Throwable的toString方法:
     * 
     * 返回此对象的类的 name ": "（冒号和一个空格） 调用此对象 getLocalizedMessage() 方法的结果;
     * 
     * 如果 getLocalizedMessage 返回 null，则只返回类名称。
     */

}
