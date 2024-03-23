package com.nerv.crm.service;

import com.nerv.crm.model.User;
import com.nerv.crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) throws DuplicateKeyException, IllegalArgumentException{
//        if (user == null) {
//            throw new IllegalArgumentException("User object is null");
//        }
//        if (user.getUsername() == null || user.getUsername().isEmpty() ||
//                user.getPassword() == null || user.getPassword().isEmpty() ||
//                user.getFirstName() == null || user.getFirstName().isEmpty() ||
//                user.getLastName() == null || user.getLastName().isEmpty()) {
//            throw new IllegalArgumentException("Username or password cannot be null or empty");
//        }
        if(userRepository.existsByUsername(user.getUsername())){
            throw new DuplicateKeyException("Username already exists");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresent(userRepository::delete);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
}
