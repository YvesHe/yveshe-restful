/**   
 * Filename:    UserFilter.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-12
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.bo.filter;

import cn.com.yves.module.core.bo.Filter;

/**
 * 业务Bean 根据界面需求来定义需要的属性字段
 * 
 * @author Yves He
 * 
 */
public class UserFilter extends Filter {

    /* PS:如果是高级的多表查询,可以在这里写其他表的过滤查询Filter,然后在mapper.xml中写高级查询sql语句即可. */

    private String name;

    private Integer age;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
