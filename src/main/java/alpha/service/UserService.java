package alpha.service;

import alpha.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends Service<User> {
    Page<User> findAllByEmailContaining(String name, Pageable pageable);
    Iterable<User> findAllByEmailContaining(String name);
}
