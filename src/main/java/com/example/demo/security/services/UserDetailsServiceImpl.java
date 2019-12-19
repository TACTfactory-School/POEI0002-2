package com.example.demo.security.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

/**
 * Implementation of the user detail service.
 * @author Cheikh Ejeyed
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  /**
 * User repository.
 */
@Autowired
  UserRepository userRepository;

  /**
   * Grant the user with corresponding authorities according to his role.
 *@param username String.
 */
@Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    UserDetails result = null;
    User user = userRepository.findByUsername(username);

    if (user != null) {

      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
      grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
      UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
      userBuilder.username(user.getUsername());
      userBuilder.password(user.getPassword());
      userBuilder.authorities(grantedAuthorities);

      result = userBuilder.build();
    }

    return result;
  }
}
