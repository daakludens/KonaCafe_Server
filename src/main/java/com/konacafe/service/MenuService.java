package com.konacafe.service;

import com.konacafe.domain.menu.Menu;
import com.konacafe.domain.menu.MenuRepository;
import com.konacafe.model.MenuSaveRequest;
import com.konacafe.exception.DuplicatedMenuException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public void save(MenuSaveRequest menuSaveRequest) {
        if ( isNameExists(menuSaveRequest.getMenuName()) ) {
            throw new DuplicatedMenuException("이미 존재하는 메뉴입니다.");
        }

        Menu menu = MenuSaveRequest.toEntity(menuSaveRequest);

        menuRepository.save(menu);
    }

    @Transactional
    public void update(MenuSaveRequest menuSaveRequest) {
        // 본인 확인 로직 구축 후 추가 예정

//        menu.update(menuSaveRequest.getMenuName());
    }

    public void delete(Long id) {
        // 본인 확인 로직 구축 후 추가 예정

        menuRepository.deleteMenuById(id);
    }

    public boolean isNameExists(String menuName) {

        return menuRepository.existsMenuByMenuName(menuName);
    }
}
