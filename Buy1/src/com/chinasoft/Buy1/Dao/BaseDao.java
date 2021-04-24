package com.chinasoft.Buy1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 

  
/**
 *  ��Ŀ����:  Buy1
 *  ������:  BaseDao
 *  ������:  Buy��Ŀ ���ݿ�JDBC����  �����͹ر�  �����������װ
 *  ������:  Mr.Yi
 *  ����ʱ��:  2020.12.7
 *  @version 1.0
 */
public class BaseDao {
/*���ݿ� ���������ַ�������*/
  private final String Driver="com.mysql.cj.jdbc.Driver";
	private final String URL="jdbc:mysql://www.mryiblog.top:3306/buy"
			+ "?useUnicode=true&characterEncoding=UTF-8&useSSL=false"
			+ "&&serverTimezone=UTC";
  private final String name="buy";
  private final String password="123456";
	
  /*���ݿ����ӿ��� ���߷���  */
  public   Connection  getConn(){
	  Connection conn=null;
	  try {
		Class.forName(Driver);
		conn=DriverManager.getConnection(URL, name, password);
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("���ݿ⿪���쳣����");
	}
	  return conn;
  }
  
  /*���ݿ� ���ӹرշ���*/
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
		System.out.println("���ݿ�ر��쳣��");
	}
  }
  


}
