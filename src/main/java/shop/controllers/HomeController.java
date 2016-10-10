package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.entity.User;
import shop.services.UserService;

import java.util.List;

/**
 * Created by Администратор on 05.09.2016.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";

    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactUs()
    {
        return "contactUs";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String aboutUs(){
        return "aboutUs";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPanel(){
        return "adminPanel";
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public  String allUsers(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "allUsers";
    }
    @RequestMapping(value = "/socialPage", method = RequestMethod.GET)
    public String social(){
        return "socialPage";
    }

}
