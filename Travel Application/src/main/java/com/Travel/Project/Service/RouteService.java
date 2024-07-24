package com.Travel.Project.Service;

import com.Travel.Project.Model.Favourite;
import com.Travel.Project.Model.Route;
import com.Travel.Project.Repository.FavDao;
import com.Travel.Project.Repository.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteDao routeDao;

    @Autowired
    FavDao favDao;

    public ResponseEntity<String> addRoute(String username, String sorurce, String destination, String route, String stops,Boolean isFav) {
        try{

            if(isFav){
                Favourite fav = new Favourite();
                fav.setUsername(username);
                fav.setDestination(destination);
                favDao.save(fav);
            }

            Route path = new Route();
            path.setDestination(destination);
            path.setSource(sorurce);
            path.setRoute(route);
            path.setStops(stops);
            path.setUsername(username);
            routeDao.save(path);
            return new ResponseEntity<>("Travel Plan Add", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Route>> getRoute(String username, String source, String destination) {
        try {
            List<Route> plan = routeDao.getRoute(username,source,destination);
            return new ResponseEntity<>(plan,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteRoute(String username, String source, String destination) {
        try {
            routeDao.deleteRoute(username,source,destination);
            return new ResponseEntity<>("Travel Plan Deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateRoute(String username, String source, String destination,String newRoute, String newStops) {
       try{
           routeDao.updateRoute(username,source,destination,newRoute,newStops);
           return new ResponseEntity<>("Travel Plan Updated", HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
       }
    }
}
