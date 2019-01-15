package info.njegovan3ap.onboarding.controllers;

import info.njegovan3ap.onboarding.model.UserDTO;
import info.njegovan3ap.onboarding.model.UserListDTO;
import info.njegovan3ap.onboarding.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsers(){
        return userService.getAllUsers();
    }

    @GetMapping({"/{uuid}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByUuid(@PathVariable String uuid){
        return userService.getUserByUuid(uuid);
    }
}
