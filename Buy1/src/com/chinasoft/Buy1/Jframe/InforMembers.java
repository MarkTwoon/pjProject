package com.chinasoft.Buy1.Jframe;

 
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InforMembers {
private JFrame jf;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JLabel lblNewLabel_5;
private JLabel label ;
private JLabel label_1;
 private JLabel label_2;  
 private JLabel lblNewLabel_6;
 private  JLabel lblNewLabel_8;
 private JLabel label_3;
 private JLabel label_4;
private JLabel label_5;
 private JLabel label_6;
  InforMembers(String mname) {
	// TODO Auto-generated constructor stub
	  Date date = new Date();
      SimpleDateFormat df = new SimpleDateFormat("HH");
      String str = df.format(date);
      int a = Integer.parseInt(str);
      if (a >= 0 && a <= 6) {
         /* System.out.println("凌晨");*/
    	  str="早上好，新的一天又开始了！";
      }else
      if (a > 6 && a <= 12) {
    	  str="上午好，新的一天又开始了！";
      }else
      if (a > 12 && a <= 13) {
    	  str="中午好！";
      }else
      if (a > 13 && a <= 18) {
    	  str="下午好！";
      }else
      if (a > 18 && a <= 24) {
    	  str="晚上好！";
      }
 
		jf=new JFrame("超市会员系统顾客抽奖界面-尊敬的"+mname+"VIP顾客，"+str);
		jf.setBounds(50, 50, 992, 608);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InforMembers.class.getResource("/image/buys2.jpg")));
		lblNewLabel.setBounds(462, 20, 498, 540);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5C0A\u656C\u7684\u5546\u5E97\u4F1A\u5458\uFF1A");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 20, 208, 45);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(mname);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_2.setBounds(237, 20, 104, 45);
		jf.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u60A8\u597D\uFF01\uFF01");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(351, 20, 121, 45);
		jf.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6B22\u8FCE\u6765\u5230\u672C\u5546\u5E97\u62BD\u5956\u7CFB\u7EDF");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_4.setBounds(108, 65, 303, 45);
		jf.getContentPane().add(lblNewLabel_4);
		
		  lblNewLabel_5 = new JLabel("??");
		lblNewLabel_5.setBounds(118, 120, 121, 15);
		jf.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField(1);
		textField.setBounds(108, 145, 50, 36);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				numMark(textField.getText(),lblNewLabel_5);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		  label = new JLabel("??");
		label.setBounds(332, 120, 104, 15);
		jf.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(318, 145, 50, 36);
		jf.getContentPane().add(textField_1);
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				numMark(textField_1.getText(), label);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		  label_1 = new JLabel("??");
		label_1.setBounds(118, 191, 124, 15);
		jf.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 216, 50, 36);
		jf.getContentPane().add(textField_2);
		textField_2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				numMark(textField_2.getText(), label_1);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		  label_2 = new JLabel("??");
		label_2.setBounds(328, 191, 107, 15);
		jf.getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(318, 214, 50, 36);
		textField_3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				numMark(textField_3.getText(), label_2);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jf.getContentPane().add(textField_3);
		
		lblNewLabel_6 = new JLabel("\u8BF7\u4F9D\u6B21\u8F93\u51654\u4E2A1\u4F4D\u6570\u7EC4\u6210\u60A8\u76844\u4F4D\u5E78\u8FD0\u6570\u5B57");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_6.setBounds(54, 260, 335, 36);
		jf.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB\u62BD\u5956");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*如果不能拼接成正确的纯数字 则出消息框提示*/
				 if(!lblNewLabel_5.getText().equals("数字格式输入正确") ||
						 !label.getText().equals("数字格式输入正确")||
						 !label_1.getText().equals("数字格式输入正确")||
						 !label_2.getText().equals("数字格式输入正确")){
					 JOptionPane.showMessageDialog(jf, "抱歉，输入数字有误，无法抽奖！");
				}else{
					String a=textField.getText().trim();
					String b=textField_1.getText().trim();
					String c=textField_2.getText().trim();
					String d=textField_3.getText().trim();
					/*String abcd=a+b+c+d+"";*/
					int number=Integer.parseInt(a+b+c+d+"");
					int max=9999;
					int min=1000;
					/*接下来 用Math的随机数方法
					 * 生成4个 符合数轴区间的 4个随机数*/
					int number1 = (int) (Math.random() * (max - min)) + min;
				/*	int number1 =6660;*/
					 int number2 = (int) (Math.random() * (max - min)) + min;
					 int number3 = (int) (Math.random() * (max - min)) + min;
					 int number4 = (int) (Math.random() * (max - min)) + min;
					 lblNewLabel_8.setText(number1+"");
					label_3.setText(number2+"");
					label_4.setText(number3+"");
					label_5.setText(number4+"");
					if(number==number1||number==number2||
							number==number3||number==number4){
						JOptionPane.showMessageDialog(jf,"恭喜您中奖，全场购物消费1折！");
						label_6.setText("成功中奖！恭喜您成为今日的幸运商店会员！");
					}else{
						JOptionPane.showMessageDialog(jf,"很遗憾您今日并未中奖 ！！");
						label_6.setText("很遗憾并未中奖，本店还有其他优惠活动！");
						
					}
				} 
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBounds(31, 306, 368, 38);
		jf.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("\u4ECA\u65E5\u76844\u4E2A4\u4F4D\u5E78\u8FD0\u6570\u5B57\u4F9D\u6B21\u4E3A");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_7.setBounds(85, 354, 236, 49);
		jf.getContentPane().add(lblNewLabel_7);
		
		  lblNewLabel_8 = new JLabel("\uFF1F\uFF1F\uFF1F\uFF1F");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(14, 401, 84, 34);
		jf.getContentPane().add(lblNewLabel_8);
		
		  label_3 = new JLabel("\uFF1F\uFF1F\uFF1F\uFF1F");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("宋体", Font.BOLD, 17));
		label_3.setBounds(116, 401, 84, 34);
		jf.getContentPane().add(label_3);
		
		  label_4 = new JLabel("\uFF1F\uFF1F\uFF1F\uFF1F");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("宋体", Font.BOLD, 17));
		label_4.setBounds(237, 401, 84, 34);
		jf.getContentPane().add(label_4);
		
		  label_5 = new JLabel("\uFF1F\uFF1F\uFF1F\uFF1F");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("宋体", Font.BOLD, 17));
		label_5.setBounds(351, 401, 84, 34);
		jf.getContentPane().add(label_5);
		
		  label_6 = new JLabel("\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F\uFF1F");
		label_6.setFont(new Font("Dialog", Font.BOLD, 20));
		label_6.setBounds(25, 431, 427, 61);
		jf.getContentPane().add(label_6);
		
		JButton button = new JButton("\u5173\u95ED\u62BD\u5956\u7CFB\u7EDF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*当前窗体关闭  结束*/
				jf.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 20));
		button.setBounds(178, 509, 190, 33);
		jf.getContentPane().add(button);
		jf.setResizable(false);
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
		if(args.length==0){
			args=new String[2];
			args[0]="暂无";
		}
		 
	  new InforMembers(args[0]);
	}
	
	public void  numMark(String num,JLabel label_x){
		try {
			int x=Integer.parseInt(num.trim());
			if(x>-1&&x<10){
				label_x.setText("数字格式输入正确");
				label_x.setForeground(Color.green);
			}else{
				label_x.setText("数字格式输入错误");
				label_x.setForeground(Color.red);
			}
		} catch (Exception e) {
			// TODO: handle exception
			label_x.setText("数字格式输入错误");
			label_x.setForeground(Color.red);
		}
	}
}
