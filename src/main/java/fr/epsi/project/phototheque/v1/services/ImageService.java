package fr.epsi.project.phototheque.v1.services;

import fr.epsi.project.phototheque.v1.entity.Image;
import fr.epsi.project.phototheque.v1.repository.ImageRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Component
@Transactional(readOnly = true)
public class ImageService {

   ImageRepository imageRepository;
    ImagesHandlerService imagesHandlerService;

    public ImageService(ImageRepository imageRepository, ImagesHandlerService imagesHandlerService) {
        this.imageRepository = imageRepository;
        this.imagesHandlerService = imagesHandlerService;
    }


    @Transactional(readOnly = false)
    public Image postImage(MultipartFile image,
                           String nameImage,
                           String category,
                           String description) throws IOException {
        var imageEntity = new Image();
        var date = new Date();
        String apiUrl = "https://uf8m8gb2k0.execute-api.eu-central-1.amazonaws.com/epsi/generate-signed-url";
        imagesHandlerService.imageHandler(apiUrl, image.getOriginalFilename());
        imageEntity.setNameImage(nameImage);
        imageEntity.setCategory(category);
        imageEntity.setDescription(description);
        return imageEntity;
    }
}
