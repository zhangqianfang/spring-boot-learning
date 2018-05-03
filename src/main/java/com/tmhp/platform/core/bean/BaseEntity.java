package com.tmhp.platform.core.bean;

import java.io.Serializable;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 4282843694315256853L;

    protected Integer dataId;

    public Integer getDataId() {
        return this.dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }
}
