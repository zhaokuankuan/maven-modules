package com.kk.maven.modules.dao.orderTable;

import com.kk.maven.modules.domain.OrderTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单信息
 * Created  by Mr.kk
 * DateTime on 2018-08-24 14:14:08
 */
public interface OrderTableDao {

    /**
     * 新增
     */
    public int insert(@Param("orderTable") OrderTable orderTable);

    /**
     * 删除
     */
    public int delete(@Param("id") String id);

    /**
     * 更新
     */
    public int update(@Param("orderTable") OrderTable orderTable);

    /**
     * Load查询
     */
    public OrderTable load(@Param("id") String id);

    /**
     * Load查询
     */
    public List<OrderTable> getAll();


    /**
     * 分页查询Data
     */
    public List<OrderTable> pageList(@Param("offset") int offset,
                                     @Param("pagesize") int pagesize);

    /**
     * 分页查询Count
     */
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize);

}
