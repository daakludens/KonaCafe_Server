package com.konacafe.model;

import com.konacafe.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuSaveRequest {

    private Long id;

    private String menuName;

    public static Menu toEntity(MenuSaveRequest menuSaveRequest) {
        return Menu.builder()
                .menuName(menuSaveRequest.getMenuName())
                .build();
    }
}
