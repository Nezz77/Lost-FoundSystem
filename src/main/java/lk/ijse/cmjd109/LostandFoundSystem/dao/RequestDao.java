package lk.ijse.cmjd109.LostandFoundSystem.dao;

import lk.ijse.cmjd109.LostandFoundSystem.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDao extends JpaRepository<RequestEntity,String> {
}
