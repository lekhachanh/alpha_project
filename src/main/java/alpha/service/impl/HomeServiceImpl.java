package alpha.service.impl;

import alpha.model.Home;
import alpha.repository.HomeRepository;
import alpha.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;


public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll( ) {
        return homeRepository.findAll();
    }

    @Override
    public Home findById(Long id) {
        return homeRepository.findOne(id);
    }

    @Override
    public void save(Home home) {
        homeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        homeRepository.delete(id);
    }
}
