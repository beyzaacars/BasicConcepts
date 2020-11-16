package com.aplication.twitter.service;

import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TwitterService {

    public String createTweet(String tweet) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        Status status = twitter.updateStatus("İlk tweet denemesi!!");
        System.out.println("Successfully updated the status to [" + status.getText() + "].statusID=>"+status.getId());
        return status.getText();
    }

}
