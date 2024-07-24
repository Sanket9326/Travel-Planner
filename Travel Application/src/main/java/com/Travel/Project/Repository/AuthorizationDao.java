package com.Travel.Project.Repository;

import com.Travel.Project.Model.UserData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorizationDao extends JpaRepository<UserData, Integer> {

    @Query(value = "SELECT * FROM user_data WHERE username = :Username ",nativeQuery = true)
    List<UserData> verify(@Param("Username") String username);

    @Query(value = "SELECT * FROM user_data WHERE username = :username AND password = :password",nativeQuery = true)
    List<UserData> login(@Param("username") String username,@Param("password") String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_data SET password = :newPassword WHERE username = :username AND password = :password",nativeQuery = true)
    void updatePassword(@Param("username") String username,@Param("password") String password,@Param("newPassword") String newPassword);
}
