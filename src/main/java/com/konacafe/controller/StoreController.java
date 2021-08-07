package com.konacafe.controller;

import com.konacafe.domain.store.Store;
import com.konacafe.model.StoreSaveRequest;
import com.konacafe.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    /**
     * 가게 정보 저장
     * @body StoreSaveRequest
     */
    @PostMapping
    public void saveStoreInfo(@RequestBody StoreSaveRequest storeSaveRequest) {
        Store storeInfo = StoreSaveRequest.toEntity(storeSaveRequest);

        storeService.saveStoreInfo(storeInfo);
    }
}
