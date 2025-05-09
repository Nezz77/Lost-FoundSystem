package lk.ijse.cmjd109.LostandFoundSystem.controller;
import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {
    @GetMapping("/health")
    public String healthTest(){
        return "Request SYSTEM OKAY";
    }
    @PostMapping()
    public ResponseEntity<Void> addRequest(@RequestBody RequestDTO requestDTO) {
        System.out.println(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteRequest(@RequestParam("requestIdKey") String requestIdValue){
        System.out.println(requestIdValue);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{requestId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRequest(@PathVariable String requestId, @RequestBody RequestDTO requestDTO)
    {
        System.out.println(requestId);
        System.out.println(requestDTO);
        return ResponseEntity.noContent().build();
    }
    //ona weyda dan na,okkkoma ewa retreive karannay specific ekak gannay
    @GetMapping("{requestId}")
    public ResponseEntity<RequestDTO> getSelectedRequest(@PathVariable String requestId){
        System.out.println("Get Selected Requests for "+requestId);
        return ResponseEntity.ok(new RequestDTO(
                "R001",
                "U001",
                "I001",
                "PENDING"
        ));
    }
    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequest(){
        List<RequestDTO> requestList=new ArrayList<>();
        requestList.add(new RequestDTO(
                "R001",
                "U001",
                "I001",
                "PENDING"
        ));
        requestList.add(new RequestDTO(
                "R002",
                "U002",
                "I004",
                "APPROVED"
        ));
        requestList.add(new RequestDTO(
                "R003",
                "U003",
                "I002",
                "REJECTED"
        ));
        requestList.add(new RequestDTO(
                "R004",
                "U004",
                "I005",
                "PENDING"
        ));
        requestList.add(new RequestDTO(
                "R005",
                "U001",
                "I003",
                "APPROVED"
        ));
        return ResponseEntity.ok(requestList);
    }
}


