package lk.ijse.cmjd109.LostandFoundSystem.service.impl;
import lk.ijse.cmjd109.LostandFoundSystem.dao.UserDao;
import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.entities.UserEntity;
import lk.ijse.cmjd109.LostandFoundSystem.exception.UserNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.service.UserService;
import lk.ijse.cmjd109.LostandFoundSystem.util.EntityDTOConvert;
import lk.ijse.cmjd109.LostandFoundSystem.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class UserServiceIMPL implements UserService {
    private final UserDao userDao;
    private final EntityDTOConvert entityDTOConvert;
    @Override
    public void addUser(UserDTO userDTO) {
        userDTO.setId(UtilData.generateUserId());
        System.out.println(userDTO);
        var userEntity=entityDTOConvert.convertUserDTOTOUserEntity(userDTO);
        userDao.save(userEntity);
        //pass to dao
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> foundUser=userDao.findById(userId);
        if (!foundUser.isPresent()){
            throw new UserNotFoundException("Not Listed");
        }
        userDao.deleteById(userId);
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> foundUser=userDao.findById(userId);
        if (!foundUser.isPresent()){
            throw new UserNotFoundException("Not Listed");
        }
        foundUser.get().setUsername(userDTO.getUsername());
        foundUser.get().setPassword(userDTO.getPassword());
        foundUser.get().setRole(userDTO.getRole());

    }

    @Override
    public UserDTO getselectedUser(String userId) {
        Optional<UserEntity> foundUser =userDao.findById(userId);
        if (!foundUser.isPresent()){
            throw new UserNotFoundException("Selected Book Not Listed");
        }
        return entityDTOConvert.convertUserEntityToUserDTO(userDao.getReferenceById(userId));

    }

    @Override
    public List<UserDTO> getallUsers() {
        return entityDTOConvert.toUserDTOList(userDao.findAll());
    }
}
