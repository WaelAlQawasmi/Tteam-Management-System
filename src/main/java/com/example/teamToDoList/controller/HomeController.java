package com.example.teamToDoList.controller;


import com.example.teamToDoList.Repositories.UsersRepositorie;
import com.example.teamToDoList.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UsersRepositorie usersRepositorie;

    public HomeController(UsersRepositorie usersRepositorie) {
        this.usersRepositorie = usersRepositorie;
    }

    @GetMapping ("/")
    public String homePage () {
        return "home";
    }


    @GetMapping("/signup")
    public String signupPage () {
        return "signup";
    }

    @PostMapping ("/signup")
    public RedirectView signupPost (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String birthDay, @RequestParam String position, @RequestParam String address, @RequestParam String phone, @RequestParam String username, @RequestParam String password) {
        String passwordEncoded = passwordEncoder.encode(password);
        Users users = new Users(firstName, lastName, email, birthDay, position, address, phone, username, passwordEncoded);
        usersRepositorie.save(users);
        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String loginPage () {
        return "login";
    }

    @GetMapping ("/listprofile")
    public String toDoListProfile () {
        return "todolistprofile";

    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }
        @GetMapping("/todolistname")
        public String toDoListName () {
            return "toDoListName";

        }
        @GetMapping("/error")
        public String error () {
            return "error";

        }
        @GetMapping("/header")
        public String header () {
            return "header";

        }


        @GetMapping("/forgot")
        public String forgotPage () {
            return "forgot";
        }
        @GetMapping("/task")
        public String task () {
            return "myTask";

        }

        @GetMapping("/profile")
        public String userProfile () {
            return "userProfile";


        }
    }
