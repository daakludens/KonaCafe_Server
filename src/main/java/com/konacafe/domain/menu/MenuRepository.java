package com.konacafe.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    void deleteMenuById(Long id);

    boolean existsMenuByName(String name);

}
