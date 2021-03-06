package org.paingan.boot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.paingan.boot.domain.Users;
import org.paingan.boot.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("loadUserByUsername: "+username);
        Users applicationUser = userRepository.findByUsername(username);
        
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        } else if (applicationUser != null) {
            List<GrantedAuthority> authorityList = applicationUser.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRole()))
                    .collect(Collectors.toList());

            return new User(applicationUser.getUsername(), applicationUser.getPassword(), true, true, true, true, authorityList);
        }
        
        return null;
        //return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
    
    
    
}