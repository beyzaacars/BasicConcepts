package com.aplication.twitter.service;

import com.aplication.twitter.entity.Log;
import com.aplication.twitter.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;


    public void addLog(Log log) {
        logRepository.save(log);
    }

}
