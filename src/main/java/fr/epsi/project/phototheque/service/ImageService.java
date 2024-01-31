package fr.epsi.project.phototheque.service;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.repository.ImageRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Component
@Transactional(readOnly = true)
public class ImageService {

    ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional(readOnly = false)
    public Image postImage(MultipartFile image,
                           String nameImage,
                           String category,
                           String description) {
        var imageEntity = new Image();
        var date = new Date();
        System.out.println(image);
        imageEntity.setNameImage(nameImage);
        imageEntity.setCategory(category);
        imageEntity.setDescription(description);
        return imageEntity;
    }
}
