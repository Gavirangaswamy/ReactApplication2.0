package com.dxctechnology.reactapplication;

import com.dxctechnology.reactapplication.entities.Role;
import com.dxctechnology.reactapplication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ReactApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    public static void main(String[] args) {
        SpringApplication.run(ReactApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        try{
            Role role1 = new Role();
            role1.setId(101L);
            role1.setName("ROLE_NORMAL");

            Role role2 = new Role();
            role2.setId(102L);
            role2.setName("ROLE_ADMIN");

            List<Role> roles = List.of(role1, role2);
            roleRepository.saveAll(roles);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
