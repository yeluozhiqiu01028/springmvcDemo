package cn.oracle.controller;

import cn.oracle.pojo.RoleCustom;
import cn.oracle.pojo.SysUserRole;
import cn.oracle.pojo.UserCustom;
import cn.oracle.services.RoleService;
import cn.oracle.services.SysUserRoleServices;
import cn.oracle.services.UserService;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户控制访问层
 */
@RequestMapping("/user")
@Controller
public class UserController {
    //用户业务层
    @Resource
    private UserService userService;

    //用户角色业务层
    @Resource
    private SysUserRoleServices sysUserRoleServices;

    /**
     * 获取所有用户
     * @param model
     * @return
     */
    @RequestMapping("/getAllUser")
    public String getAllUser(Model model){
        List<UserCustom> allUser = userService.getAllUser();
        model.addAttribute("listUser",allUser);
        /*for (UserCustom custom : allUser) {
            System.out.println("查出来的数据"+custom);
        }*/
        return "user-list";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model, MultipartFile multipartFile,UserCustom userCustom,Long[] roleId) throws IOException {

        System.out.println("同时我也来了"+userCustom);
       //获取上传文件的名称
        String filename = multipartFile.getOriginalFilename();

        //获取文件后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        //System.out.println("文件后缀"+suffix);

        //重新设定文件名称
         filename = UUID.randomUUID().toString().trim().replace("-", "").substring(20)+suffix;
        //System.out.println("通过uuid生成的新id"+filename);

        //3.构建File对象
        File uploadFileUrl = new File("d:/upload/temp/"+filename);

        //如果这个路径不存在
        if (!uploadFileUrl.exists()){
            //创建
            uploadFileUrl.mkdirs();
        }
        //将file交给上传目录
        multipartFile.transferTo(uploadFileUrl);

        //给方法的形参user对象的image属性 赋值
        userCustom.setImage(filename);//将构造好的文件名称 赋值给user对象

        //调方法(添加用户)
        userService.addUser(userCustom);

        //拿到用户的所有职位
        for (Long aLong : roleId) {
                //为第三张表赋值
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(userService.getMaxId());
                sysUserRole.setRoleId(aLong);

                System.out.println("返回的主键"+ userService.getMaxId());
                System.out.println("用户选择的角色"+aLong);
                //调第三张表方法
                sysUserRoleServices.addUserRole(sysUserRole);
        }
            //重定向到 浏览方法上
        return "redirect:/user/getAllUser.action";
    }

    /**
     * 登录
     * @param
     * @return
     */
    @RequestMapping("/login")
    public String login( String username, String password, HttpSession session){
        HashMap<String, String> hashMap = new HashMap<>();
        System.out.println("用户名："+username);
        System.out.println("密码"+password);
        hashMap.put("username",username);
        hashMap.put("password",password);
        UserCustom loginUser = userService.login(hashMap);
        System.out.println(loginUser);
        if (loginUser!= null){
            //把用户存入域中
           session.setAttribute("user",loginUser);
            return "main";
        }else{
            System.out.println("登陆失败");
            return "/login";
        }

    }
}
