package cn.hokii.ontheroad.dao;

import cn.hokii.ontheroad.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    @Select("select * from users")
    List<User> getAll();

    @Select("Select * From users Where user_id=#{userId}")
    User getUserByUserId(int userId);

    @Select("Select * From users Where phone=#{phone}")
    User getUserByPhone(String phone);

    @Select("select user_id from users where phone=#{phone}")
    int getUserIdByPhone(String phone);

    @Insert("insert into users(username,sex,birthday,phone,password) values (#{username},#{sex},#{birthday},#{phone},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(User user);

    @Update("update users set name=#{name},identity_number=#{identityNumber},job=#{job} Where user_id=#{userId}")
    int completeInformation(int userId,String name,String identityNumber,String job);

    @Update("update users set password=#{newPassword} Where user_id=#{userId}")
    int changePassword(int userId,String newPassword);

}
