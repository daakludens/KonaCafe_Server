package com.konacafe.service;

import com.konacafe.domain.store.Store;
import com.konacafe.domain.store.StoreRepository;
import com.konacafe.exception.StoreDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void saveStoreInfo(Store storeInfo) {
        boolean isDuplicatedPhone = isDuplicatedTelephone(storeInfo.getStoreTelephone());

        if(isDuplicatedPhone) {
            throw new StoreDuplicatedException("이미 등록 된 가게입니다.");
        }

        storeRepository.save(storeInfo);
    }

    public boolean isDuplicatedTelephone(String telephone) {
        return storeRepository.existsByStoreTelephone(telephone);
    }
}
