package com.tmhp.platform.core.util;

import java.util.List;
import java.util.function.Function;

import com.tmhp.platform.core.bean.ReflectEntity;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public class FunctionUtils {

    private static final Function<ReflectEntity, Object> ONE_P_ONE_R = (entity) -> {
        Object result = null;
        try {
            if (entity.getParamsTypes() == null) {
                result = entity.getMapper().getClass().getMethod(entity.getMethod()).invoke(entity.getMapper(), entity.getParams());
            } else {
                result = entity.getMapper().getClass().getMethod(entity.getMethod(), entity.getParamsTypes()).invoke(entity.getMapper(),
                        entity.getParams());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    };

    public static Object invoke(ReflectEntity entity) {
        return ONE_P_ONE_R.apply(entity);
    }

    @SuppressWarnings("rawtypes")
    public static List invokeList(ReflectEntity entity) {
        return (List) ONE_P_ONE_R.apply(entity);
    }
}
