package com.example.validator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MyTableRepository extends JpaRepository<MyEntity, Integer> {

    List<MyEntity> findByRole(String roleName);

    @Query("Select count(m) from MyEntity m where m.role = :roleName")
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Long count(String roleName);
}
