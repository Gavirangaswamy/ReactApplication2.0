package com.dxctechnology.reactapplication.repository;

import com.dxctechnology.reactapplication.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {


    Bus findByBusName(String name);
}
