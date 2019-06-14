/**   
 * Filename:    InfraService.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-13
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core;

/**
 * 框架服务-最好在项目已启动就执行框架服务,方便项目中对框架资源的调用
 * 
 * 1.系统属性资源
 * 
 * 2.国际化资源
 * 
 * @author Yves He
 * 
 */
public class InfraService {

    public void init() {

        /* system info */
        InfraSystemInfo.getInstance();

        /* 加载国际化资源 */
        InfraResource.load();

    }

}
