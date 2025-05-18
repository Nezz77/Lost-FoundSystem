package lk.ijse.cmjd109.LostandFoundSystem.service.impl;

import lk.ijse.cmjd109.LostandFoundSystem.dao.RequestDao;
import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemDTO;
import lk.ijse.cmjd109.LostandFoundSystem.dto.RequestDTO;
import lk.ijse.cmjd109.LostandFoundSystem.entities.ItemEntity;
import lk.ijse.cmjd109.LostandFoundSystem.entities.RequestEntity;
import lk.ijse.cmjd109.LostandFoundSystem.exception.ItemNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.exception.RequestNotFoundException;
import lk.ijse.cmjd109.LostandFoundSystem.service.RequestService;
import lk.ijse.cmjd109.LostandFoundSystem.util.EntityDTOConvert;
import lk.ijse.cmjd109.LostandFoundSystem.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestServiceIMPL implements RequestService {

    private final RequestDao requestDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addRequest(RequestDTO requestDTO) {
        requestDTO.setRequestId(UtilData.generateRequestId());
        requestDTO.setRequesteddate(java.time.LocalDate.now());
        requestDTO.setRequestedtime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
        System.out.println(requestDTO);
        var requestEntity=entityDTOConvert.convertRequestDTOToRequestEntity(requestDTO);
        requestDao.save(requestEntity);
        //pass to dao
    }

    @Override
    public void deleteRequest(String requestId) {
        Optional<RequestEntity> foundRequest=requestDao.findById(requestId);
        if (!foundRequest.isPresent()){
            throw new RequestNotFoundException("Not Listed");
        }
        requestDao.deleteById(requestId);
    }

    @Override
    public void updateRequest(String requestId, RequestDTO requestDTO) {
        Optional<RequestEntity> foundRequest=requestDao.findById(requestId);
        if (!foundRequest.isPresent()){
            throw new RequestNotFoundException("Not Listed");
        }
        foundRequest.get().setStatus(requestDTO.getStatus());
        //  Automatically set the current date and time when updating
        foundRequest.get().setRequesteddate(LocalDate.now());
        foundRequest.get().setRequestedtime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));


    }

    @Override
    public RequestDTO getselectedRequest(String requestId) {
        Optional<RequestEntity> foundRequest =requestDao.findById(requestId);
        if (!foundRequest.isPresent()){
            throw new RequestNotFoundException("Selected Book Not Listed");
        }
        return entityDTOConvert.convertRequestEntityToRequestDTO(requestDao.getReferenceById(requestId));

    }

    @Override
    public List<RequestDTO> getallRequests() {
        return entityDTOConvert.toRequestDTOList(requestDao.findAll());
    }
}
