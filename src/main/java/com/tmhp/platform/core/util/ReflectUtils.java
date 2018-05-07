package com.tmhp.platform.core.util;

import java.lang.reflect.Field;

import org.springframework.util.StringUtils;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public class ReflectUtils {

    /***
     * 判断对象中是否含有某个属性
     * @param obj
     * @param fieldName
     * @return
     */
    public static boolean hasFieldName(Object obj, String fieldName) {
        boolean flag = false;
        if ((obj != null) && !StringUtils.isEmpty(fieldName)) {
            for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
                Field[] fields = superClass.getDeclaredFields();
                for (Field field : fields) {
                    if (fieldName.equals(field.getName())) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 获取obj对象fieldName的Field
     * @param obj
     * @param fieldName
     * @return
     */
    public static Field getFieldByFieldName(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            }
        }
        return null;
    }

    /**
     * 获取obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 设置obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @param value
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }

    //    /**
    //     * 测试主函数
    //     * @param args
    //     */
    //    @SuppressWarnings("rawtypes")
    //    public static void main(String[] args) {
    //        try {
    //            Class cls = Class.forName("com.flf.entity.User");
    //            Field field;
    //            try {
    //                // 得到一个类的实例
    //                Object user = cls.newInstance();
    //                // 调用根据字段名得到字段的方法
    //                field = ReflectUtils.getFieldByFieldName(user, "loginname");
    //                System.out.println(field.getName());
    //
    //                // 根据字段名给字段赋值
    //                ReflectUtils.setValueByFieldName(user, "loginname", "admin");
    //
    //                // 根据字段名获取到字段值
    //                Object nameValue = ReflectUtils.getValueByFieldName(user, "loginname");
    //                System.out.println(nameValue);
    //
    //            } catch (Exception e) {
    //                e.printStackTrace();
    //            }
    //        } catch (ClassNotFoundException e) {
    //            e.printStackTrace();
    //        }
    //
    //    }
}
