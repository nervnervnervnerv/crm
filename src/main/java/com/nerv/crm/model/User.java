package com.nerv.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Введите имя")
    @NotBlank(message = "Введите имя")
    @Length(min = 2, message = "Минимальная длина имени пользователя 3")
    private String firstName;

    @NotNull(message = "Введите фамилию")
    @NotBlank(message = "Введите фамилию")
    @Length(min = 3, message = "Минимальная длина имени пользователя 3")
    private String lastName;

    @NotNull(message = "Введите имя пользователя")
    @NotBlank(message = "Введите пользователя")
    @Length(min = 3, message = "Минимальная длина имени пользователя 3")
    private String username;

    @NotNull(message = "Введите пароль")
    @NotBlank(message = "Введите пароль")
    @Length(min = 6, message = "Минимальная длина пароля 6")
    private String password;


//    TODO valid
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
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
