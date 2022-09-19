package com.cwg.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cwg.constant.MessageConstant;
import com.cwg.entity.PageResult;
import com.cwg.entity.QueryPageBean;
import com.cwg.entity.Result;
import com.cwg.pojo.TravelItem;
import com.cwg.service.TravelItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController   //@Controller + @ResponseBody
@RequestMapping("/TravelItem")
public class TravelItemController {

    @Reference    //远程调用服务
    TravelItemService travelItemService;

    //表单项的参数名称必须与实体对象熟悉相同，提供对应的set方法，
    @RequestMapping(value = "/add")
    public Result add(@RequestBody TravelItem travelItem) {
        try {
            travelItemService.add(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = travelItemService.findPage(queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(), queryPageBean.getQueryString());
        return pageResult;

    }

    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            travelItemService.delete(id);
            return new Result(true, MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            return new Result(false, MessageConstant.DELETE_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            TravelItem data = travelItemService.findById(id);
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, data);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody TravelItem travelItem) {
        try {
            travelItemService.edit(travelItem);
            return new Result(true, MessageConstant.EDIT_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            return new Result(false, MessageConstant.EDIT_TRAVELITEM_FAIL);
        }
    }
}
