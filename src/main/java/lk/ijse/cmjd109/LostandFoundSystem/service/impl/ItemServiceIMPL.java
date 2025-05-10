package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Override
    public void addItem(ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {

    }

    @Override
    public ItemDTO getselectedItem(String itemId) {
        return null;
    }

    @Override
    public List<ItemDTO> getallItems(ItemDTO itemDTO) {
        return List.of();
    }
}
