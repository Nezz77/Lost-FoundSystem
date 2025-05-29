package lk.ijse.cmjd109.LostandFoundSystem.dto.secure;

import lk.ijse.cmjd109.LostandFoundSystem.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private String userid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

}
