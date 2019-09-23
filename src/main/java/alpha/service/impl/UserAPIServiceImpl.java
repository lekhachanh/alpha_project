package alpha.service.impl;

import alpha.model.User;
import alpha.repository.UserAPIRepository;
import alpha.service.UserAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserAPIServiceImpl implements UserAPIService {

    @Autowired
    UserAPIRepository userAPIRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userAPIRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userAPIRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userAPIRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userAPIRepository.remove(id);
    }
}
