package com.aplication.twitter.security;

import com.aplication.twitter.repository.UserRepository;
import com.aplication.twitter.entity.User.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    // böyle kullanman daha doğru
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);


        user.orElseThrow(() -> new UsernameNotFoundException("Not Found"+ userName));



        return user.map(MyUserDetails::new).get();
    }
}
