package fr.epsi.project.phototheque.v1.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageDto {
    private String nameImage;

    MultipartFile imageFile;

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    private String category;

    private String description;

    private Byte size;

    private Date creationDate;

    private Date lastModificationDate;

    private ArrayList objectsDetected;

    private boolean isAPersonInThePicture;

    private String imageLink;

    private  String imageAvatarLink;

    public ImageDto() {
        // Default constructor
    }

    public ImageDto(String nameImage) {
        this.nameImage = nameImage;
        System.out.println(nameImage);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public ArrayList getObjectsDetected() {
        return objectsDetected;
    }

    public void setObjectsDetected(ArrayList objectsDetected) {
        this.objectsDetected = objectsDetected;
    }

    public boolean isAPersonInThePicture() {
        return isAPersonInThePicture;
    }

    public void setAPersonInThePicture(boolean APersonInThePicture) {
        isAPersonInThePicture = APersonInThePicture;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageAvatarLink() {
        return imageAvatarLink;
    }

    public void setImageAvatarLink(String imageAvatarLink) {
        this.imageAvatarLink = imageAvatarLink;
    }


    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }


}
