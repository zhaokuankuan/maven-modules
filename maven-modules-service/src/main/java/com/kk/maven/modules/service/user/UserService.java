package com.kk.maven.modules.service.user;

import com.kk.maven.modules.common.ReturnModel;
import com.kk.maven.modules.domain.user.User;

import java.util.List;
import java.util.Map;

/**
 * 用户信息
 * Created  by Mr.kk
 * DateTime on 2018-09-03 10:19:20
 */
public interface UserService {

    /**
     * 新增或修改
     */
    public ReturnModel insertOrUpdate(User user);

    /**
     * 新增
     */
    public ReturnModel insert(User user);

    /**
     * 删除
     */
    public ReturnModel delete(String id);

    /**
     * 更新
     */
    public ReturnModel update(User user);

    /**
     * 根据Id查询
     */
    public ReturnModel load(String id);

    /**
     * 全部查询
     */
    public List<User> getAll();

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
