package com.aplication.twitter.service;

import com.aplication.twitter.entity.User.User;
import com.aplication.twitter.repository.UserRepository;
import com.aplication.twitter.resource.HomeResources;
import com.aplication.twitter.util.CustomErrorType;
import javassist.NotFoundException;
import net.bytebuddy.asm.Advice;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {


    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(User user) throws Exception {
      //  UserRepository.save;
        if(repository.existsByUserName(user.getUserName())){
            throw new Exception("Bu userName kayıtlı!");
        }
        repository.save(user);
    }
    // public void updatePassword(int id, User user) throws Exception // 500 eroor atıyor
    //  throw new Exception( "Kullanıcı bulunamadı!");//if sorgusunun içindeydi
    public ResponseEntity<User> updatePassword(int id,User user)
   {
       if(user == null) {
           return new ResponseEntity<User> (new User(),HttpStatus.BAD_REQUEST);
       }
        User user1=repository.findById(id).orElse(null);
          if(user1==null){
             return new ResponseEntity<User> (new User(),HttpStatus.NO_CONTENT);
          } //lastProject is now updatable
            user1.setPassword(user.getPassword());   //update the entity fields
            repository.save(user1);
        return new ResponseEntity<User>(user1,HttpStatus.OK);
    }

    public void updateUser(int id, User user) throws Exception {
        User user1=repository.findById(id).orElse(null);
         if (user1==null){
         throw new EntityNotFoundException("Kullanıcı bulunamadı!!");
        }

        if(repository.existsByUserName(user.getUserName()) && id != user1.getId()){
         throw new Exception("Bu userName kullanılmakta Lütfen başka bir userName giriniz");
        }
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());
        if (repository.existsByEmail(user.getEmail()) && id != user1.getId()){
          throw new Exception("Bu email zaten var");
        }
        user1.setEmail(user.getEmail());
        user1.setActive(user.getActive());
        user1.setBirthOfDate(user.getBirthOfDate());
        repository.save(user1);
    }
}
