package alpha.repository;

import alpha.model.Home;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HomeRepository extends PagingAndSortingRepository<Home, Long> {
}
