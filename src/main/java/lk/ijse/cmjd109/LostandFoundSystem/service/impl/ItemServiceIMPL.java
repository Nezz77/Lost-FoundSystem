package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dao.ItemDao;
import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.entities.ItemEntity;
import lk.ijse.cmjd109.LostandFoundSystem.exception.ItemNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.service.ItemService;
import lk.ijse.cmjd109.LostandFoundSystem.util.EntityDTOConvert;
import lk.ijse.cmjd109.LostandFoundSystem.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class ItemServiceIMPL implements ItemService {

    private final ItemDao itemDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addItem(ItemDTO itemDTO) {
        itemDTO.setId(UtilData.generateItemId());
        System.out.println(itemDTO);
        var itemEntity=entityDTOConvert.convertItemDTOToItemEntity(itemDTO);
        itemDao.save(itemEntity);
        //pass to dao
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> foundItem=itemDao.findById(itemId);
        if (!foundItem.isPresent()){
            throw new ItemNotFoundException("Not Listed");
        }
        itemDao.deleteById(itemId);
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
       Optional<ItemEntity> foundItem=itemDao.findById(itemId);
        if (!foundItem.isPresent()){
            throw new ItemNotFoundException("Not Listed");
        }
        foundItem.get().setName(itemDTO.getName());
        foundItem.get().setDescription(itemDTO.getDescription());
        foundItem.get().setDate(itemDTO.getDate());
        foundItem.get().setTime(itemDTO.getTime());
        foundItem.get().setStatus(itemDTO.getStatus());


    }

    @Override
    public ItemDTO getselectedItem(String itemId) {
       Optional<ItemEntity> foundItem =itemDao.findById(itemId);
        if (!foundItem.isPresent()){
            throw new ItemNotFoundException("Selected Book Not Listed");
        }
        return entityDTOConvert.convertItemEntityToItemDTO(itemDao.getReferenceById(itemId));

    }

    @Override
    public List<ItemDTO> getallItems() {
        return entityDTOConvert.toItemDTOList(itemDao.findAll());
    }
}
