package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.User;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.UserService;


@Controller
public class SecurityController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String getLoginView() {
        return "Security/login";
    }

    @GetMapping("/gestionnaire/home")
    public String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("msg", "Bonjour " + user.getNom() + " " + user.getPrenom());
        return "gestionnaire/listCommande";
    }

    

     ////registration
    @GetMapping({"/inscription"})
    public String registration(Model model){
       
        return "Security/inscription";
    }
    @GetMapping({"/error"})
    public String error(Model model){
       
        return "Security/error";
    }




    ////registration
    // @GetMapping({"/inscription"})
    // public String registration(Model model){
    //     ModelAndView modelAndView = new ModelAndView();
    //     User users = new Client();

    //     model.addAttribute("users", users);
    //     modelAndView.setViewName("inscription");
    //     return "Security/inscription";
    // }

    // @GetMapping({"/registration"})
    // public String addUser(Model model){
    //     User user = new User();
    //     model.addAttribute("burger", burger);

    //     return null;

    // }

    // @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    // public String createNewUser(@Validated User user, BindingResult bindingResult) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     User userExists = userService.findUserByUserName(user.getUserName());
    //     if (userExists != null) {
    //         bindingResult
    //                 .rejectValue("userName", "error.user",
    //                         "There is already a user registered with the user name provided");
    //     }
    //     if (bindingResult.hasErrors()) {
    //         modelAndView.setViewName("inscription");
    //     } else {
    //         userService.saveUser(user);
    //         modelAndView.addObject("successMessage", "User has been registered successfully");
    //         Role role = userService.findRoleByLibelle("Client");
    //         modelAndView.addObject("user", new Client());
    //         modelAndView.setViewName("inscription");
    //         return "redirect:/catalogue";

    //     }
    //     return "Security/inscription";
    // }

}
