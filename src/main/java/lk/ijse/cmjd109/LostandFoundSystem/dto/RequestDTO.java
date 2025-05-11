package lk.ijse.cmjd109.LostandFoundSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String requestId;
    private String userId;
    private String itemId;
    private String status; // PENDING, APPROVED, REJECTED
    private String requesteddate;
    private String requestedtime;

}
