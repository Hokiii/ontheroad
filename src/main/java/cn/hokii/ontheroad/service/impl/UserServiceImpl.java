package cn.hokii.ontheroad.service.impl;

import cn.hokii.ontheroad.dao.UserDao;
import cn.hokii.ontheroad.model.Result;
import cn.hokii.ontheroad.model.User;
import cn.hokii.ontheroad.service.UserService;
import cn.hokii.ontheroad.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Result login(User user) {
        Result result = new Result();
        User user1 = userDao.getUserByPhone(user.getPhone());
        try {
            if(user1 == null){
                result.setErrorType(1);
                throw  new RuntimeException("用户名输入错误！");
            } else {
                if(!user.getPassword().equals(user1.getPassword())){
                    result.setErrorType(2);
                    throw  new RuntimeException("密码输入错误！");
                } else {
                    String token = MD5.encode("HOKII_" + Math.random() + "$" + user.getPhone());
                    result.setState(true);
                    result.setMsg("登录成功！");
                    result.setToken(token);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public User getUserByPhone(String phone) {
//        User user = userDao.getUserByPhone(phone);
//        int userId = userDao.getUserIdByPhone(phone);
//        user.setUserId(userId);
        return  userDao.getUserByPhone(phone);
    }

    @Override
    public Result register(User user) {
        Result result = new Result();
        if(userDao.insertUser(user)==1){
            result.setState(true);
            result.setMsg("注册成功！");
        }else {
            result.setState(false);
            result.setMsg("注册失败！");
            result.setErrorType(1);
        }
        return result;
    }

    @Override
    public int getUserIdByPhone(String phone) {
        return userDao.getUserIdByPhone(phone);
    }

    @Override
    public int changePassword(int userId, String newPassword) {
        return userDao.changePassword(userId,newPassword);
    }

    @Override
    public Boolean completeInformation(User user) {

        int result = userDao.completeInformation(user.getUserId(),user.getName(),user.getIdentityNumber(),user.getJob());
        return result == 1;
    }

}
