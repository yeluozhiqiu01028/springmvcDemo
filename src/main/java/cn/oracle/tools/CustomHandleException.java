package cn.oracle.tools;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 自定义异常处理器
 */
public class CustomHandleException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg;
        //如果当前异常属于自定义异常类
        if (e instanceof MyException){
             msg=e.getMessage();
        }else{
            // 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            msg=stringWriter.toString();
        }

        //返回友好的的错误界面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",msg);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
