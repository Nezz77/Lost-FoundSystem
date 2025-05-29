package lk.ijse.cmjd109.LostandFoundSystem.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignIn implements Serializable {
    private String email;
    private String password;
}
