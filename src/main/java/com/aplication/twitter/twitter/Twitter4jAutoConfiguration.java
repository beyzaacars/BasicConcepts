//package com.aplication.twitter.twitter;
//
//import org.apache.juli.logging.LogFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import sun.rmi.runtime.Log;
//import twitter4j.Twitter;
//import twitter4j.TwitterFactory;
//import twitter4j.conf.ConfigurationBuilder;
//
//@Configuration
//@ConditionalOnClass({ TwitterFactory.class, Twitter.class })
//@EnableConfigurationProperties(Twitter4jproperties.class)
//public class Twitter4jAutoConfiguration {
//    private static Log log = (Log) LogFactory.getLog(Twitter4jAutoConfiguration.class);
//
//    private final Twitter4jproperties properties;
//
//    public Twitter4jAutoConfiguration(Twitter4jproperties twitter4jProperties){
//        this.properties = twitter4jProperties;
//    }
//    @Bean
//    @ConditionalOnMissingBean
//    public TwitterFactory twitterFactory(){
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(properties.isDebug())
//                .setOAuthConsumerKey(properties.getOauth().getConsumerKey())
//                .setOAuthConsumerSecret(properties.getOauth().getConsumerSecret())
//                .setOAuthAccessToken(properties.getOauth().getAccessToken())
//                .setOAuthAccessTokenSecret(properties.getOauth().getAccessTokenSecret());
//        TwitterFactory tf = new TwitterFactory(cb.build());
//        return tf;
//    }
//    @Bean
//    @ConditionalOnMissingBean
//    public Twitter twitter(TwitterFactory twitterFactory){
//        return twitterFactory.getInstance();
//    }
//
//}
//
