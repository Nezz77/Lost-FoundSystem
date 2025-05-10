package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Override
    public void addUser(UserDTO userDTO) {
        System.out.println("Add user from ServiceIMPL");

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {

    }

    @Override
    public UserDTO getselectedUser(String userId) {
        return (new UserDTO(
                "U001",
                "Username",
                "password",
                "Staff"
        ));
    }

    @Override
    public List<UserDTO> getallUser() {
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
        return userList;
    }
}
