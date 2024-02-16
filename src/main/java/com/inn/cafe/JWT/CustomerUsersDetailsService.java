package com.inn.cafe.JWT;

import com.inn.cafe.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerUsersDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    private com.inn.cafe.POJO.User userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail=userDao.findByEmailId(username);
        if(!Objects.isNull(userDetail)){
            return new User(userDetail.getEmail(), userDetail.getPassword(),new ArrayList<>());
        }else
            throw new UsernameNotFoundException("USer NOt Found");


    }
}
