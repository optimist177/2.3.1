package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;

import java.util.List;

@Controller

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "index";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user",userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        userService.updateUser(id,user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
