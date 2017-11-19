package com.lanou3g.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by dllo on 17/11/9.
 */
/*
    泛型也可以称之为类的参数
    参数的类型是某个类,而不是对象
    T:type
    E:Element/Entity
 */
public class BaseAction<T,S> extends ActionSupport implements ModelDriven<T> {

    private T model;
    protected  S service;

    public BaseAction(){
        //获取当前类的Class
        Class<? extends BaseAction> clazz = getClass();

        //获取父类的泛型参数

        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        //获取所有的泛型的集合(因为可能会有多个泛型)
        Type[] typeArguments = type.getActualTypeArguments();

        //因为当前类只有一个泛型参数,所以取第0个,就获取到了泛型的Class
        Class modelClass = (Class) typeArguments[0];

        //根据反射创建出泛型的对象
        try {
            model = (T) modelClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public T getModel() {
        return model;
    }

    //向Session中存放数据
    public void sessionPut(String key,Object value){
        ActionContext.getContext().getSession().put(key, value);
    }

    public void sessionGet(String key){
        ActionContext.getContext().getSession().get(key);
    }


    public void applicationPut(String key,Object value){
        ActionContext.getContext().getApplication().put(key, value);
    }


    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }
    public HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }



    public void setService(S service) {
        this.service = service;
    }


}
