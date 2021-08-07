package com.konacafe.domain.store;

import static javax.persistence.GenerationType.IDENTITY;

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

    private String storeName;

    private String storeAddress;

    private String storeTelephone;

    @Builder
    public Store(String storeName, String storeAddress, String storeTelephone) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeTelephone = storeTelephone;
    }
}
