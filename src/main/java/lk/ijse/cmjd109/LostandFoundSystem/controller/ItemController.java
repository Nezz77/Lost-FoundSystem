package lk.ijse.cmjd109.LostandFoundSystem.controller;
import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        itemService.deleteItem(itemIdValue);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{itemId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable String itemId,@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemId,itemDTO);
        return ResponseEntity.noContent().build();
    }
    //ona weyda dan na,okkkoma ewa retreive karannay specific ekak gannay
    @GetMapping("{itemId}")
    public ResponseEntity<ItemDTO> getSelectedItem(@PathVariable String itemId){
      return ResponseEntity.ok(itemService.getselectedItem(itemId));
    }
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return ResponseEntity.ok(itemService.getallItems());
    }
}
