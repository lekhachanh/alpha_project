package alpha.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<H> {

    Page<H> findAll(Pageable pageable);

    List<H> findAll();

    H findById(Long id);

    void save(H h);

    void remove(Long id);
}
