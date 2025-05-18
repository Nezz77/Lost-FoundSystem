package lk.ijse.cmjd109.LostandFoundSystem.controller;
import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.exception.ItemNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor

public class ItemController {
    private final ItemService itemService;

    @GetMapping("/health")
    public String healthTest(){
        return "Item SYSTEM OKAY";
    }

    @PostMapping()
    public ResponseEntity<Void> addItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteItem(@RequestParam("itemIdKey") String itemIdValue){
        try {
            itemService.deleteItem(itemIdValue);
            return ResponseEntity.noContent().build();
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PatchMapping
    public ResponseEntity<Void> updateItem(@RequestParam ("itemId") String itemId,@RequestBody ItemDTO itemDTO){
        try {
            itemService.updateItem(itemId,itemDTO);
            return ResponseEntity.noContent().build();
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    //ona weyda dan na,okkkoma ewa retreive karannay specific ekak gannay
    @GetMapping
    public ResponseEntity<ItemDTO> getSelectedItem(@RequestParam String itemId){
        try {
            return ResponseEntity.ok(itemService.getselectedItem(itemId));
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping(value = "getallitems")
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return ResponseEntity.ok(itemService.getallItems());
    }
}
