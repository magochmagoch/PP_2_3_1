package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

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

    @GetMapping("/create")
    public String createForm(@ModelAttribute User user) {
        return "create";
    }

    @PostMapping("/createauser")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(ModelMap model,
                             @RequestParam("id") int id) {
        model.addAttribute("user", userService.readUserById(id));
        return "update";
    }

    @PostMapping("/updateauser")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}