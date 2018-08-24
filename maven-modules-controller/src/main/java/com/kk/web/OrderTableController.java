package com.kk.web;

import com.kk.OrderTable;
import com.kk.OrderTableService;
import com.kk.ReturnModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-08-24 14:14:08
 */
@Api(value = "OrderTable",tags = {"订单信息"})
@RestController
public class OrderTableController {

    @Resource
    private OrderTableService orderTableService;


    @RequestMapping(value = "/getHello",method = RequestMethod.GET)
    public String getHello(){
        return  "hello";
    }

    /**
     * 新增或修改
     */
    @ApiOperation(value = "insertOrUpdate",notes = "新增或修改")
    @RequestMapping(value="/orderTable/insertOrUpdate",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insertOrUpdate(OrderTable orderTable){
        if(null == orderTable){
            orderTable = new OrderTable();
        }
        return orderTableService.insertOrUpdate(orderTable);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "insert",notes = "新增")
    @RequestMapping(value="/orderTable/insert",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel insert(OrderTable orderTable){
        return orderTableService.insert(orderTable);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "delete",notes = "删除")
    @RequestMapping(value="/orderTable/delete",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel delete(String id){
        return orderTableService.delete(id);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update",notes = "修改")
    @RequestMapping(value="/orderTable/update",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel update(OrderTable orderTable){
        return orderTableService.update(orderTable);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "getById",notes = "根据Id查询")
    @RequestMapping(value="/orderTable/getById",method = {RequestMethod.GET,RequestMethod.POST})
    public ReturnModel load(String id){
        return orderTableService.load(id);
    }

    /**
     * 全部查询
     */
    @ApiOperation(value = "getAll",notes = "全部查询")
    @RequestMapping(value="/orderTable/getAll",method = {RequestMethod.GET,RequestMethod.POST})
    public List<OrderTable> getAll(){
        return orderTableService.getAll();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "getByPageList",notes = "分页查询")
    @RequestMapping(value="/orderTable/getByPageList",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return orderTableService.pageList(offset, pagesize);
    }

}
