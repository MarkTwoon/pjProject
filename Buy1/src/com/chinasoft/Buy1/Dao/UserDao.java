package com.chinasoft.Buy1.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  ��Ŀ����: Buy1  
 *  ������:  UserDao
 *  ������:  ������Ŀ�����ݿ�  SQL���
 *  ������:  Mr.Yi  yishaoxuan
 *  ����ʱ��:  2020.12.8
 *  @version 1.0
 */
public class UserDao {
	 /* JDBC  ���ݿ� SQL���ִ�� 
	  *   sqlռλ����֧��ʹ��
	  *   ����Ҫ�ļ���  �ӿ���jdbc������
	  * */
		private Connection conn=null;
		private ResultSet rs=null;
		private PreparedStatement ps=null;
		/*����һ�����ʵ��������������ֵ
		 * ö����*/
		BaseDao dao=new BaseDao();
		/*DML ��ɾ�Ĳ���   ���ز���ֵ  SQLָ��ִ�гɹ���ʧ��*/
	   public  int  insertMembersOne(Map<String,Object> map){
		   int a=0;
		   try {
			   conn=dao.getConn();
			   String sql="insert into members  values(null,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, map.get("mname")+"");
			   ps.setString(2, map.get("mpassword")+"");
			   ps.setString(3,map.get("msex")+"");
			   ps.setString(4,map.get("mphone")+"");
			   /*1:1  ��ʱִ�����ݿ���������*/
			a=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			dao.getClose(rs, ps, conn);
		}
		   return a;
	   } 
		
		public  Map<String,Object>
		selectManagerOne(Map<String,Object> map){
		/*	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();*/
			 Map<String,Object> map1=new HashMap<String,Object>();
			conn=dao.getConn();
			String sql="select * from manager  "
					+ "  where mname=? and mpassword=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, map.get("ename")+"");
				ps.setString(2, map.get("epassword")+"");
			  rs=ps.executeQuery();
			  if(rs.next()){
				  map1.put("mid", rs.getInt("mid"));
				  map1.put("mname", rs.getString("mname"));
				  map1.put("mpassword", rs.getString("mpassword"));
			  }
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				dao.getClose(rs, ps, conn);
			}
			
