package com.chinasoft.Buy1.Jframe;

import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.chinasoft.Buy1.Dao.UserDao;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Reg extends JFrame{
    JFrame jf;
    private JTextField textField;
    private JTextField textField_1;
    private 	JLabel lblNewLabel_1;
    private JLabel label_2;
    private JLabel label_3;
    private ButtonGroup buttonGroup=new ButtonGroup();
    private JLabel label_4;
    private JTextField textField_2;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton radioButton;
    private JComboBox comboBox_1;
    private JComboBox comboBox;
    private JLabel label_7;
    private JLabel label_8;
	Reg(){
		jf=new JFrame("超市收银系统会员注册界面");
		
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setBounds(620, 160, 800, 755);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u4F1A\u5458\u6CE8\u518C\u754C\u9762");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel.setBounds(263, 22, 224, 47);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 24));
		label.setBounds(124, 89, 122, 47);
		jf.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setToolTipText("\u8BF7\u8F93\u5165\u60A8\u7684\u7528\u6237\u540D");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		textField.setBounds(257, 89, 271, 47);
		 
		
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 24));
		label_1.setBounds(124, 164, 122, 47);
		jf.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801");
		textField_1.setText("\u8BF7\u8F93\u5165\u5BC6\u7801");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(257, 168, 271, 47);
		jf.getContentPane().add(textField_1);
		
		  lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(559, 103, 215, 21);
		jf.getContentPane().add(lblNewLabel_1);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("黑体", Font.PLAIN, 15));
		label_2.setBounds(559, 184, 215, 21);
		jf.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u6027  \u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 24));
		label_3.setBounds(124, 246, 122, 47);
		jf.getContentPane().add(label_3);
		
		  rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(263, 254, 63, 38);
		buttonGroup.add(rdbtnNewRadioButton);
		jf.getContentPane().add(rdbtnNewRadioButton);
		
		  radioButton = new JRadioButton("\u5973");
		radioButton.setBounds(376, 254, 78, 38);
		buttonGroup.add(radioButton);
		jf.getContentPane().add(radioButton);
		
		label_4 = new JLabel("\u8D85\u5E02\u5BF9\u8C61\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 24));
		label_4.setBounds(101, 319, 145, 47);
		jf.getContentPane().add(label_4);
		
		  comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u3010\u8BF7\u9009\u62E9\u3011", "\u987E\u5BA2\u4F1A\u5458"}));
		comboBox.setBounds(263, 330, 238, 32);
		jf.getContentPane().add(comboBox);
		
		JLabel label_5 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 24));
		label_5.setBounds(101, 405, 145, 47);
		jf.getContentPane().add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("\u8BF7\u8F93\u5165\u60A8\u7684\u624B\u673A\u53F7\u7801");
		textField_2.setBounds(257, 414, 271, 38);
		jf.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_6 = new JLabel("\u64CD\u4F5C\u7C7B\u578B\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 24));
		label_6.setBounds(101, 487, 145, 47);
		jf.getContentPane().add(label_6);
		
		  comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u3010\u8BF7\u9009\u62E9\u3011", "\u6D88\u8D39\u8005"}));
		comboBox_1.setBounds(263, 498, 238, 32);
		jf.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBackground(new Color(64, 224, 208));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setBounds(124, 613, 133, 54);
		jf.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u5DF2\u6709\u8D26\u6237\uFF0C\u8DF3\u8F6C\u767B\u5F55");
		button.setBackground(new Color(127, 255, 0));
		button.setFont(new Font("宋体", Font.BOLD, 16));
		button.setBounds(351, 613, 221, 54);
		jf.getContentPane().add(button);
		
		label_7 = new JLabel("");
		label_7.setFont(new Font("黑体", Font.PLAIN, 15));
		label_7.setBounds(559, 339, 215, 21);
		jf.getContentPane().add(label_7);
		
		label_8 = new JLabel("");
		label_8.setFont(new Font("黑体", Font.PLAIN, 15));
		label_8.setBounds(559, 507, 215, 21);
		jf.getContentPane().add(label_8);
		textField.addFocusListener(new FocusListener() {
			/*对于该GUI文本框控件  添加光标的移入移出事件 监听器*/
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				String ename=textField.getText();
				/*如果光标移出文本框但未输入任何值
				 * 则该文本框复位为默认输入提示*/
				if(ename.trim().equals("")){
					textField.setText("请输入用户名");
					textField.setForeground(Color.lightGray);
					lblNewLabel_1.setText("用户名不能为空！");
					lblNewLabel_1.setForeground(Color.red);
				}else{
					if(ename.trim().length()>=2&&ename.trim().length()<=6){
						lblNewLabel_1.setText("您的用户名可用！");
						lblNewLabel_1.setForeground(Color.green);
					}else{
						lblNewLabel_1.setText("用户名长度错误！(3-6位长度)");
						lblNewLabel_1.setForeground(Color.red);
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				String ename=textField.getText();
			 /*光标移入文本框  则提示信息情况，将该文本框
			  * 设置输入 黑色字体*/
				if(ename.trim().equals("请输入用户名")){
					textField.setText("");
					textField.setForeground(Color.black);
				} 
			}
		});
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				String password=textField_1.getText();
				if(password.trim().equals("")){
					textField_1.setText("请输入密码");
					textField_1.setForeground(Color.lightGray);
					label_2.setText("密码不能为空！");
					label_2.setForeground(Color.red);
				}else{
					if(password.trim().length()>=5&&password.trim().length()<=12){
						label_2.setText("您的密码可用！");
						label_2.setForeground(Color.green);
					}else{
						label_2.setText("密码长度错误！(5-12位长度)");
						label_2.setForeground(Color.red);
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				String password=textField_1.getText();
				if(password.trim().equals("请输入密码")){
					textField_1.setText("");
					textField_1.setForeground(Color.black);
				}
			}
		});
		comboBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getSelectedItem().toString().equals("【请选择】")){
					label_7.setText("请选择正确职位！！");
					label_7.setForeground(Color.red);
				}else{
					label_7.setText("选择正确！！");
					label_7.setForeground(Color.green);
				}
			}
			
		});
		comboBox_1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_1.getSelectedItem().toString().equals("【请选择】")){
					label_8.setText("请选择正确职位！！");
					label_8.setForeground(Color.red);
				}else{
					label_8.setText("选择正确！！");
					label_8.setForeground(Color.green);
				}
			}
		 
		});
		
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		    String ename=textField.getText();
		    String epassword=textField_1.getText();
		    String esex="";
			 if(rdbtnNewRadioButton.isSelected()){
				esex=rdbtnNewRadioButton.getText();
			}else{
				 esex=radioButton.getText();
			}
			 String epost=comboBox.getSelectedItem()+"";
			 String ephone=textField_2.getText();
	 	 String  achievement=comboBox_1.getSelectedItem()+"";
	 	 int ework=0;
		   	 if(achievement.equals("消费者")){
		   		 if(epost.equals("顾客会员")
		   				 &&lblNewLabel_1.getText().equals("您的用户名可用！")
		   				&&label_2.getText().equals("您的密码可用！")
		   				 ){
                  /*准备向数据库insert  新增注册账户
                   * JDBC 数据后端新增过程  调用SQL指令执行  。。。忽略*/
		   			/* 使用map虚拟容器  夹带键值对  存储多个基本变量 传递*/
		   			 Map<String,Object> map=new HashMap<String,Object>(); 
		   			map.put("mname", ename);
		   			map.put("mpassword", epassword);
		   			map.put("msex", esex);
		   		/*	map.put("epost", epost);*/
		   			map.put("mphone", ephone);
		   		/*	map.put("achievement", achievement);
		   			map.put("ework", ework);*/
		   			UserDao dao=new UserDao();
		   			if(dao.insertMembersOne(map)>0){
		   			 JOptionPane.showMessageDialog(jf, "会员注册成功！");
		   			 /*注册成功后 ，切换登录界面*/
		   			String[] args={""};
					 Login.main(args);
					jf.dispose();
		   			}else{
		   				JOptionPane.showMessageDialog(jf,  "会员注册失败，请在网络环境正常下运行本软件！", "注册失败错误",JOptionPane.ERROR_MESSAGE);
		   				//JOptionPane.showMessageDialog(Reg.this, "会员注册失败，请在网络环境正常下运行本软件！",JOptionPane.ERROR_MESSAGE);
		   			}
		   			 
		   		 }else{
		   			 if(epost.equals("【请选择】")){
		   				label_7.setText("请选择正确职位！！");
						label_7.setForeground(Color.red);
		   			 }
		   			JOptionPane.showMessageDialog(jf, "会员注册失败，请检查提示信息后再次注册！");
		   		 }
		   	 }else{
		   		 if(achievement.equals("【请选择】")){
		   			label_8.setText("请选择正确职位！！");
					label_8.setForeground(Color.red);
		   			 }
		   		JOptionPane.showMessageDialog(jf, "请正确选择系统操作类型！注册失败！");
		   	 }
	 	 
			}
			});
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*切换 登录方面的 窗体类
				 * 自身窗体可视化关闭*/
				String[] args={""};
				 Login.main(args);
				/*切换窗体类 当前的窗体线程一定要关闭*/
				jf.dispose();
				//jf.setVisible(false);
			}
			});
		jf.setVisible(true);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*此为外部jar包  渲染GUI界面 添加皮肤特效  调用过程*/
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
       new Reg();
	}
}
