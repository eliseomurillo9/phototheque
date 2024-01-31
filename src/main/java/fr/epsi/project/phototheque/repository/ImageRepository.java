package fr.epsi.project.phototheque.repository;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository permettant de gérer la persistence des utilisateurs.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
