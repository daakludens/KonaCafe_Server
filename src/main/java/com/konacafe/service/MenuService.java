package com.konacafe.service;

import com.konacafe.domain.menu.Menu;
import com.konacafe.domain.menu.MenuRepository;
import com.konacafe.dto.MenuSaveRequestDto;
import com.konacafe.exception.DuplicatedMenuException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public void save(MenuSaveRequestDto requestDto) {
        if (isNameExists(requestDto.getName())) {
            throw new DuplicatedMenuException("이미 존재하는 메뉴입니다.");
        }

        Menu menu = MenuSaveRequestDto.toEntity(requestDto);

        menuRepository.save(menu);
    }

    @Transactional
    public void update(Long id, MenuSaveRequestDto requestDto) {
        Menu menu = menuRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당되는 메뉴가 없습니다."));

        menu.update(requestDto.getName());
    }

    public void delete(Long id) {

        menuRepository.deleteMenuById(id);
    }

    public boolean isNameExists(String name) {

        return menuRepository.existsMenuByName(name);
    }
}
