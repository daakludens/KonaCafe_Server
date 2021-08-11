package com.konacafe.model;

import com.konacafe.domain.store.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StorePageResponse {

    private int totalPage;

    private int currentPage;

    private List<StoreResponse> storeList = new ArrayList<>();

    @Builder
    public StorePageResponse(int totalPage, int currentPage, List<StoreResponse> storeList) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.storeList = storeList;
    }
}
