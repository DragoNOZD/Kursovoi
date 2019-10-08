package org.tr.swapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepository = userRepo;
    }

    public UserRepo getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(String login) {
        userRepository.delete(login);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findOne(login);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean checkPassword(String login, String password) {
        return userRepository.getOne(login).checkPassword(password);
    }
}
