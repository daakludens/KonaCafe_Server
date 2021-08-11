package com.konacafe.model;

import com.konacafe.domain.store.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponse {

    private Long id;

    private String storeName;

    private String storeAddress;

    private String storeTelephone;

    public static StoreResponse of(Store store) {
        return StoreResponse.builder()
                .id(store.getId())
                .storeName(store.getStoreName())
                .storeAddress(store.getStoreAddress())
                .storeTelephone(store.getStoreTelephone()).build();
    }
}
