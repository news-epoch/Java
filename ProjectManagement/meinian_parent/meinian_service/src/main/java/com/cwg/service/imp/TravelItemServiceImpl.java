package com.cwg.service.imp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.container.page.PageHandler;
import com.cwg.dao.TravelItemDao;
import com.cwg.entity.PageResult;
import com.cwg.entity.Result;
import com.cwg.pojo.TravelItem;
import com.cwg.service.TravelItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = TravelItemService.class)   //发布服务 注册到zk中心
@Transactional //声明式事务问题
public class TravelItemServiceImpl implements TravelItemService {

    @Autowired  //调用本地服务
    TravelItemDao travelItemDao;


    @Override
    public void add(TravelItem travelItem) {
        travelItemDao.add(travelItem);
    }

    @Override
    public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
        //分页插件 第一个问号：当前页计算 (current -1) * pageSize
        PageHelper.startPage(currentPage, pageSize); //limit ?,?
        Page page = travelItemDao.findPage(queryString);
        return new PageResult(page.getTotal(), page.getResult());//第一个参数表示总记录数，第二个数据表示分页数据集合
    }

    @Override
    public void delete(Integer id) {
        travelItemDao.delete(id);
    }

    @Override
    public TravelItem findById(Integer id) {
        return travelItemDao.findById(id);
    }

    @Override
    public void edit(TravelItem travelItem) {
        travelItemDao.edit(travelItem);
    }
}
