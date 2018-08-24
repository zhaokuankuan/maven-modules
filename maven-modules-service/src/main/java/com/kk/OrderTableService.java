package com.kk;

import java.util.List;
import java.util.Map;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-08-24 14:14:08
 */
public interface OrderTableService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(OrderTable orderTable);

    /**
     * 新增
     */
    public ReturnModel insert(OrderTable orderTable);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(OrderTable orderTable);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<OrderTable> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
