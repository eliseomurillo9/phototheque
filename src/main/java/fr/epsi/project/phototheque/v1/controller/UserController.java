package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.v1.dto.UserDto;
import fr.epsi.project.phototheque.v1.entity.User;
import fr.epsi.project.phototheque.v1.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public Page<UserDto> findAll(Pageable pageable){
      return this.userService.findAll(pageable)
              .map(it -> new UserDto(it.getId(), it.getFirstname(), it.getLastname()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        var user = this.userService.findById(id);
        return user.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(user
                .map(it -> new UserDto(it.getId(), it.getLastname(), it.getLastname())).get());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        var userEntity = new User();
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        this.userService.createUser(userEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(userEntity.getId()))
                .build();
    }
}
