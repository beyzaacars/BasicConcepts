//package com.aplication.twitter.twitter;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import twitter4j.auth.OAuth2Authorization;
//
//@ConfigurationProperties(prefix= Twitter4jproperties.TWITTER4J_PREFIX)
//public class Twitter4jproperties {
//
//    public static final String TWITTER4J_PREFIX = "twitter4j";
//
//    private boolean debug = false;
//
//    private final OAuth oauth = new OAuth;
//
//    public boolean isDebug() {
//        return debug;
//    }
//
//    public void setDebug(boolean debug) {
//        this.debug = debug;
//    }
//
//    public OAuth getOauth() {
//        return oauth;
//    }
//    public static class OAuth {
//
//        /**
//         * OAuth consumer key.
//         */
//        private String consumerKey;
//
//        /**
//         * OAuth consumer secret.
//         */
//        private String consumerSecret;
//
//        /**
//         * OAuth access token.
//         */
//        private String accessToken;
//
//        /**
//         * OAuth access token secret.
//         */
//        private String accessTokenSecret;
//
//        public String getConsumerKey() {
//            return consumerKey;
//        }
//        public void setConsumerKey(String consumerKey) {
//            this.consumerKey = consumerKey;
//        }
//        public String getConsumerSecret() {
//            return consumerSecret;
//        }
//        public void setConsumerSecret(String consumerSecret) {
//            this.consumerSecret = consumerSecret;
//        }
//        public String getAccessToken() {
//            return accessToken;
//        }
//        public void setAccessToken(String accessToken) {
//            this.accessToken = accessToken;
//        }
//        public String getAccessTokenSecret() {
//            return accessTokenSecret;
//        }
//        public void setAccessTokenSecret(String accessTokenSecret) {
//            this.accessTokenSecret = accessTokenSecret;
//        }
//
//    }
//
//}
