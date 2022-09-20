package cn.oracle.pojo;


import lombok.Data;

import java.util.List;
@Data
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private String image;

    private List<RoleCustom> roles;//当前用户的角色

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", image='" + image + '\'' +
                ", roles=" + roles +
                '}';
    }
}
