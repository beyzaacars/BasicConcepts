package com.aplication.twitter.controller;

import com.aplication.twitter.entity.Log;
import com.aplication.twitter.entity.Topic;
import com.aplication.twitter.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TopicServiceController {

    ClientHttpRequestFactory factory =
            new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    RestTemplate restTemplate = new RestTemplate(factory);

    Logger logger = LoggerFactory.getLogger(TopicServiceController.class);

    public TopicServiceController(LogService logService) {
        this.logService = logService;
    }
   private LogService logService;



    @PostMapping("/template/api/topics")
    public String createTopic(@RequestBody Topic topic){

        logger.info("topic Rest servisine istek atıldı!!");
        logger.info(topic.toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Topic> httpEntity = new HttpEntity<Topic>(topic,httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange("http://localhost:8090/api/topics", HttpMethod.POST,httpEntity,String.class);


        Log loginstance = new Log();
        loginstance.setLogDate(new Date());
        loginstance.setMethod(HttpMethod.POST.toString());
        loginstance.setInput(topic.toString());
        loginstance.setOutput(responseEntity.toString());
        logService.addLog(loginstance);


        return responseEntity.getBody();
    }
}
