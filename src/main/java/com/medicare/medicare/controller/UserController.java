package com.medicare.medicare.controller;

import com.medicare.medicare.entity.User;
import com.medicare.medicare.exception.DuplicateResourceException;
import com.medicare.medicare.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/verify")
    public String verifyUser (@RequestParam("email") String email,
                              @RequestParam("token") String token) throws Exception {
        userService.verifyUser(email,token);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) throws DuplicateResourceException {
        userService.save(user);
        return "redirect:/";
    }

}
