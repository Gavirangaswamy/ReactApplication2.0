package com.dxctechnology.reactapplication.service;

import com.dxctechnology.reactapplication.DTO.BusDTO;
import com.dxctechnology.reactapplication.DTO.RouteDTO;
import com.dxctechnology.reactapplication.entities.Bus;
import com.dxctechnology.reactapplication.exception.ResourceNotFoundException;
import com.dxctechnology.reactapplication.entities.Route;
import com.dxctechnology.reactapplication.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getRoutes() {

        return routeRepository.findAll();
    }

     public Route getRouteById(Long id) {
        return routeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Route not found with id " + id));
     }

    public Route addRoute(Route route) {

        return routeRepository.save(route);
    }
    public void deleteRoute(Route route) {

        routeRepository.delete(route);
    }
    public Route upadateRoute(Long id, RouteDTO routeDTO) {
        Route route = getRouteById(id);
        route.setId(routeDTO.getId());
        route.setBusId(routeDTO.getBusId());
        route.setRouteName(routeDTO.getRouteName());
        route.setOrigin(routeDTO.getOrigin());
        route.setDestination(routeDTO.getDestination());
        route.setTravelDate(routeDTO.getTravelDate());
        route.setDepartureTime(routeDTO.getDepartureTime());
        route.setFare(routeDTO.getFare());
        return route;
    }

}
