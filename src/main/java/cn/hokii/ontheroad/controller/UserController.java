package cn.hokii.ontheroad.controller;

import cn.hokii.ontheroad.model.Production;
import cn.hokii.ontheroad.model.Result;
import cn.hokii.ontheroad.model.User;
import cn.hokii.ontheroad.service.ProductionService;
import cn.hokii.ontheroad.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin  //允许跨域
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(path="/login",method = RequestMethod.GET)
    public String getLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null) {
            return "redirect:index";
        }
        return "login";
    }

    @RequestMapping(path="/login",method = RequestMethod.POST)
    public String postLogin(Model model,
                            HttpSession session,
                            @RequestParam String phone,
                            @RequestParam String password) {
        Result result = new Result();
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        log.info("接收到的对象："+ String.valueOf(user));
        Result res = userService.login(user);
        log.info(String.valueOf(res));
        log.info(String.valueOf(userService.getUserByPhone(phone)));
        if(res.getErrorType() == 0) {
            session.setAttribute("user", userService.getUserByPhone(phone));
            return "redirect:/index";
        }else {
            model.addAttribute("error", res);
            return "login";
        }
    }

    @RequestMapping(path="/register",method = RequestMethod.GET)
    public String getRegister(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null) {
            return "redirect:index";
        }
        return "register";
    }

    @RequestMapping(path="/checkPhone",method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkPhone(@RequestParam("phone") String phone) {
        User user = userService.getUserByPhone(phone);
        log.info(String.valueOf(user));
        return user == null;
    }

    @RequestMapping(path="/checkPassword",method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkPassword(@RequestParam("phone") String phone,
                                 @RequestParam("password") String password) {
        User user = userService.getUserByPhone(phone);
        return user.getPassword().equals(password);
    }

    @RequestMapping(path="/register",method = RequestMethod.POST)
    public String postRegister(HttpSession session,
                               ModelMap modelMap,
                               @RequestParam("username") String username,
                               @RequestParam("sex") String sex,
                               @RequestParam("birthday") String birthday,
                               @RequestParam("phone") String phone,
                               @RequestParam("password") String password
                               ) {
        User user = new User(username, sex, birthday, phone, password);
        log.info("接收到的对象" + String.valueOf(user));
        Result result = userService.register(user);
        log.info("结果是"+ String.valueOf(result));
        if(result.getState()){
            return "redirect:/login";
        }else {
            return "register";
        }
    }

    @RequestMapping(path="/userInformation",method = RequestMethod.GET)
    public String getUserInformation(HttpSession session,
                           Model model) {
        User user = (User) session.getAttribute("user");
        log.info(String.valueOf(user));
        if (user!=null) {
            return "user-information";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(path="/completeInformation",method = RequestMethod.POST)
    public String completeInformation(HttpSession session,
                                      @RequestParam("name") String name,
                                      @RequestParam("identityNumber") String identityNumber,
                                      @RequestParam("job") String job) {
        User user = (User) session.getAttribute("user");
        log.info(name + identityNumber + job);
        if (user!=null) {
            user.setName(name);
            user.setIdentityNumber(identityNumber);
            user.setJob(job);
            log.info(String.valueOf(user));
            if(userService.completeInformation(user)) {
                log.info("success");
            } else {
                log.info("fail");
            }
            return "redirect:/userInformation";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(path="/changePassword",method = RequestMethod.POST)
    public String changePassword(HttpSession session,
                                      Model model,
                                 @RequestParam("newPassword") String newPassword) {
        User user = (User) session.getAttribute("user");
        log.info(user.getPassword());
        log.info(newPassword);
        int result = userService.changePassword(user.getUserId(), newPassword);
        log.info(String.valueOf(result));
        if (result == 1) {
            model.addAttribute("message","修改成功");
        }
        return "user-information";
    }

    @RequestMapping(path="/checkPrimaryPassword",method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkPrimaryPassword(HttpSession session,
                                        @RequestParam("primaryPassword") String primaryPassword) {
        User user = (User) session.getAttribute("user");
        log.info(String.valueOf(user));
        return user.getPassword().equals(primaryPassword);
    }
}
