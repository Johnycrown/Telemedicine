package com.telemedicine.module.usermanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hack_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Long userId;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private boolean mfaEnabled;
  private String secret;
  private String specialization;
  private String phoneNumber;

  @ElementCollection
  private Map<String, String> availability; // Example: {"MONDAY": "09:00-17:00", "WEDNESDAY": "09:00-17:00"}


  @Enumerated(EnumType.STRING)
  @Column(length = 50)
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
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
