package com.example.lib.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestEndPoint {  //spring security deneme controller

    @GetMapping("/admin")
    public String adminEndPoint(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/public")
    public String publicController(){
        return "public";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/justadmin")
    public String justAdmin(){
        return "justAdmin";
    }

    @GetMapping("/username")
    public String getMyself(){ //o an login olan kullanıcının bilgilerini SecurityContextHolder ile birlikte bulabiliriz.
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername().toString();
    }

}
