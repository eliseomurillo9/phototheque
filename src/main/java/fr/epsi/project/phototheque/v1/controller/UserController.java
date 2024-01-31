package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.entity.User;
import fr.epsi.project.phototheque.service.UserService;
import fr.epsi.project.phototheque.v1.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserDto> findAll(Pageable pageable){
        return this.userService.findAll(pageable)
                .map(it -> new UserDto(it.getId(), it.getFirstname(), it.getLastname()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable(name = "id") Long id){
        var user = this.userService.findUserById(id);
        return ResponseEntity.of(user.map(it -> new UserDto(it.getId(), it.getFirstname(), it.getLastname())));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto user){
        var userEntity = new User();
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        User userCreator = this.userService.save(userEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(userCreator.getId()))
                .build();
    }

}
