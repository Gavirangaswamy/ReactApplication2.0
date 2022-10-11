package com.dxctechnology.reactapplication.controller;

import com.dxctechnology.reactapplication.DTO.BusDTO;
import com.dxctechnology.reactapplication.entities.Bus;
import com.dxctechnology.reactapplication.service.BusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class BusController  {

    @Autowired
    private BusService busService;

    @PostMapping("/addBus")
    public Bus saveBus(@RequestBody BusDTO bus) {
        return busService.addBus(bus);
    }

    @GetMapping("/buses")
    public List<Bus> getAllBus(){
        return busService.getBuses();
    }

    @GetMapping("/getBus/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable("id") Long id){
        Bus busById = busService.getBusById(id);
        return ResponseEntity.ok(busById);
    }

    @PutMapping("/updateBus/{id}")
    public ResponseEntity<Bus> upadateBus(@PathVariable Long id, @RequestBody BusDTO busDTO) {
        Bus busById = busService.upadateBus(id, busDTO);
        return ResponseEntity.ok(busById);
    }

    @DeleteMapping("/deleteBus/{id}")
    public ResponseEntity<Bus> deleteBus(@PathVariable Long id){
        Bus bus = busService.getBusById(id);
        busService.delete(bus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
