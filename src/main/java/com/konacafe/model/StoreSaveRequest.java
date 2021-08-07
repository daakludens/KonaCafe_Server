package com.konacafe.model;

import com.konacafe.domain.store.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreSaveRequest {

    private String storeName;

    private String storeAddress;

    private String storeTelephone;

    public static Store toEntity(StoreSaveRequest storeSaveRequest) {
        return Store.builder()
                    .storeName(storeSaveRequest.getStoreName())
                    .storeAddress(storeSaveRequest.getStoreAddress())
                    .storeTelephone(storeSaveRequest.getStoreTelephone())
                    .build();
    }
}
