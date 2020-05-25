package com.ccarlos.store.service.api;

import java.util.Date;

public interface StoreServiceApi {

    int selectVersion(String supplierId, String goodsId);

    int updateStoreCountByVersion(int version, String supplierId, String goodsId,
                                  String updateBy, Date updateTime);

    int selectStoreCount(String supplierId, String goodsId);
}
