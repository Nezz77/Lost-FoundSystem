package lk.ijse.cmjd109.LostandFoundSystem.controller;

import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.exception.ItemNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.exception.UserNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam ("userIdKey") String userIdValue) {
        try {
            userService.deleteUser(userIdValue);
            return ResponseEntity.noContent().build();
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping
    public ResponseEntity<Void> updateUser(@RequestParam ("userId") String userId,@RequestBody UserDTO userDTO) {
        try {
            userService.updateUser(userId,userDTO);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<UserDTO> getSelectedUser(@RequestParam String userId){
        try {
            return ResponseEntity.ok(userService.getselectedUser(userId));
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping(value = "getallusers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
            return ResponseEntity.ok(userService.getallUsers());
    }
}
