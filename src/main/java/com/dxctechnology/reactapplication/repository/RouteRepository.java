package com.dxctechnology.reactapplication.repository;

import com.dxctechnology.reactapplication.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {


}
