package fr.epsi.project.phototheque.v1.repository;

import fr.epsi.project.phototheque.v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
