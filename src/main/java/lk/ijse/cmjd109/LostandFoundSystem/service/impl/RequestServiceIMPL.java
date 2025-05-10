package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceIMPL implements RequestService {

    @Override
    public void addRequest(RequestDTO requestDTO) {
        System.out.println("Add Request from ServiceIMPL");

    }

    @Override
    public void deleteRequest(String requestId) {

    }

    @Override
    public void updateRequest(String requestId, RequestDTO requestDTO) {

    }

    @Override
    public RequestDTO getselectedRequest(String requestId) {
        return (new RequestDTO(
                "R001",
                "U001",
                "I001",
                "PENDING"
        ));
    }

    @Override
    public List<RequestDTO> getallRequest() {
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
        return requestList;
    }
}
