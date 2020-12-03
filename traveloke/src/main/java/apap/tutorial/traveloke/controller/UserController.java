//package apap.tutorial.traveloke.controller;
//
//import apap.tutorial.traveloke.model.UserModel;
//import apap.tutorial.traveloke.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public String addUserSubmit(
//            @ModelAttribute UserModel user, Model model){
//        userService.addUser(user);
//        model.addAttribute("user", user);
//        return "redirect:/";
//    }
//}

package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(
            @ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute UserModel userModel, String newPassword, String confPassword, Model model){
        UserModel myUser = userService.findUserbyUsername(userModel.getUsername());

        if (userService.isMatch(userModel.getPassword(), myUser.getPassword() )){
            if (newPassword.equals(confPassword)){
                userService.setPassword(myUser, newPassword);
                userService.addUser(myUser);
                model.addAttribute("message", "password berhasil diubah");
            }else {
                model.addAttribute("message", "password tidak sama");
            }
        }else {
            model.addAttribute("message", "password salah");
        }
        return "home";
    }
}

