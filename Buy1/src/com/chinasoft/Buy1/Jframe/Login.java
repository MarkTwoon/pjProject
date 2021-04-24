package com.chinasoft.Buy1.Jframe;

import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.chinasoft.Buy1.Dao.UserDao;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPasswordField;

public class Login extends JFrame{
  private JFrame jf;
  private JTextField txtadmin;
  private JLabel lblNewLabel_3 ;
  private  JLabel label_2;
  private JComboBox comboBox;
  private JPasswordField passwordField;
  
	Login(){
	  jf=new JFrame("超市会员管理系统登录界面");
	  jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	  jf.setBounds(700, 200, 900, 488);
	  jf.getContentPane().setLayout(null);
	  
	  JLabel lblNewLabel = new JLabel("");
	  lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/dog.jpg")));
	  lblNewLabel.setBounds(29, 22, 320, 407);
	  jf.getContentPane().add(lblNewLabel);
	  
	  JLabel lblNewLabel_1 = new JLabel("\u767B\u5F55\u754C\u9762");
	  lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
	  lblNewLabel_1.setBounds(489, 22, 193, 56);
	  jf.getContentPane().add(lblNewLabel_1);
	  
	  JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
	  lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 24));
	  lblNewLabel_2.setBounds(403, 88, 111, 47);
	  jf.getContentPane().add(lblNewLabel_2);
	  
	  txtadmin = new JTextField();
	  txtadmin.setFont(new Font("宋体", Font.PLAIN, 17));
	  txtadmin.setForeground(Color.BLACK);
	  txtadmin.setBounds(546, 95, 154, 40);
	  jf.getContentPane().add(txtadmin);
	  txtadmin.setColumns(10);
	  
	  JLabel label = new JLabel("\u64CD\u4F5C\u7C7B\u578B\uFF1A");
	  label.setFont(new Font("楷体", Font.BOLD, 24));
	  label.setBounds(392, 180, 135, 47);
	  jf.getContentPane().add(label);
	  
	    comboBox = new JComboBox();
	  comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u3010\u8BF7\u9009\u62E9\u3011", "\u7528\u6237", "\u7BA1\u7406\u5458", "\u987E\u5BA2\u4F1A\u5458"}));
	  comboBox.setBounds(558, 193, 142, 29);
	  jf.getContentPane().add(comboBox);
	  
	  JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
	  label_1.setFont(new Font("楷体", Font.BOLD, 24));
	  label_1.setBounds(403, 262, 111, 47);
	  jf.getContentPane().add(label_1);
	  
	  JButton btnNewButton = new JButton("\u767B\u5F55");
	  btnNewButton.setToolTipText("\u70B9\u51FB\u6211\u8FDB\u884C\u767B\u5F55");
	  btnNewButton.setBackground(Color.PINK);
	  btnNewButton.setFont(new Font("宋体", Font.BOLD, 22));
	  btnNewButton.setBounds(403, 362, 111, 47);
	  jf.getContentPane().add(btnNewButton);
	  
	  JButton button = new JButton("\u65B0\u7528\u6237\u8DF3\u8F6C\u6CE8\u518C\u754C\u9762");
	  
	  button.setFont(new Font("宋体", Font.BOLD, 22));
	  button.setBounds(591, 362, 239, 47);
	  jf.getContentPane().add(button);
	  
	    lblNewLabel_3 = new JLabel("");
	  lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 15));
	  lblNewLabel_3.setBounds(724, 102, 150, 22);
	  jf.getContentPane().add(lblNewLabel_3);
	  
	    label_2 = new JLabel("");
	  label_2.setFont(new Font("宋体", Font.BOLD, 15));
	  label_2.setBounds(724, 193, 150, 22);
	  jf.getContentPane().add(label_2);
	  
	  passwordField = new JPasswordField();
	  passwordField.setBounds(546, 270, 150, 40);
	  jf.getContentPane().add(passwordField);
	  
	  JLabel lblNewLabel_4 = new JLabel("\u7BA1\u7406\u5458\u64CD\u4F5C\u7C7B\u578B-\u8D26\u6237\uFF1A\u4E54\u5E03\u65AF  \u5BC6\u7801\uFF1A123456");
	  lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
	  lblNewLabel_4.setForeground(Color.ORANGE);
	  lblNewLabel_4.setBounds(448, 145, 382, 25);
	  jf.getContentPane().add(lblNewLabel_4);
	  
	  txtadmin.addFocusListener(new FocusListener() {
		
		  /*光标移出事件*/
		@Override  
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
		String ename=txtadmin.getText();
		if(ename.trim().equals("")){
			txtadmin.setText("请输入用户名...");
			txtadmin.setForeground(Color.lightGray);
			lblNewLabel_3.setText("请正确输入用户名！");
			lblNewLabel_3.setForeground(Color.red);
		}else{
			if(ename.trim().length()>=2&&ename.trim().length()<=6){
				lblNewLabel_3.setText("您的用户名可用！");
				lblNewLabel_3.setForeground(Color.green);
			}else{
				lblNewLabel_3.setText("用户名长度错误！");
				lblNewLabel_3.setForeground(Color.red);
			}
		}
			
			
		}
		
		/*光标移入事件*/
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			String ename=txtadmin.getText();
			if(ename.trim().equals("请输入用户名...")){
				txtadmin.setText("");
				txtadmin.setForeground(Color.black);
			}
		}
	});
	  
	  comboBox.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			 
		if(comboBox.getSelectedIndex()==0){
			label_2.setText("请正确选择操作类型");
			label_2.setForeground(Color.red);
		}else{
			label_2.setText("选择操正确!!");
			label_2.setForeground(Color.green);
		}	
		}
	});
	  button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] args={""};
			 Reg.main(args);
			jf.dispose();
		}
	});
	  btnNewButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String ename=txtadmin.getText();
	    String epassword=passwordField.getText();
	    /*判断登录角色 
	     *根据登录的不同职位  登录跳转不同界面 */
	    UserDao dao=new UserDao();
	    Map<String,Object> map=new HashMap<String,Object>(); 
	    map.put("ename", ename);
	    map.put("epassword", epassword);
	    Map<String,Object> map1=new HashMap<String,Object>(); 
	   if(comboBox.getSelectedIndex()==0){
		   JOptionPane.showMessageDialog(jf,  "登录失败，请正确选择操作类型！", "登录账户异常",JOptionPane.ERROR_MESSAGE);  
	   }else if(comboBox.getSelectedIndex()==2){
		   /*均需要调用JDBC where 
		    * 双字段账号密码匹配查询
		    * 判断是否存在此账户  进行登录*/
		   map1=dao.selectManagerOne(map);
		   /*判断查询是否存在数据记录*/
		   if(map1.containsKey("mname")){
			   /*切换至管理员主界面中去*/
			   JOptionPane.showMessageDialog(jf, "管理员登录成功！");
			   String[] args={map1.get("mname")+""};
			    InforManager.main(args);
			   jf.dispose();
		   }else{
			   JOptionPane.showMessageDialog(jf, "抱歉，无此管理员账户，请在网络环境正常下运行本软件！", "登录账户异常",JOptionPane.ERROR_MESSAGE);
		   }
	   }else if(comboBox.getSelectedIndex()==1){
		   /*JDBC*/
		   map1=dao.selectEmployeeOne(map);
		   if(map1.containsKey("ename")){
			   /*切换至超市职工主界面中去*/
			   JOptionPane.showMessageDialog(jf, "超市职工登录成功！");
			   String[] args={map1.get("eid")+"",map1.get("ename")+""};
			    InforEmployee.main(args);
			   jf.dispose();
		   }else{
			   JOptionPane.showMessageDialog(jf, "抱歉，无此职工账户，请在网络环境正常下运行本软件！", "登录账户异常",JOptionPane.ERROR_MESSAGE);
		   }
		   
	   } else if(comboBox.getSelectedIndex()==3){
		   /*JDBC*/
		 map1=dao.selectMembersOne(map);
		 if(map1.containsKey("mname")){
			   /*切换至消费者顾客主界面中去*/
			   JOptionPane.showMessageDialog(jf, "超市顾客登录成功！");
			   String[] args={map1.get("mname")+""};
			   InforMembers.main(args);
			   jf.dispose();
		   }else{
			   JOptionPane.showMessageDialog(jf, "抱歉，无此顾客VIP账户，请在网络环境正常下运行本软件！", "登录账户异常",JOptionPane.ERROR_MESSAGE);
		   }
		 
	   } 
	    
		}
	});
	  jf.setVisible(true);
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
  new Login();
	}
}
