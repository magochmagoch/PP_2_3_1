package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(ModelMap model,
                        @ModelAttribute("user") User user) {
        model.addAttribute("users", userService.readAllUsers());
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        User user0 = userService.readUserById(user.getId());
        user0.setName(user.getName());
        user0.setEmail(user.getEmail());
        userService.updateUser(user0);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/";
    }

}