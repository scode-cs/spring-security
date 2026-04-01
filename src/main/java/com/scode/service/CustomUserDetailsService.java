package com.scode.service;

import com.scode.com.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final List<UserModel> users;

    public CustomUserDetailsService() {
        users = List.of(
                UserModel.builder().userId("user").password("pass").role("user").build(),
                UserModel.builder().userId("admin").password("pass").role("admin").build()
        );
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = users.stream().filter(usr -> usr.getUserId().equals(username)).findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserId())
                .password(user.getPassword())
                .authorities(user.getRole())
                .build();
    }

}
