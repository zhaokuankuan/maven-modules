package com.kk.maven.modules.service.impl.user;

import com.kk.maven.modules.common.DateUtils;
import com.kk.maven.modules.common.ReturnModel;
import com.kk.maven.modules.common.StringUtil;
import com.kk.maven.modules.dao.user.UserDao;
import com.kk.maven.modules.domain.user.User;
import com.kk.maven.modules.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 * Created  by Mr.kk
 * DateTime on 2018-09-03 10:19:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增或修改
     */
    @Override
    public ReturnModel insertOrUpdate(User user) {
        ReturnModel result = new ReturnModel();
        if (user == null) {
            return result;
        }
        if(null != user.getId() && !"".equals(user.getId())){
            //修改
            result =  update(user);
        }else{ //新增
            result = insert(user);
        }
        return result;
    }

    /**
     * 新增
     */
    @Override
    public ReturnModel insert(User user) {
        ReturnModel result = new ReturnModel();
        if (user == null) {
            result.addDefaultModel("404","必要参数缺失");
            return result;
        }
        user.setId(StringUtil.createUUID());
        user.setCreateTime(DateUtils.getTs());
        userDao.insert(user);
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
        int ret = userDao.delete(id);
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
    public ReturnModel update(User user) {
        ReturnModel result = new ReturnModel();
        user.setModifyTime(DateUtils.getTs());
        int ret = userDao.update(user);
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
        User user = userDao.load(id);
        result.addDefaultModel("value",user);
        result.setSuccess(true);
        return result;
    }

    /**
     * 全部查询
     */
    public List<User> getAll(){
        List<User> list = userDao.getAll();
        return list;
    };

    /**
     * 分页查询
     */
    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        List<User> pageList = userDao.pageList(offset, pagesize);
        int totalCount = userDao.pageListCount(offset, pagesize);
        // 分页查询的数据的返回
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return result;
    }

}
