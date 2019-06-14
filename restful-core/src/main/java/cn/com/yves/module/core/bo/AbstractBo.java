/**   
 * Filename:    AbstractBo.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-13
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.bo;

public abstract class AbstractBo implements Bo {

    private static final long serialVersionUID = -7950345852828859114L;

    public abstract AbstractBo snapshot();

    @Override
    public AbstractBo clone() throws CloneNotSupportedException {
        return (AbstractBo) super.clone();
    }

}
