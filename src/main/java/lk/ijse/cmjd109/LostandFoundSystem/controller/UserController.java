package lk.ijse.cmjd109.LostandFoundSystem.controller;

import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @GetMapping("/health")
    public String healthTest(){
        return "User SYSTEM OKAY";
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList=new ArrayList<>();
        userList.add(new UserDTO(
                "U001",
                "john_doe",
                "pass1234",
                "USER"
        ));

        userList.add(new UserDTO(
                "U002",
                "admin_kamal",
                "securePass!",
                "ADMIN"
        ));

        userList.add(new UserDTO(
                "U003",
                "staff_sasha",
                "sasha2025",
                "STAFF"
        ));

        userList.add(new UserDTO(
                "U004",
                "user_nihal",
                "nihal_789",
                "USER"
        ));

        userList.add(new UserDTO(
                "U005",
                "staff_ira",
                "iraPass@1",
                "STAFF"
        ));

        return ResponseEntity.ok(userList);
    }

    @PatchMapping(value = "/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        System.out.println(userId);
        System.out.println(userDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        System.out.println("Delete user: " + userId);
        return ResponseEntity.noContent().build();
    }
}
