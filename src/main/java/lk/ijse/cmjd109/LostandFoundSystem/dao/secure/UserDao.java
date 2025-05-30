package lk.ijse.cmjd109.LostandFoundSystem.dao.secure;

import lk.ijse.cmjd109.LostandFoundSystem.entities.secure.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
