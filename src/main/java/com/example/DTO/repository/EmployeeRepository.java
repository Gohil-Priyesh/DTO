package com.example.DTO.repository;

import com.example.DTO.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

    /// this is JPQL
    @Query("SELECT e FROM EmployeeEntity e")
    List<EmployeeEntity> GetAllUsersFromDb();

    @Query("SELECT e FROM EmployeeEntity e WHERE e.name Like %:name% ")
    Optional<EmployeeEntity> findByNameContaining(@Param("name") String name);


    ///  this is Named query
    List<EmployeeEntity> findAll();




    ///  this is native query
    /// Without nativeQuery = true → ❌ Spring will try to parse it as JPQL and fail.
   /* @Query(
            value = "SELECT * FROM users WHERE email = :email",
            nativeQuery = true
    )
    User getUserByEmailNative(@Param("email") String email);*/

}
