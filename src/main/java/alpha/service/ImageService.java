package alpha.service;

import alpha.model.Home;
import alpha.model.Image;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public interface ImageService {
    Image save(Image image);
    List<Image> findAllByHome(Home home);
    Image findByImageUrl(String imageUrl) throws EntityNotFoundException;
}
