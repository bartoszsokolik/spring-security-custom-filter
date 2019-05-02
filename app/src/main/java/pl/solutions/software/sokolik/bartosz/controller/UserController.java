package pl.solutions.software.sokolik.bartosz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.solutions.software.sokolik.bartosz.authorization.AdminAuthorization;
import pl.solutions.software.sokolik.bartosz.controller.dto.UserDto;
import pl.solutions.software.sokolik.bartosz.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    @AdminAuthorization
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

}
