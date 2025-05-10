package lk.ijse.cmjd109.LostandFoundSystem.controller;

import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping("/health")
    public String healthTest(){
        return "User SYSTEM OKAY";
    }
    @PostMapping()
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userIdValue) {
        userService.deleteUser(userIdValue);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        userService.updateUser(userId,userDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable String userId){
       return ResponseEntity.ok(userService.getselectedUser(userId));

    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getallUser());
    }


}
