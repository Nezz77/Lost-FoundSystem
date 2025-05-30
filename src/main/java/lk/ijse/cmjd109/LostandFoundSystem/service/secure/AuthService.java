package lk.ijse.cmjd109.LostandFoundSystem.service.secure;

import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.JWTAuthResponse;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.SignIn;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.UserDTO;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO userDTO);
}
