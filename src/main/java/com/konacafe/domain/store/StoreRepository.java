package com.konacafe.domain.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT s FROM Store s WHERE s.id = :storeId")
    public Store findStoreById(Long storeId);

    public boolean existsByStoreTelephone(String telephone);
}