			return  map1;
		}
		
		public Map<String,Object> selectEmployeeOne
		(Map<String,Object> map){
			 Map<String,Object> map1=new HashMap<String,Object>();
				conn=dao.getConn();
				String sql="select * from employee  "
						+ "  where ename=? and epassword=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, map.get("ename")+"");
					ps.setString(2, map.get("epassword")+"");
				  rs=ps.executeQuery();
				  if(rs.next()){
					  map1.put("eid", rs.getInt("eid"));
					  map1.put("ename", rs.getString("ename"));
					  map1.put("epassword", rs.getString("epassword"));
					  map1.put("esex", rs.getString("esex"));
					  map1.put("epost", rs.getString("epost"));
					  map1.put("ephone", rs.getString("ephone"));
					  map1.put("achievement", rs.getString("achievement")); 
					  map1.put("ework", rs.getString("ework"));
				  }
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					dao.getClose(rs, ps, conn);
				}
				
				return  map1;
		}
		
		public Map<String,Object> selectMembersOne
		(Map<String,Object> map){
			 Map<String,Object> map1=new HashMap<String,Object>();
				conn=dao.getConn();
				String sql="select * from members  "
						+ "  where mname=? and mpassword=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, map.get("ename")+"");
					ps.setString(2, map.get("epassword")+"");
				  rs=ps.executeQuery();
				  if(rs.next()){
					  map1.put("mid", rs.getInt("mid"));
					  map1.put("mname", rs.getString("mname"));
					  map1.put("mpassword", rs.getString("mpassword"));
					  map1.put("msex", rs.getString("msex"));
					  map1.put("mphone", rs.getString("mphone"));
				  }
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					dao.getClose(rs, ps, conn);
				}
				
				return  map1;
		}
		/*ע�� selectָ��SQL�� ����ƴ��where����
		 * ��һ����select * ���ֶ����Ƽ�����tj��where ���Ƶļ����ֶ���
		 * valueΪ  �ֶ����Ƽ���ֵ*/
		public List<Map<String,Object>>
		selectEmployeeAllOrWhere(String tj,String value){
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			try {
				conn=dao.getConn();
				String sql="select  *  from  employee  ";
				if(!tj.trim().equals("")&&!value.trim().equals("")){
					sql+="  where  "+tj+"  like  '%"+value+"%' ";
				}
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				/*JDBC �����ݿ��ṹ��  ȡֵ����*/
				while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();	
				map.put("eid", rs.getInt("eid"));
				map.put("ename", rs.getString("ename"));
				map.put("epassword", rs.getString("epassword"));
				map.put("esex", rs.getString("esex"));
				map.put("epost", rs.getString("epost"));
				map.put("ephone", rs.getString("ephone"));
				map.put("achievement", rs.getString("achievement"));
				map.put("ework", rs.getString("ework"));
				list.add(map);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return list;
			
		}
		
		public int deleteEmployeeOne(String eid){
			int a=0;
			try {
				conn=dao.getConn();
				String sql="delete from employee where eid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, eid);
				a=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return a;
		}
		
		public int insertEmployeeOne(Map<String,Object> map){
			int a=0;
			try {
				conn=dao.getConn();
				String sql="insert into employee values(null,?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, map.get("ename")+"");
				ps.setString(2, map.get("epassword")+"");
				ps.setString(3, map.get("esex")+"");
				ps.setString(4, map.get("epost")+"");
				ps.setString(5, map.get("ephone")+"");
				ps.setString(6, map.get("achievement")+"");
				ps.setString(7, map.get("ework")+"");
				a=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return a;
		}
		
		public int updateEmployeeById(Map<String,Object> map){
			int a=0;
			try {
				conn=dao.getConn();
				String sql="update employee set  "
						+ " ename=?, epassword=?,esex=?,epost=?,ephone=?,"
						+ " achievement=?,ework=? where  eid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, map.get("ename")+"");
				ps.setString(2, map.get("epassword")+"");
				ps.setString(3, map.get("esex")+"");
				ps.setString(4, map.get("epost")+"");
				ps.setString(5, map.get("ephone")+"");
				ps.setString(6, map.get("achievement")+"");
				ps.setString(7, map.get("ework")+"");
				ps.setString(8, map.get("eid")+"");
				a=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return a;
		}
		
		public List<Map<String,Object>>  selectSelgoodsAllOrWhere(String tj,String value){
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			/*�Ȳ�ѯ���ݿ�� ��������¼*/
			try {
				conn=dao.getConn();
				String sql="select * from  selgoods  ";
				if(!tj.equals("")&&!value.equals("")){
					sql+="where  "+tj+"  like   '%"+value+"%'   ";
				}
				 
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();	
				map.put("seid", rs.getInt("seid"));
				map.put("sekind", rs.getString("sekind"));
				map.put("sename", rs.getString("sename"));
				map.put("secount", rs.getString("secount"));
				map.put("seprice", rs.getString("seprice"));
				map.put("secountprice",rs.getString("secountprice"));
				map.put("setime",rs.getString("setime"));
				list.add(map);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return list;
		} 
		
		public int deleteSelgoodsById(String seid){
			int a=0;
			try {
				conn=dao.getConn();
			String sql="delete from selgoods where seid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, seid);
			a=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return a;
		} 
		
		public int  insertGoodsOne(Map<String,Object> map){
			int a=0;
			try {
				conn=dao.getConn();
				String sql="insert into goods values(null,?,?,?,?) ";
				ps=conn.prepareStatement(sql);
				ps.setString(1, map.get("gkind")+"");
				ps.setString(2, map.get("gname")+"");
				ps.setString(3, map.get("price")+"");
				ps.setString(4, map.get("gcount")+"");
				a=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return a;
		}
		
		
		public int  updateGoodsById(Map<String,Object> map){
			int a=0;
			try {
				conn=dao.getConn();
				String sql="update  selgoods  set  "
						+ " sekind=?, "
						+ "sename=?, "
						+ "secount=?,  "
						+ "seprice=?, "
						+ "secountprice=?, "
						+ "setime=?  where seid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, map.get("sekind")+"");
				ps.setString(2, map.get("sename")+"");
				ps.setString(3, map.get("secount")+"");
				ps.setString(4, map.get("seprice")+"");
				ps.setString(5, map.get("secountprice")+"");
				ps.setString(6, map.get("setime")+"");
				ps.setString(7, map.get("seid")+"");
				a=ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				
			}finally{
				dao.getClose(rs, ps, conn);
			}
			return a;
		}
		
}
