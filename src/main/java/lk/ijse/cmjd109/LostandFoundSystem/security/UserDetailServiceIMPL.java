package lk.ijse.cmjd109.LostandFoundSystem.security;

import lk.ijse.cmjd109.LostandFoundSystem.dao.secure.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceIMPL implements UserDetailsService {
    private final UserDao userDao;

    @Override
    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
//       return userDao.findById(username)
//                .map(user ->new User(
//                        user.getEmail(),
//                        user.getPassword(),
//                        user.getAuthorities(),
//
//                ))
//                .orElseThrow()->new UsernameNotFoundException("User not found ");
//    }
        return userDao.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found "));

    }
}
