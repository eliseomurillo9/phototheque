package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.v1.entity.Image;
import fr.epsi.project.phototheque.v1.services.ImageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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
                           ) throws IOException {

       Image imageCreator = this.imageService.postImage(imageFile, nameImage, category, description);
        return "testing";
    }
}

