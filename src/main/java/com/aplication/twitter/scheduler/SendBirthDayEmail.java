package com.aplication.twitter.scheduler;

import com.aplication.twitter.entity.user.User;
import com.aplication.twitter.repository.UserRepository;
import com.aplication.twitter.service.EmailService;
import com.aplication.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Component
public class SendBirthDayEmail {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final EmailService emailService;

    public SendBirthDayEmail(UserRepository userRepository, UserService userService, EmailService emailService) {
        this.userRepository = userRepository;

        this.emailService = emailService;
    }


    @Scheduled(cron = "0 0 10 * * *", zone = "Europe/Istanbul")
    public void birthDayMail() {
        Date date=new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        List<User> users = userRepository.findAll();
        for(int i=0;i<users.size();i++){
            Date dogum = users.get(i).getBirthOfDate();
            cal.setTime(dogum);
            int ay=cal.get(Calendar.MONTH);
            int gun=cal.get(Calendar.DAY_OF_MONTH);
            if (ay==month && gun==gun){
                emailService.sendMail(users.get(i).getEmail(),"İyi Ki Doğdun!",
                         //"<h1>Doğumgününnnn bugün :)))" + users.get(i).getUserName() +"</h1>"

                        "<h1 \"style=color: #5e9ca0;\">Doğum Günün kutlu Olsun "+ users.get(i).getUserName() + "</h1>" +
                                         "<img src=\"https://thumbs.dreamstime.com/z/party-baloons-1265663.jpg\" alt=\"Trulli\" width=\"500\" height=\"333\">"
                        );
            }
        }

    }
}
