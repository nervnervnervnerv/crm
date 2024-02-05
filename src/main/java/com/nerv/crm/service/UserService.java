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
//    @PersistenceContext
//    private EntityManager em;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println(true);
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

//    public User findUserById(Long userId) {
//        Optional<User> managerFromDb = userRepository.findById(userId);
//        return managerFromDb.orElse(new User());
//    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            throw new DuplicateKeyException("Username already exists");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        }
    }

}
