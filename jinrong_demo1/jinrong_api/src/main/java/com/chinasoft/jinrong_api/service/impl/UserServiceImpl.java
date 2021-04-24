package com.chinasoft.jinrong_api.service.impl;

import com.chinasoft.jinrong_api.dao.IUserDao;
import com.chinasoft.jinrong_api.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
@Resource
    private IUserDao userDao;

    @Override
    public Object selectGoodsAll(String goodsId) {
        return userDao.selectGoodsAll(goodsId);
    }

    @Override
    public List<Map<String, Object>> selectCityMainByWhere(Map<String, Object> map) {
        return userDao.selectCityMainByWhere(map);
    }

    @Override
    public List<Map<String, Object>> selectIndexPageHeadNumber(Map<String, Object> map) {
        return userDao.selectIndexPageHeadNumber(map);
    }

    @Override
    public List<Map<String, Object>> selectCityCouponByCityId(Map<String, Object> map) {
        return userDao.selectCityCouponByCityId(map);
    }

    @Override
    public List<Map<String, Object>> selectSuccessUserList(Map<String, Object> map) {
        return userDao.selectSuccessUserList(map);
    }

    @Override
    public List<Map<String, Object>> selectBusinessTypeList() {
        return
                userDao.selectBusinessTypeList();
    }

    @Override
    public List<Map<String, Object>> ActivitiesCouponListToIndex(Map<String, Object> map) {
        return
                userDao.ActivitiesCouponListToIndex(map);
    }

    @Override
    public List<Map<String, Object>> selectUserNameAndPassWord(Map<String, Object> map) {
        return userDao.selectUserNameAndPassWord(map);
    }

    @Override
    public boolean insertUserMain(Map<String, Object> map) {
        return userDao.insertUserMain(map);
    }
}
