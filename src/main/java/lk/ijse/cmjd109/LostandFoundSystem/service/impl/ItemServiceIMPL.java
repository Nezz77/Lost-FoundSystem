package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.ItemService;
import lk.ijse.cmjd109.LostandFoundSystem.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Override
    public void addItem(ItemDTO itemDTO) {
        itemDTO.setId(UtilData.generateItemId());
        System.out.println(itemDTO);
    }

    @Override
    public void deleteItem(String itemId) {
        System.out.println("delete item from ServiceIMPL");

    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        System.out.println("update item from ServiceIMPL");

    }

    @Override
    public ItemDTO getselectedItem(String itemId) {
        return (new ItemDTO(
                "I001",
                "Black Umbrella",
                "A foldable black umbrella with a wooden handle.",
                "2025-05-08",
                "14:20:00",
                "LOST"
        ));
    }

    @Override
    public List<ItemDTO> getallItems() {
        List<ItemDTO> itemList = new ArrayList<>();
        itemList.add(new ItemDTO(
                "I001",
                "Black Umbrella",
                "A foldable black umbrella with a wooden handle.",
                "2025-05-08",
                "14:20:00",
                "LOST"
        ));

        itemList.add(new ItemDTO(
                "I002",
                "Wireless Earbuds",
                "White Samsung Galaxy Buds left near the auditorium.",
                "2025-05-06",
                "09:15:00",
                "FOUND"
        ));

        itemList.add(new ItemDTO(
                "I003",
                "Blue Hoodie",
                "Nike blue hoodie with a university badge on the front.",
                "2025-04-30",
                "17:40:00",
                "CLAIMED"
        ));

        itemList.add(new ItemDTO(
                "I004",
                "Keychain",
                "Metal keychain with 3 keys and a red tag labelled 'Lab 5'.",
                "2025-05-01",
                "08:00:00",
                "LOST"
        ));

        itemList.add(new ItemDTO(
                "I005",
                "Textbook",
                "Data Structures textbook left on the second floor reading area.",
                "2025-05-07",
                "12:10:00",
                "FOUND"
        ));
        return itemList;
    }
}
