package com.tmhp.platform.core.util;

import com.tmhp.platform.core.bean.ReflectEntity;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public class CommonUtils {

    public static ReflectEntity buildEntity(Object mapper, String method, Object... params) {
        return new ReflectEntity(mapper, method, params);
    }
}
