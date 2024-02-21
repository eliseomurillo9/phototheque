package fr.epsi.project.phototheque.v1.services;

import fr.epsi.project.phototheque.v1.entity.User;
import fr.epsi.project.phototheque.v1.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Page<User> findAll(Pageable page){
        return this.userRepository.findAll(page);
    }

    public Optional<User> findById(Long id){
        return this.userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public User createUser(User user){
        return this.userRepository.save(user);
    }
}
