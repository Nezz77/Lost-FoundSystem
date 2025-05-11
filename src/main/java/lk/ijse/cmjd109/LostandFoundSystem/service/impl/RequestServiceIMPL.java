package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.RequestService;
import lk.ijse.cmjd109.LostandFoundSystem.util.UtilData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceIMPL implements RequestService {

    @Override
    public void addRequest(RequestDTO requestDTO) {
        requestDTO.setRequestId(UtilData.generateRequestId());
        requestDTO.setRequesteddate(String.valueOf(UtilData.generateTodayDate()));
        requestDTO.setRequestedtime(String.valueOf(UtilData.generateCurrentTime()));
        System.out.println(requestDTO);

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
                "PENDING",
                "date1",
                "time1"

        ));
    }

    @Override
    public List<RequestDTO> getallRequest() {
        List<RequestDTO> requestList=new ArrayList<>();
        requestList.add(new RequestDTO(
                "R001",
                "U001",
                "I001",
                "PENDING",
                "date2",
                "time2"
        ));
        requestList.add(new RequestDTO(
                "R002",
                "U002",
                "I004",
                "APPROVED",
                "date3",
                "time3"
        ));
        requestList.add(new RequestDTO(
                "R003",
                "U003",
                "I002",
                "REJECTED",
                "date4",
                "time4"
        ));
        requestList.add(new RequestDTO(
                "R004",
                "U004",
                "I005",
                "PENDING",
                "date5",
                "time5"
        ));
        requestList.add(new RequestDTO(
                "R005",
                "U001",
                "I003",
                "APPROVED",
                "date6",
                "time6"
        ));
        return requestList;
    }
}
