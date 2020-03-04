package com.kc.learnings.spring.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> GetAllUsers() {
        return userDaoService.FindAll();
    }

    @GetMapping("/users/{id}")
    public User FindById(@PathVariable int id) {

        //Throw user not found exception when ID is not found, that should return handled exception
        // which will extend exception to automatically return 404response status

        User user = userDaoService.FindOne(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    //Primitive POST method that does not return status or location response header
    //@PostMapping("/users")
    //public User SaveUser(@RequestBody User user){
    //return  userDaoService.save(user);
    //}
    @PostMapping("/users")
    public ResponseEntity<Object> SaveUser(@Valid @RequestBody User user){
        //Save user
        User savedUser = userDaoService.save(user);

        //Return: CREATED status and LOCATION response header with saved entity resource URI
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public User DeleteUser(@PathVariable int id) {
        User user = userDaoService.delete(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }
}
