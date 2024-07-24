package com.Travel.Project.Repository;

import com.Travel.Project.Model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavDao extends JpaRepository<Favourite,Integer> {

}
