package alpha.service.impl;

import alpha.model.Home;
import alpha.model.Image;
import alpha.repository.ImageRepository;
import alpha.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> findAllByHome(Home home) {
        return imageRepository.findAllByHome(home);
    }

    @Override
    public Image findByImageUrl(String imageUrl) throws EntityNotFoundException {
        return imageRepository.findByImageUrl(imageUrl).orElseThrow(EntityNotFoundException::new);
    }
}
