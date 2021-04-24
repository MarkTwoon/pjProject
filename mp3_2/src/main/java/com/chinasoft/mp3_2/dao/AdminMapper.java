package com.chinasoft.mp3_2.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
public List<Map<String,Object>> selectAdminAll();
public  List<Map<String,Object>> selectUserByNameAndPassWord(Map<String,Object> map);
public List<Map<String,Object>>  selectMp3Index(Map<String,Object> map);
public boolean  insertMp3Data(Map<String,Object> map);
public boolean deleteMp3DataByIds(String[] mp3Ids);
}
