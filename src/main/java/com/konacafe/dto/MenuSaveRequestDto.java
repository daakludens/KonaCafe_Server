package com.konacafe.dto;

import com.konacafe.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuSaveRequestDto {

    private String name;

    public static Menu toEntity(MenuSaveRequestDto menuSaveRequestDto) {
        return Menu.builder()
                .name(menuSaveRequestDto.getName())
                .build();
    }
}
