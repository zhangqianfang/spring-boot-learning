package com.tmhp.platform.core.bean;

/***
 * 
 * @author zqf
 * @date 2018年5月3日
 */
public class ReflectEntity {

    private final Object mapper;
    private final String method;
    private final Object[] params;
    @SuppressWarnings("rawtypes")
    private final Class[] paramsTypes;

    public ReflectEntity(Object mapper, String method, Object[] params) {
        this.mapper = mapper;
        this.method = method;
        this.params = params;
        this.paramsTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramsTypes[i] = params[i].getClass();
        }
    }

    public ReflectEntity(Object mapper, String method, Object[] params, @SuppressWarnings("rawtypes") Class[] paramsTypes) {
        this.mapper = mapper;
        this.method = method;
        this.params = params;
        this.paramsTypes = paramsTypes;
    }

    public Object getMapper() {
        return this.mapper;
    }

    public String getMethod() {
        return this.method;
    }

    public Object[] getParams() {
        return this.params;
    }

    @SuppressWarnings("rawtypes")
    public Class[] getParamsTypes() {
        return this.paramsTypes;
    }
}
