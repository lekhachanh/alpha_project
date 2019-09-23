package alpha.service.impl;

import alpha.model.User;
import alpha.repository.UserRepository;
import alpha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }

    @Override
    public Page<User> findAllByEmailContaining(String name, Pageable pageable) {
        return userRepository.findAllByEmailContaining(name, pageable);
    }

    @Override
    public Iterable<User> findAllByEmailContaining(String name) {
        return userRepository.findAllByEmailContaining(name);
    }
}
