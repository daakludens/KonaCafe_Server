package com.konacafe.controller;

import com.konacafe.dto.MenuSaveRequestDto;
import com.konacafe.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public void save(@RequestBody MenuSaveRequestDto requestDto) {

        menuService.save(requestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody MenuSaveRequestDto requestDto) {

        menuService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        menuService.delete(id);
    }
}
