package lk.ijse.cmjd109.LostandFoundSystem.controller;
import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import lk.ijse.cmjd109.LostandFoundSystem.exception.ItemNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/requests")
@RequiredArgsConstructor

public class RequestController {
    private final RequestService requestService;

    @GetMapping("/health")
    public String healthTest() {
        return "Request SYSTEM OKAY";
    }

    @PostMapping()
    public ResponseEntity<Void> addRequest(@RequestBody RequestDTO requestDTO) {
        requestService.addRequest(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRequest(@RequestParam("requestIdKey") String requestIdValue) {
        try {
            requestService.deleteRequest(requestIdValue);
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
    public ResponseEntity<Void> updateRequest(@RequestParam("requestId") String requestId, @RequestBody RequestDTO requestDTO) {

        try {
            requestService.updateRequest(requestId, requestDTO);
            return ResponseEntity.noContent().build();
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ona weyda dan na,okkkoma ewa retreive karannay specific ekak gannay
    @GetMapping
    public ResponseEntity<RequestDTO> getSelectedRequest(@RequestParam String requestId) {
        try {
            return ResponseEntity.ok(requestService.getselectedRequest(requestId));
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping(value = "getallrequests")
    public ResponseEntity<List<RequestDTO>> getAllItems(){
        return ResponseEntity.ok(requestService.getallRequests());
    }

}


