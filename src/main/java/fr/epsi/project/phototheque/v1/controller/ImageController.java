package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/images")
public class ImageController {
    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveImage(@RequestParam("imageFile") MultipartFile imageFile,
                            @RequestParam("nameImage") String nameImage,
                            @RequestParam("category") String category,
                            @RequestParam("description") String description
                           ) {

        System.out.println(imageFile.getOriginalFilename());
        Image imageCreator = this.imageService.postImage(imageFile, nameImage, category, description);
        return "testing";
    }
}

