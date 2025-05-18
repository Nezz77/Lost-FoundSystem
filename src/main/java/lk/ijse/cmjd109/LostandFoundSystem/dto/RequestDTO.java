package lk.ijse.cmjd109.LostandFoundSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String requestId;
    private String userId;
    private String itemId;
    private String status; // PENDING, APPROVED, REJECTED
    private LocalDate requesteddate;
    private LocalTime requestedtime;

}
