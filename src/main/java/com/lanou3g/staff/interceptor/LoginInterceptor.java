package com.lanou3g.staff.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/17.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object login = ServletActionContext.getContext().getSession().get("login");
        if (login==null){

            return "input";
        }
        return actionInvocation.invoke();
    }
}
