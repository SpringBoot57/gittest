package com.example.posttracking.controller;

import com.example.posttracking.entity.Menu;
import com.example.posttracking.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService service;

    @GetMapping
    public ResponseEntity<List<Menu>> list() {
        return ResponseEntity.ok(service.findAll());
    }
}
