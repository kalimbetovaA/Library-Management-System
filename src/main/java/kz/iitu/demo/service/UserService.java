package kz.iitu.demo.service;

import kz.iitu.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserService {
    public List<User> findAllUsers();

    public User findUserById(Long id);

    public void createUser(User user);

    public void deleteUser(Long id);

    public void updateUser(User user);

    public UserDetails loadUserByUsername(String username);
}
