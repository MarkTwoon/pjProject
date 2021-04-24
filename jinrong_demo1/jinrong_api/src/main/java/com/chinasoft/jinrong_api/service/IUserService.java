package com.chinasoft.jinrong_api.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public Object selectGoodsAll(String goodsId);
    public List<Map<String,Object>> selectCityMainByWhere(Map<String,Object> map);
    public List<Map<String,Object>>  selectIndexPageHeadNumber(Map<String,Object> map);
    public List<Map<String,Object>> selectCityCouponByCityId(Map<String,Object> map);
    public List<Map<String,Object>>  selectSuccessUserList(Map<String,Object> map);
    public List<Map<String,Object>>  selectBusinessTypeList();
    public List<Map<String,Object>> ActivitiesCouponListToIndex(Map<String,Object> map);
    public List<Map<String,Object>> selectUserNameAndPassWord(Map<String,Object> map);
    public boolean insertUserMain(Map<String,Object> map);
}
