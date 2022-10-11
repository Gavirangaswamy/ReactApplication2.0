package com.dxctechnology.reactapplication.controller;

import com.dxctechnology.reactapplication.DTO.RouteDTO;
import com.dxctechnology.reactapplication.entities.Route;
import com.dxctechnology.reactapplication.service.RouteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/addRoute")
    public Route saveRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @GetMapping("/routes")
    public List<Route> getAllRoute(){

        return routeService.getRoutes();
    }

    @GetMapping("/getRoute/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable("id") Long id){
        Route route = routeService.getRouteById(id);
        return ResponseEntity.ok(route);
    }

    @PutMapping("/updateRoute/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody RouteDTO routeDTO) {
        Route route1 = routeService.upadateRoute(id, routeDTO);
        return ResponseEntity.ok(saveRoute(route1));
    }

    @DeleteMapping("/deleteRoute/{id}")
    public ResponseEntity<Route> deleteRoute(@PathVariable Long id){
        Route route = routeService.getRouteById(id);
        routeService.deleteRoute(route);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
