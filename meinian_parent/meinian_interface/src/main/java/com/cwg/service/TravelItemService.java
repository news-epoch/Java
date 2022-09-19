package com.cwg.service;

import com.cwg.entity.PageResult;
import com.cwg.entity.Result;
import com.cwg.pojo.TravelItem;

public interface TravelItemService {
    void add(TravelItem travelItem);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

    void delete(Integer id);

    TravelItem findById(Integer id);

    void edit(TravelItem travelItem);
}
