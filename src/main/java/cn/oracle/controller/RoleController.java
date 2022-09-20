package cn.oracle.controller;

import cn.oracle.pojo.RoleCustom;
import cn.oracle.services.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色控制访问层
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    //角色业务层
    @Resource
    private RoleService roleService;

    /**
     * 浏览角色
     * @param model
     * @return
     */
    @RequestMapping("/getAllRole")
    public String getAllRole(Model model){
        List<RoleCustom> allRole = roleService.getAllRole();
        /*for (RoleCustom roleCustom : allRole) {
            System.out.println(roleCustom);
        }*/
        model.addAttribute("listRole",allRole);
        return "role-list";
    }

    /**
     * 添加用户时用户分配角色
     * @param model
     * @return
     */
    @RequestMapping("/allRole")
    public String allRole(Model model){
        List<RoleCustom> allRole = roleService.getAllRole();
        model.addAttribute("roles",allRole);
        return "user-add";
    }

    /**
     * 通过ID删除角色
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        roleService.deleteRoleById(id);
        return "redirect:/role/getAllRole";
    }
}

