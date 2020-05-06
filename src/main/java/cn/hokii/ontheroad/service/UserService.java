package cn.hokii.ontheroad.service;

import cn.hokii.ontheroad.model.Result;
import cn.hokii.ontheroad.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    Result login(User user);

    User getUserByUserId(int userId);

    User getUserByPhone(String phone);

    Result register(User user);

    Boolean completeInformation(User user);

    int getUserIdByPhone(String phone);

    int changePassword(int userId, String newPassword);


}
