package com.example.Library.domain;

import io.netty.util.internal.StringUtil;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String authority;
    private String role;
    private String email;
    private String phoneNumber;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(StringUtils.hasText(authority)){
            return Arrays.stream(authority.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        // if account is active return true(lastupdatetime >6 months)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // if account is active and not done any suspicious activity then return true
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // if account is active return true(lastupdatetime >6 months)
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
