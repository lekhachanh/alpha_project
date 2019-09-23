package alpha.controller;

import alpha.model.User;
import alpha.model.UserForm;
import alpha.service.UserFormService;
import alpha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    Environment env;

    @Autowired
    UserService userService;

    @Autowired
    UserFormService userFormService;

    @GetMapping("/users")
    public ModelAndView listUsers(@RequestParam("s") Optional<String> s, @PageableDefault(10) Pageable pageable){
        Page<User> users;
        if(s.isPresent()){
            users = userService.findAllByEmailContaining(s.get(), pageable);
        } else {
            users = userService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateUserForm(){
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("userForm", new UserForm());
        modelAndView.addObject("message", "");
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/user/create");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        if (userFormService.isPass(userForm)) {
            User user = new User();
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            try {
                userService.save(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelAndView.addObject("message", "New user created successfully");
            return modelAndView;
        }
        modelAndView.addObject("message", "New user created error");
        return modelAndView;
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditUserForm(@PathVariable Long id){
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/user/edit");;
        if(user != null) {
            UserForm userForm = new UserForm(user.getId(), user.getEmail(), user.getPassword(), user.getPassword());
            modelAndView.addObject("userForm", userForm);
        }else {
            modelAndView.addObject("message", "User ID not exist");
        }
        return modelAndView;
    }

    @PostMapping("/edit-user")
    public ModelAndView updateUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/user/edit");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        if (userFormService.isPass(userForm)) {
            User user = new User();
            user.setId(userForm.getId());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            try {
                userService.save(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelAndView.addObject("message", "User updated successfully ");
            return modelAndView;
        }
        modelAndView.addObject("message", "User updated error ");
        return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteUserForm(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("/user/delete");
            modelAndView.addObject("user", user);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.remove(user.getId());
        return "redirect:users";
    }

    @GetMapping("/view-user/{id}")
    public ModelAndView viewUser(@PathVariable("id") Long id, @PageableDefault(10) Pageable pageable){
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/user/view");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
