package lk.ijse.cmjd109.LostandFoundSystem.service;

import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void addItem(ItemDTO itemDTO);
    void deleteItem(String itemId);
    void updateItem(String itemId,ItemDTO itemDTO);
    ItemDTO getselectedItem(String itemId);
    List<ItemDTO> getallItems();
}
