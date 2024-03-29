package alpha.repository;

import alpha.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByEmailContaining(String name, Pageable pageable);
    Iterable<User> findAllByEmailContaining(String name);
}
