package com.alkemy.disney.security.model;

import com.alkemy.disney.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String username, password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(User user){
        return new UserDetailsImpl(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
  }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
