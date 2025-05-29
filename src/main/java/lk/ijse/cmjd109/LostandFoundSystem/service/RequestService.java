package lk.ijse.cmjd109.LostandFoundSystem.service;

import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;

import java.util.List;

public interface RequestService {
    RequestDTO addRequest(RequestDTO requestDTO);
    void deleteRequest(String requestId);
    void updateRequest(String requestId, RequestDTO requestDTO);
    RequestDTO getselectedRequest(String requestId);
    List<RequestDTO> getallRequests();
}
