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
		jf=new JFrame("��������ϵͳ��Աע�����");
		
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setBounds(620, 160, 800, 755);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u4F1A\u5458\u6CE8\u518C\u754C\u9762");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel.setBounds(263, 22, 224, 47);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("����", Font.BOLD, 24));
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
		label_1.setFont(new Font("����", Font.BOLD, 24));
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
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(559, 103, 215, 21);
		jf.getContentPane().add(lblNewLabel_1);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("����", Font.PLAIN, 15));
		label_2.setBounds(559, 184, 215, 21);
		jf.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u6027  \u522B\uFF1A");
		label_3.setFont(new Font("����", Font.BOLD, 24));
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
		label_4.setFont(new Font("����", Font.BOLD, 24));
		label_4.setBounds(101, 319, 145, 47);
		jf.getContentPane().add(label_4);
		
		  comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u3010\u8BF7\u9009\u62E9\u3011", "\u987E\u5BA2\u4F1A\u5458"}));
		comboBox.setBounds(263, 330, 238, 32);
		jf.getContentPane().add(comboBox);
		
		JLabel label_5 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_5.setFont(new Font("����", Font.BOLD, 24));
		label_5.setBounds(101, 405, 145, 47);
		jf.getContentPane().add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("\u8BF7\u8F93\u5165\u60A8\u7684\u624B\u673A\u53F7\u7801");
		textField_2.setBounds(257, 414, 271, 38);
		jf.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_6 = new JLabel("\u64CD\u4F5C\u7C7B\u578B\uFF1A");
		label_6.setFont(new Font("����", Font.BOLD, 24));
		label_6.setBounds(101, 487, 145, 47);
		jf.getContentPane().add(label_6);
		
		  comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u3010\u8BF7\u9009\u62E9\u3011", "\u6D88\u8D39\u8005"}));
		comboBox_1.setBounds(263, 498, 238, 32);
		jf.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBackground(new Color(64, 224, 208));
		btnNewButton.setFont(new Font("����", Font.BOLD, 16));
		btnNewButton.setBounds(124, 613, 133, 54);
		jf.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u5DF2\u6709\u8D26\u6237\uFF0C\u8DF3\u8F6C\u767B\u5F55");
		button.setBackground(new Color(127, 255, 0));
		button.setFont(new Font("����", Font.BOLD, 16));
		button.setBounds(351, 613, 221, 54);
		jf.getContentPane().add(button);
		
		label_7 = new JLabel("");
		label_7.setFont(new Font("����", Font.PLAIN, 15));
		label_7.setBounds(559, 339, 215, 21);
		jf.getContentPane().add(label_7);
		
		label_8 = new JLabel("");
		label_8.setFont(new Font("����", Font.PLAIN, 15));
		label_8.setBounds(559, 507, 215, 21);
		jf.getContentPane().add(label_8);
		textField.addFocusListener(new FocusListener() {
			/*���ڸ�GUI�ı���ؼ�  ��ӹ��������Ƴ��¼� ������*/
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				String ename=textField.getText();
				/*�������Ƴ��ı���δ�����κ�ֵ
				 * ����ı���λΪĬ��������ʾ*/
				if(ename.trim().equals("")){
					textField.setText("�������û���");
					textField.setForeground(Color.lightGray);
					lblNewLabel_1.setText("�û�������Ϊ�գ�");
					lblNewLabel_1.setForeground(Color.red);
				}else{
					if(ename.trim().length()>=2&&ename.trim().length()<=6){
						lblNewLabel_1.setText("�����û������ã�");
						lblNewLabel_1.setForeground(Color.green);
					}else{
						lblNewLabel_1.setText("�û������ȴ���(3-6λ����)");
						lblNewLabel_1.setForeground(Color.red);
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				String ename=textField.getText();
			 /*��������ı���  ����ʾ��Ϣ����������ı���
			  * �������� ��ɫ����*/
				if(ename.trim().equals("�������û���")){
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
					textField_1.setText("����������");
					textField_1.setForeground(Color.lightGray);
					label_2.setText("���벻��Ϊ�գ�");
					label_2.setForeground(Color.red);
				}else{
					if(password.trim().length()>=5&&password.trim().length()<=12){
						label_2.setText("����������ã�");
						label_2.setForeground(Color.green);
					}else{
						label_2.setText("���볤�ȴ���(5-12λ����)");
						label_2.setForeground(Color.red);
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				String password=textField_1.getText();
				if(password.trim().equals("����������")){
					textField_1.setText("");
					textField_1.setForeground(Color.black);
				}
			}
		});
		comboBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getSelectedItem().toString().equals("����ѡ��")){
					label_7.setText("��ѡ����ȷְλ����");
					label_7.setForeground(Color.red);
				}else{
					label_7.setText("ѡ����ȷ����");
					label_7.setForeground(Color.green);
				}
			}
			
		});
		comboBox_1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_1.getSelectedItem().toString().equals("����ѡ��")){
					label_8.setText("��ѡ����ȷְλ����");
					label_8.setForeground(Color.red);
				}else{
					label_8.setText("ѡ����ȷ����");
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
		   	 if(achievement.equals("������")){
		   		 if(epost.equals("�˿ͻ�Ա")
		   				 &&lblNewLabel_1.getText().equals("�����û������ã�")
		   				&&label_2.getText().equals("����������ã�")
		   				 ){
                  /*׼�������ݿ�insert  ����ע���˻�
                   * JDBC ���ݺ����������  ����SQLָ��ִ��  ����������*/
		   			/* ʹ��map��������  �д���ֵ��  �洢����������� ����*/
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
		   			 JOptionPane.showMessageDialog(jf, "��Աע��ɹ���");
		   			 /*ע��ɹ��� ���л���¼����*/
		   			String[] args={""};
					 Login.main(args);
					jf.dispose();
		   			}else{
		   				JOptionPane.showMessageDialog(jf,  "��Աע��ʧ�ܣ��������绷�����������б������", "ע��ʧ�ܴ���",JOptionPane.ERROR_MESSAGE);
		   				//JOptionPane.showMessageDialog(Reg.this, "��Աע��ʧ�ܣ��������绷�����������б������",JOptionPane.ERROR_MESSAGE);
		   			}
		   			 
		   		 }else{
		   			 if(epost.equals("����ѡ��")){
		   				label_7.setText("��ѡ����ȷְλ����");
						label_7.setForeground(Color.red);
		   			 }
		   			JOptionPane.showMessageDialog(jf, "��Աע��ʧ�ܣ�������ʾ��Ϣ���ٴ�ע�ᣡ");
		   		 }
		   	 }else{
		   		 if(achievement.equals("����ѡ��")){
		   			label_8.setText("��ѡ����ȷְλ����");
					label_8.setForeground(Color.red);
		   			 }
		   		JOptionPane.showMessageDialog(jf, "����ȷѡ��ϵͳ�������ͣ�ע��ʧ�ܣ�");
		   	 }
	 	 
			}
			});
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*�л� ��¼����� ������
				 * ��������ӻ��ر�*/
				String[] args={""};
				 Login.main(args);
				/*�л������� ��ǰ�Ĵ����߳�һ��Ҫ�ر�*/
				jf.dispose();
				//jf.setVisible(false);
			}
			});
		jf.setVisible(true);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*��Ϊ�ⲿjar��  ��ȾGUI���� ���Ƥ����Ч  ���ù���*/
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
       new Reg();
	}
}
