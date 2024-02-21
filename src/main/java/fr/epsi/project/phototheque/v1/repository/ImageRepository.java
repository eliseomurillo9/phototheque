package fr.epsi.project.phototheque.v1.repository;

import fr.epsi.project.phototheque.v1.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository permettant de gérer la persistence des utilisateurs.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
