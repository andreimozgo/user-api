package by.beatdev.controller;

import by.beatdev.dto.ChangingStatusRequest;
import by.beatdev.dto.ChangingStatusResponse;
import by.beatdev.dto.CreatingUserResponse;
import by.beatdev.entity.User;
import by.beatdev.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    final Logger LOG = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.findEntityById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreatingUserResponse addUser(@RequestBody User user) {
        userService.createOrUpdate(user);
        CreatingUserResponse creatingUserResponce = new CreatingUserResponse();
        creatingUserResponce.setId(user.getId());
        return creatingUserResponce;
    }

    @PutMapping(value = "/changestatus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChangingStatusResponse updateUserStatus(@RequestBody ChangingStatusRequest request) {
        return userService.updateUserStatus(request);
    }
}
