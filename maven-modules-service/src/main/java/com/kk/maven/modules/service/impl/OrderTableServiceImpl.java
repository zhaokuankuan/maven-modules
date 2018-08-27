package com.kk.maven.modules.service.impl;

import com.kk.maven.modules.dao.OrderTableDao;
import com.kk.maven.modules.common.ReturnModel;
import com.kk.maven.modules.domain.OrderTable;
import com.kk.maven.modules.service.OrderTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-08-24 14:14:08
 */
@Service
public class OrderTableServiceImpl implements OrderTableService {

    @Resource
    private OrderTableDao orderTableDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(OrderTable orderTable) {
        ReturnModel result = new ReturnModel();
        if (orderTable == null) {
            return result;
        }
        if(null != orderTable.getId() && !"".equals(orderTable.getId())){
            //修改
            result =  update(orderTable);
        }else{ //新增
            result = insert(orderTable);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(OrderTable orderTable) {
        ReturnModel result = new ReturnModel();
        if (orderTable == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        orderTableDao.insert(orderTable);
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除
     */
    @Override
    public ReturnModel delete(String id) {
        ReturnModel result = new ReturnModel();
        if(null == id || "".equals(id)){
            result.setMsg("id不能为空！");
            return result;
        }
        int ret = orderTableDao.delete(id);
        if(ret > 0){
            result.setSuccess(true);
            return  result;
        }else{
            return  result;
        }
    }

    /**
     * 修改
     */
    @Override
    public ReturnModel update(OrderTable orderTable) {
        ReturnModel result = new ReturnModel();
        int ret = orderTableDao.update(orderTable);
        if(ret > 0){
            result.setSuccess(true);
            return  result;
        }else{
            return  result;
        }
    }

    /**
     * 根据Id查询
     */
    @Override
    public ReturnModel load(String id) {
        ReturnModel result = new ReturnModel();
        if(null == id || "".equals(id)){
            result.setMsg("id不能为空！");
            return result;
        }
        OrderTable orderTable = orderTableDao.load(id);
        result.addDefaultModel("value",orderTable);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<OrderTable> getAll(){
        List<OrderTable> list = orderTableDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<OrderTable> pageList = orderTableDao.pageList(offset, pagesize);
        int totalCount = orderTableDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}
