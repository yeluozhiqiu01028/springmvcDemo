package cn.oracle.controller;

import cn.oracle.tools.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex")
public class ExceptionCotTroller {

    @RequestMapping("queryEx")
    public String queryEx() throws MyException {
        // 自定义异常
        if (true) {
            throw new MyException();
        }
                int a =1/0;

        return "main";
    }

}
