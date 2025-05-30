package lk.ijse.cmjd109.LostandFoundSystem.controller.secure;

import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.JWTAuthResponse;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.SignIn;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    @PostMapping
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<JWTAuthResponse> signUp(@RequestBody UserDTO signUp) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
