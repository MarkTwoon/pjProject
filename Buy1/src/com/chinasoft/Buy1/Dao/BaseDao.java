package com.chinasoft.Buy1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 

  
/**
 *  项目名称:  Buy1
 *  类名称:  BaseDao
 *  类描述:  Buy项目 数据库JDBC连接  开启和关闭  方法代码体封装
 *  创建人:  Mr.Yi
 *  创建时间:  2020.12.7
 *  @version 1.0
 */
public class BaseDao {
/*数据库 连接所需字符串常量*/
  private final String Driver="com.mysql.cj.jdbc.Driver";
	private final String URL="jdbc:mysql://www.mryiblog.top:3306/buy"
			+ "?useUnicode=true&characterEncoding=UTF-8&useSSL=false"
			+ "&&serverTimezone=UTC";
  private final String name="buy";
  private final String password="123456";
	
  /*数据库连接开启 工具方法  */
  public   Connection  getConn(){
	  Connection conn=null;
	  try {
		Class.forName(Driver);
		conn=DriverManager.getConnection(URL, name, password);
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("数据库开启异常！！");
	}
	  return conn;
  }
  
  /*数据库 连接关闭方法*/
  public  void getClose(ResultSet rs,PreparedStatement ps, Connection conn){
	  try {
		if(rs!=null){
			rs.close();	
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
		 
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("数据库关闭异常！");
	}
  }
  


}
