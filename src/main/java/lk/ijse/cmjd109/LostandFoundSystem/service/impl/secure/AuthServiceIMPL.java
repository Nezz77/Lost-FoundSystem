package lk.ijse.cmjd109.LostandFoundSystem.service.impl.secure;

import lk.ijse.cmjd109.LostandFoundSystem.dao.secure.UserDao;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.JWTAuthResponse;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.SignIn;
import lk.ijse.cmjd109.LostandFoundSystem.dto.secure.UserDTO;
import lk.ijse.cmjd109.LostandFoundSystem.security.jwt.JWTUtils;
import lk.ijse.cmjd109.LostandFoundSystem.service.secure.AuthService;
import lk.ijse.cmjd109.LostandFoundSystem.util.EntityDTOConvert;
import lk.ijse.cmjd109.LostandFoundSystem.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDao userDao;
    private final JWTUtils jwtUtils;
    private final EntityDTOConvert entityDTOConvert;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var signInUser = userDao.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtUtils.generateToken(signInUser.getEmail(), signInUser.getAuthorities());
        return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        userDTO.setUserid(UtilData.generateUserId());
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        var savedUser =
                userDao.save(entityDTOConvert.toUserEntity(userDTO));
        var generatedToken = jwtUtils.generateToken(savedUser.getEmail(), savedUser.getAuthorities());
        return JWTAuthResponse.builder().token(generatedToken).build();

    }
}
