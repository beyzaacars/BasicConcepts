package com.aplication.twitter.repository;

import com.aplication.twitter.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
