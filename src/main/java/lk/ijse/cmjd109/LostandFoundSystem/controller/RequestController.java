package lk.ijse.cmjd109.LostandFoundSystem.controller;
import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/requests")
@RequiredArgsConstructor

public class RequestController {
    private final RequestService requestService;

    @GetMapping("/health")
    public String healthTest(){
        return "Request SYSTEM OKAY";
    }
    @PostMapping()
    public ResponseEntity<Void> addRequest(@RequestBody RequestDTO requestDTO) {
        requestService.addRequest(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteRequest(@RequestParam("requestIdKey") String requestIdValue){
        requestService.deleteRequest(requestIdValue);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{requestId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRequest(@PathVariable String requestId, @RequestBody RequestDTO requestDTO)
    {
        requestService.updateRequest(requestId,requestDTO);
        return ResponseEntity.noContent().build();
    }
    //ona weyda dan na,okkkoma ewa retreive karannay specific ekak gannay
    @GetMapping("{requestId}")
    public ResponseEntity<RequestDTO> getSelectedRequest(@PathVariable String requestId){
        return ResponseEntity.ok(requestService.getselectedRequest(requestId));
    }
    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequest(){

        return ResponseEntity.ok(requestService.getallRequest());
    }
}


