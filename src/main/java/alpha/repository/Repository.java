package alpha.repository;

import java.util.List;

public interface Repository<H> {

    List<H> findAll();

    H findById(Long id);

    void save(H h);

    void remove(Long id);

}

