package by.beatdev.controller;

import by.beatdev.entity.User;
import by.beatdev.model.ChangeStatusRequest;
import by.beatdev.model.ChangeStatusResponse;
import by.beatdev.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    final Logger LOG = Logger.getLogger(UserController.class);

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.findEntityById(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer addUser(@RequestBody User user) {
        userService.createOrUpdate(user);
        System.out.println(user.getId());
        return user.getId();
    }

    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChangeStatusResponse updateUserStatus(@RequestBody ChangeStatusRequest request){
        return userService.updateUserStatus(request);
    }
}
