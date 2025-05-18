package lk.ijse.cmjd109.LostandFoundSystem.util;

import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import lk.ijse.cmjd109.LostandFoundSystem.dto.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.entities.ItemEntity;
import lk.ijse.cmjd109.LostandFoundSystem.entities.RequestEntity;
import lk.ijse.cmjd109.LostandFoundSystem.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    //Items
    public ItemEntity convertItemDTOToItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public ItemDTO convertItemEntityToItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList,new TypeToken<List<ItemDTO>>(){}.getType());
    }
    //Requests
    public RequestEntity convertRequestDTOToRequestEntity(RequestDTO requestDTO) {
        return modelMapper.map(requestDTO,RequestEntity.class);
    }
    public RequestDTO convertRequestEntityToRequestDTO(RequestEntity requestEntity) {
        return modelMapper.map(requestEntity,RequestDTO.class);
    }
    public List<RequestDTO> toRequestDTOList(List<RequestEntity> requestEntityList) {
        return modelMapper.map(requestEntityList,new TypeToken<List<RequestDTO>>(){}.getType());
    }
    //Staff
    public UserEntity convertUserDTOTOUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO,UserEntity.class);
    }
    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity,UserDTO.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        return modelMapper.map(userEntityList,new TypeToken<List<UserDTO>>(){}.getType());
    }

}
