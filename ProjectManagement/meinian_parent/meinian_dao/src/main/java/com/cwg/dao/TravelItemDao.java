package com.cwg.dao;

import com.cwg.pojo.TravelItem;
import com.github.pagehelper.Page;

public interface TravelItemDao {

    void add(TravelItem travelItem);

    Page findPage(String queryString);

    void delete(Integer id);

    TravelItem findById(Integer id);

    void edit(TravelItem travelItem);
}
