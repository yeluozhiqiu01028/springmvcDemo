package cn.oracle.tools;


import cn.oracle.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器
 */
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 进入controller 之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不包含/login 代表不是登录方法 要进行判断
        if (!(request.getRequestURI()).contains("/login")){
            User user = (User) request.getSession().getAttribute("user");
            if (user!=null){
                //域里边有，代表用户已经登陆过了
                return true;
            }else{
                //域里边没有，代表用户未登录 重定向
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle.............");
    }

    //进入controller 之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...........");
    }
}
