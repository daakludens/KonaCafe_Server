package com.konacafe.domain.store;

import static javax.persistence.GenerationType.IDENTITY;

import com.konacafe.model.StoreSaveRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String storeAddress;

    @Column(nullable = false)
    private String storeTelephone;

    @Column(name = "is_deleted")
    private Boolean deleted = false;

    @Builder
    public Store(String storeName, String storeAddress, String storeTelephone) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeTelephone = storeTelephone;
    }

    public void updateStore(StoreSaveRequest storeSaveRequest) {
        this.storeName = storeSaveRequest.getStoreName();
        this.storeAddress = storeSaveRequest.getStoreAddress();
        this.storeTelephone = storeSaveRequest.getStoreTelephone();
    }

    public void deleteStore() {
        this.deleted = true;
    }
}
