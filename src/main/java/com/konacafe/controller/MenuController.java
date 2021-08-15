package com.konacafe.controller;

import com.konacafe.model.MenuSaveRequest;
import com.konacafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public void save(@RequestBody MenuSaveRequest menuSaveRequest) {

        menuService.save(menuSaveRequest);
    }

    @PutMapping
    public void update(@RequestBody MenuSaveRequest menuSaveRequest) {

        menuService.update(menuSaveRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {

        menuService.delete(id);
    }
}
