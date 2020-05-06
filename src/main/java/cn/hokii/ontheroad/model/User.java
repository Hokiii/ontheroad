package cn.hokii.ontheroad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class User {
    private int userId;//用户id
    private int role;//用户角色
    private String name;//姓名
    private String sex;//性别
    private String phone;//手机号
    private String identityNumber;//身份证号
    private String username;//用户名
    private String password;//密码
    private String birthday;//生日
    private String job;//职业

    public User (String username, String sex, String birthday, String phone, String password) {
        this.role = 1;
        this.name = null;
        this.sex = sex;
        this.phone = phone;
        this.identityNumber = null;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.job = null;
    }
}

