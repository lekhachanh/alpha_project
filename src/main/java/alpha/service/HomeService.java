package alpha.service;

import alpha.model.Home;

public interface HomeService {
    Iterable<Home> findAll( );

    Home findById(Long id);

    void save(Home home);

    void remove(Long id);

}
