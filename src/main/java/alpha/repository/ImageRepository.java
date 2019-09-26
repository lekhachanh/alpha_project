package alpha.repository;

import alpha.model.Home;
import alpha.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByHome(Home home);
    Optional<Image> findByImageUrl(String imageUrl);
}
