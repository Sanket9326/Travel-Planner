package com.Travel.Project.Repository;

import com.Travel.Project.Model.Route;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteDao extends JpaRepository<Route, Integer> {

    @Query(value = "SELECT * FROM Route Where username = :username AND source = :source AND destination = :destination",nativeQuery = true)
    List<Route> getRoute(@Param("username") String username,@Param("source") String source,@Param("destination") String destination);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Route Where username = :username AND source = :source AND destination = :dest",nativeQuery = true)
    void deleteRoute(@Param("username") String username,@Param("source") String source,@Param("dest") String destination);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Route SET route = :rr,stops = :newStops WHERE username = :username and destination = :dest and source = :source ",nativeQuery = true)
    void updateRoute(@Param("username") String username,@Param("source") String source,@Param("dest") String destination,@Param("rr") String newRoute,@Param("newStops") String newStops);
}
