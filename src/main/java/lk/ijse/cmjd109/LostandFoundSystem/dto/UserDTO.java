package lk.ijse.cmjd109.LostandFoundSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String username;
    private String password; // For registration only; exclude in responses
    private String role; // ADMIN, STAFF, USER
}
