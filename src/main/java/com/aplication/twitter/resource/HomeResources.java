package com.aplication.twitter.resource;

import com.aplication.twitter.entity.User.User;
import com.aplication.twitter.service.EmailService;
import com.aplication.twitter.service.TwitterService;
import com.aplication.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

@RestController()
public class HomeResources {

    @Autowired
    private TwitterService twitterService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String home(){
        return ("<h1>Hoşgeldin</h1>");
    }

    @GetMapping("/user")
    public String User(){
        return ("<h1>Hoşgeldin User</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Hoşgeldin Admin </h1>");
    }

    @PostMapping("/yenikayit")
    public String createUser(@RequestBody User user) throws Exception {
        String encodedpassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedpassword);
        userService.addUser(user);
        emailService.sendMail(user.getEmail(),"Aramıza hoşgeldin!","üyeliğiniz oluşturuldu, bizi takipte kalın :)");

        return ("<h1>oluştu </h1>");
    }
    // public String password(@RequestBody User user, @PathVariable int id ) throws Exception
    @PutMapping("/yenisifre/{id}")
    ResponseEntity<User> password(@RequestBody User user, @PathVariable int id)
    {
        return userService.updatePassword(id ,user);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@RequestBody User user , @PathVariable int id) throws Exception {
        userService.updateUser(id,user);

    }

    @PostMapping("/createtweet")
    public String createTweet(@RequestBody String tweet) throws TwitterException {
        twitterService.createTweet(tweet);
        return ("<h1>Tweet başarılı bir şekilde gönderildi!!<h1>");
    }
}