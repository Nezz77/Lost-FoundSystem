package lk.ijse.cmjd109.LostandFoundSystem.service;

import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
    UserDTO getselectedUser(String userId);
    List<UserDTO> getallUsers();
}
