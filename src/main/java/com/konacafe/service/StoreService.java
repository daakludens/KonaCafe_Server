package com.konacafe.service;

import com.konacafe.domain.store.Store;
import com.konacafe.domain.store.StoreRepository;
import com.konacafe.exception.StoreDuplicatedException;
import com.konacafe.model.StorePageResponse;
import com.konacafe.model.StoreResponse;
import com.konacafe.model.StoreSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void saveStoreInfo(Store storeInfo) {
        boolean isDuplicatedPhone = isDuplicatedTelephone(storeInfo.getStoreTelephone());

        if(isDuplicatedPhone) {
            throw new StoreDuplicatedException("이미 등록되어 있는 가게입니다.");
        }

        storeRepository.save(storeInfo);
    }

    public boolean isDuplicatedTelephone(String telephone) {
        return storeRepository.existsByStoreTelephone(telephone);
    }

    @Transactional(readOnly = true)
    public StorePageResponse findAllByStoreName(Pageable pageable) {
        Page<Store> stores = storeRepository.findAll(pageable);

        List<StoreResponse> storeList = stores.getContent().stream()
                                                .map(StoreResponse::of)
                                                .collect(Collectors.toList());

        return StorePageResponse.builder()
                    .totalPage(stores.getTotalPages())
                    .currentPage(pageable.getPageNumber())
                    .storeList(storeList).build();
    }

    @Transactional
    public void updateStoreInfo(StoreSaveRequest storeSaveRequest) {
//        로그인 권한 체크 후 업데이트 처리 할 예정
//
//        store.updateStore(storeSaveRequest);
    }

    public void deleteStore(Long id) {
        //로그인 권한 체크 후 삭제처리가 가능하도록 할 예정

        Store store = storeRepository.findStoreById(id);
        store.deleteStore();
    }
}
