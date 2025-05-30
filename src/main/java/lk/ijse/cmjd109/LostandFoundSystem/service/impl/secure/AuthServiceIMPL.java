package lk.ijse.cmjd109.LostandFoundSystem.service.impl.secure;

import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.JWTAuthResponse;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.SignIn;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.service.secure.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceIMPL implements AuthService {

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        return null;
    }
}
