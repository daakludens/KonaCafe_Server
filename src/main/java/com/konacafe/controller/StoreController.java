package com.konacafe.controller;

import com.konacafe.domain.store.Store;
import com.konacafe.model.StorePageResponse;
import com.konacafe.model.StoreSaveRequest;
import com.konacafe.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 가게 리스트 조회
     * @param pageable
     * @return StorePageResponse
     */
    @GetMapping
    public StorePageResponse getStoreLists(Pageable pageable) {
        return storeService.findAllByStoreName(pageable);
    }
}
