package com.dxctechnology.reactapplication.service;

import com.dxctechnology.reactapplication.DTO.BusDTO;
import com.dxctechnology.reactapplication.exception.ResourceNotFoundException;
import com.dxctechnology.reactapplication.entities.Bus;
import com.dxctechnology.reactapplication.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> getBuses() {
        return busRepository.findAll();
    }
     public Bus getBusByName(String name) {
        return busRepository.findByBusName(name);
     }

     public Bus getBusById(Long id) {
        return busRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Bus not found with id " + id));
     }

    public Bus addBus(BusDTO busDTO) {
        Bus bus = dtoToBus(busDTO);
        return busRepository.save(bus);

    }

    public void delete(Bus bus) {
        busRepository.delete(bus);
    }


    public Bus dtoToBus(BusDTO dto) {
        Bus bus = Bus.builder()
        		.id(dto.getId())
        		.busName(dto.getBusName())
        		.registration(dto.getRegistration())
        		.type(dto.getType())
        		.noOfSeats(dto.getNoOfSeats())
        		.build();
        return bus;
    }
    public BusDTO busToDTO(Bus bus) {
        BusDTO busDTO = BusDTO.builder()
        		.id(bus.getId())
        		.busName(bus.getBusName())
        		.registration(bus.getRegistration())
        		.type(bus.getType())
        		.noOfSeats(bus.getNoOfSeats())
        		.build();
        return busDTO;

    }
    public Bus upadateBus(Long id, BusDTO busDTO) {
        Bus bus = getBusById(id);
        bus.setBusName(busDTO.getBusName());
        bus.setRegistration(busDTO.getRegistration());
        bus.setType(busDTO.getType());
        bus.setNoOfSeats(busDTO.getNoOfSeats());
        return addBus(busDTO);
    }
}