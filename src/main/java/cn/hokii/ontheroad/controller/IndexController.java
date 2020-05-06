package cn.hokii.ontheroad.controller;

import cn.hokii.ontheroad.model.*;
import cn.hokii.ontheroad.service.*;
import lombok.extern.slf4j.Slf4j;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin  //允许跨域
@Slf4j
public class IndexController {

    @Autowired
    private ProductionService productionService;

    @Autowired
    private FlightsService flightsService;

    @Autowired
    private CarService carService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

//    public void get() {
//        //打开浏览器，创建httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        //输入网址
//        HttpGet httpGet
//    }

    @RequestMapping(path="/index",method = RequestMethod.GET)
    public String getIndex(HttpSession session,
                           Model model) {
        User user = (User) session.getAttribute("user");
//        log.info(String.valueOf(user));
        List<Production> top5SalesProductions = productionService.getTop5SalesProduction();
//        log.info(String.valueOf(top5SalesProductions));
        List<Flights> top8LowPriceFLights = flightsService.getTop8LowPriceFlights();
        log.info(String.valueOf(top8LowPriceFLights));
        List<Car> top5ScoreCars = carService.getTop5ScoreCars();
        log.info(String.valueOf(top5ScoreCars));
        List<Article> top5LikesArticles = articleService.getTop5LikesArticles();
        log.info(String.valueOf(top5LikesArticles));
        session.setAttribute("top5Productions", top5SalesProductions);
        session.setAttribute("top8LowPriceFlights", top8LowPriceFLights);
        session.setAttribute("top5ScoreCars", top5ScoreCars);
        session.setAttribute("top5LikesArticles", top5LikesArticles);
        if(user!=null) {
            User user1 = userService.getUserByUserId(1);
            log.info(String.valueOf(user1));
            model.addAttribute("username", user.getUsername());
            model.addAttribute("role", user.getRole());
        }
        return "index";
    }

    @RequestMapping(path="/exit",method = RequestMethod.GET)
    public String exit(HttpSession session,
                       Model model) {
        session.removeAttribute("user");
        return "redirect:/index";
    }
}
