package com.chinasoft.mp3_2.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AdminService {
    public List<Map<String,Object>> selectAdminAll();
    public  List<Map<String,Object>> selectUserByNameAndPassWord(Map<String,Object> map);
    public List<Map<String,Object>>  selectMp3Index(Map<String,Object> map);
    public boolean  insertMp3Data(Map<String,Object> map);
    public boolean deleteMp3DataByIds(String[] mp3Ids,String[] mp3ManImgs,String[] mp3Srcs, HttpServletRequest request);
}
