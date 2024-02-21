package fr.epsi.project.phototheque.entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameImage;

    private String category;

    private String description;

    private Byte size;

    private Date creationDate;

    private Date lastModificationDate;

    private String LinkObjectsDetected;

    private boolean isAPersonInThePicture;

    private String imageLink;

    private  String imageAvatarLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImageFile() {
        return LinkObjectsDetected;
    }

    public void setImageFile(String imageFile) {
        this.LinkObjectsDetected = imageFile;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getObjectsDetected() {
        return LinkObjectsDetected;
    }

    public void setObjectsDetected(String objectsDetected) {
        this.LinkObjectsDetected = objectsDetected;
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
}
