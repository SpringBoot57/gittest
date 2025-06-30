package com.example.posttracking.service;

import com.example.posttracking.entity.Menu;
import com.example.posttracking.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository repository;

    @Cacheable("menus")
    public List<Menu> findAll() {
        return repository.findAll();
    }
}
