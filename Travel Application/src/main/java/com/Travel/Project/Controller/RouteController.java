package com.Travel.Project.Controller;

import com.Travel.Project.Model.Route;
import com.Travel.Project.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("route")
public class RouteController {

    @Autowired
    RouteService routeService;

    @PostMapping("add")
    public ResponseEntity<String> addRoute(@RequestParam String username,@RequestParam String source,@RequestParam String destination,@RequestParam String route,@RequestParam String stops,@RequestParam Boolean isFav) {
        return  routeService.addRoute(username,source,destination,route,stops,isFav);
    }

    @GetMapping("get")
    public ResponseEntity<List<Route>> getRoute(@RequestParam String username, @RequestParam String source, @RequestParam String destination) {
       return routeService.getRoute(username,source,destination);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteRoute(@RequestParam String username, @RequestParam String source, @RequestParam String destination) {
        return routeService.deleteRoute(username,source,destination);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateRoute(@RequestParam String username,@RequestParam String source,@RequestParam String destination,@RequestParam String newRoute,@RequestParam String newStops) {
        return routeService.updateRoute(username,source,destination,newRoute,newStops);
    }

}
