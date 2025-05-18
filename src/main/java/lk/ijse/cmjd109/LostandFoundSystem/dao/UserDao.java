package lk.ijse.cmjd109.LostandFoundSystem.dao;

import lk.ijse.cmjd109.LostandFoundSystem.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,String> {
}
