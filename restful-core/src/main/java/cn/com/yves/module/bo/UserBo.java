/**   
 * Filename:    User.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.bo;

import cn.com.yves.module.core.bo.AbstractBo;

public class UserBo extends AbstractBo {

    private String id;
    private String name;
    private Integer age;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public AbstractBo snapshot() {
        // TODO Auto-generated method stub
        return null;
    }

}
