package alpha.service;

import alpha.model.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface HomeService {
    Page<Home> findAll(Pageable pageable);

    Home findById(Long id);

    void save(Home home);

    void remove(Long id);

}
