package com.chinasoft.Buy1.Jframe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.chinasoft.Buy1.Dao.UserDao;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

public class InforManager extends JFrame {
private JFrame  jf;
private JTextField textField;
private JTable table;
private    UserDao dao=new UserDao();
private JComboBox comboBox;
/*��table����ϵ�  ���б�ṹ ���ݴ洢ģʽ*/
private DefaultTableModel model=new DefaultTableModel();
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
private JTextField textField_7;
private JLabel label;
private JTextField textField_8;
private DefaultTableModel model_1=new DefaultTableModel();
private JComboBox comboBox_1;
private JTextField textField_9;
private JTextField textField_10;
private JTextField textField_11;
private JTextField textField_12;
private JTextField textField_13;
private JTextField textField_14;
private  JLabel lblNewLabel_4;
private  JTable table_1;
private  static String mname1;
	public InforManager(String mname) {
		this.mname1=mname;
		// TODO Auto-generated constructor stub
		jf=new JFrame("���л�Աϵͳ����Ա����-��ǰ����Ա:"+mname);
		jf.setBounds(150, 15, 1021, 1000);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		jf.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(116, 10, 773, 89);
		jf.getContentPane().add(panel);
		panel.setLayout(null);
		
		  comboBox = new JComboBox();
		comboBox.setFont(new Font("����", Font.BOLD, 21));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7F16\u53F7", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6027\u522B", "\u516C\u53F8\u804C\u52A1", "\u624B\u673A\u53F7", "\u7CFB\u7EDF\u64CD\u4F5C\u7C7B\u578B", "\u5DE5\u4F5C\u4E1A\u7EE9"}));
		comboBox.setBounds(10, 33, 200, 30);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(240, 33, 225, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tj=comboBox.getSelectedItem().toString().trim();
				if(tj.equals("���")){
					tj="eid";
				}else if(tj.equals("�û���")){
					tj="ename";
				}else if(tj.equals("����")){
					tj="epassword";
				}else if(tj.equals("�Ա�")){
					tj="esex";
				}else if(tj.equals("��˾ְ��")){
					 tj="epost";
				 }else if(tj.equals("�ֻ���")){
					 tj="ephone";
				 }else if(tj.equals("ϵͳ��������")){
					 tj="achievement";
				 }else if(tj.equals("����ҵ��")){
					 tj="ework";
				 }
				String value=textField.getText().trim();
				getEmployee(tj, value);
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 23));
		btnNewButton.setBounds(500, 30, 109, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u60A8");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(678, 8, 70, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(mname);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(678, 40, 70, 22);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5458\u5DE5\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(44, 109, 922, 188);
		jf.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/*����һά���� ����ͷ�� ��ά���� ������������
		 * һ��洢�����ݱ�ģʽ�� ����table���� ʵ����*/
	/*String title[]={"����","����"};
	String data[][]=new String[0][2];
	model.setDataVector(data, title);*/
		/*JDBC��ѯ  ��װ��tablemodel���ݹ���
		 * Ҫ��װ��һ�������ķ��������*/
		getEmployee("","");
		table=new JTable(model);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("������ ѡ�е��к�"+table.getSelectedRow());
				int num=table.getSelectedRow();
				label.setText(model.getValueAt(num, 0)+"");
				textField_1.setText(model.getValueAt(num, 1)+"");  
				textField_3.setText(model.getValueAt(num, 2)+"");  
				textField_5.setText(model.getValueAt(num, 3)+"");  
				textField_2.setText(model.getValueAt(num, 4)+"");  
				textField_4.setText(model.getValueAt(num, 5)+"");  
				textField_6.setText(model.getValueAt(num, 6)+"");  
				textField_7.setText(model.getValueAt(num, 7)+""); 
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 20, 902, 158);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u5458\u5DE5\u6570\u636E\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_2.setBounds(44, 307, 922, 173);
		jf.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setBounds(113, 10, 45, 23);
		panel_2.add(lblNewLabel_2);
		
		  label = new JLabel("");
		  label.setBounds(165, 10, 96, 23);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setBounds(85, 37, 68, 23);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 37, 107, 24);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u516C\u53F8\u804C\u52A1\uFF1A");
		label_2.setBounds(71, 82, 80, 23);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 83, 107, 23);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801\uFF1A");
		label_3.setBounds(292, 37, 54, 23);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label_4.setBounds(292, 82, 54, 23);
		panel_2.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(356, 37, 117, 23);
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(356, 81, 117, 23);
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JLabel label_5 = new JLabel("\u6027\u522B\uFF1A");
		label_5.setBounds(542, 37, 45, 23);
		panel_2.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(597, 37, 84, 23);
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JLabel label_6 = new JLabel("\u7CFB\u7EDF\u64CD\u4F5C\u7C7B\u578B\uFF1A");
		label_6.setBounds(503, 82, 84, 23);
		panel_2.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(597, 83, 84, 23);
		textField_6.setColumns(10);
		panel_2.add(textField_6);
		
		JLabel label_7 = new JLabel("\u5DE5\u4F5C\u4E1A\u7EE9\uFF1A");
		label_7.setBounds(715, 37, 68, 23);
		panel_2.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(783, 36, 107, 23);
		textField_7.setColumns(10);
		panel_2.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("\u79BB\u804C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ɾ������*/
				int a=dao.deleteEmployeeOne(label.getText());
				if(a>0){
					JOptionPane.showMessageDialog(jf, "Ա����ְ�ɹ���");
				}else{
					JOptionPane.showMessageDialog(jf, "Ա����ְʧ�ܣ�","��������",JOptionPane.ERROR_MESSAGE);
				}
				/*�����JDBCɾ�����ݺ�  
				 * �����Ҫ�ٴε��ò�ѯָ��  ����ˢ�� ����װ������
				 * DML���ݲ�������
				 * ������ȫ�ֲ�ѯ�е� �����޶��������*/
				textField.setText("");
				
				getEmployee("", "");
			}
		});
		btnNewButton_1.setBounds(85, 121, 105, 35);
		panel_2.add(btnNewButton_1);
		
		JButton button = new JButton("\u5165\u804C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*��������ָ�����*/
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("ename",textField_1.getText());
				map.put("epassword",textField_3.getText());
				map.put("esex",textField_5.getText());
				map.put("epost",textField_2.getText());
				map.put("ephone",textField_4.getText());
				map.put("achievement",textField_6.getText());
				map.put("ework",0);
				int a=dao.insertEmployeeOne(map);
				if(a>0){
					JOptionPane.showMessageDialog(jf, "Ա����ְ�ɹ���");
				}else{
					JOptionPane.showMessageDialog(jf, "Ա����ְʧ�ܣ�","��������",JOptionPane.ERROR_MESSAGE);
				}
				
					textField.setText("");
				getEmployee("", "");
			}
		});
		button.setBounds(262, 121, 105, 35);
		panel_2.add(button);
		
		JButton button_1 = new JButton("\u5546\u5E97\u4EBA\u5458\u4FE1\u606F\u53D8\u52A8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ע�� �޸İ�ť  ��Ҫ��ʵID��Ϊ�޸�����Ψһ��ʶ*/
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("eid", label.getText());
				map.put("ename",textField_1.getText());
				map.put("epassword",textField_3.getText());
				map.put("esex",textField_5.getText());
				map.put("epost",textField_2.getText());
				map.put("ephone",textField_4.getText());
				map.put("achievement",textField_6.getText());
				map.put("ework",textField_7.getText().equals("")?0:textField_7.getText());
			 if(dao.updateEmployeeById(map)>0){
				 JOptionPane.showMessageDialog(jf, "Ա����Ϣ�޸ĳɹ���");
			 }else{
					JOptionPane
					.showMessageDialog(jf, "Ա����Ϣ�޸�ʧ�ܣ�","��������",JOptionPane.ERROR_MESSAGE);
			 }
				textField.setText("");
				/*��DML���ݸ��²�����  װ�� ˢ��table����ֵ  ��Ҫ��
				 * where��������*/
				getEmployee("", "");
			}
		});
		button_1.setBounds(426, 121, 193, 35);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u5546\u54C1\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBounds(116, 484, 773, 67);
		jf.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		  comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("����", Font.BOLD, 22));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u7F16\u53F7", "\u79CD\u7C7B", "\u5546\u54C1\u540D", "\u5355\u4EF7", "\u6570\u91CF", "\u603B\u4EF7", "\u552E\u51FA\u65F6\u95F4"}));
		comboBox_1.setBounds(38, 22, 159, 33);
		panel_3.add(comboBox_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(255, 22, 235, 31);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String tj=comboBox_1.getSelectedItem().toString().trim();
			 Map<String,String> map=new HashMap<String,String>();
			 map.put("���","seid");
			 map.put("����","sekind");
			 map.put("��Ʒ��","sename");
			 map.put("����","seprice");
			 map.put("����","secount");
			 map.put("�ܼ�","secountprice");
			 map.put("�۳�ʱ��","setime");
			 tj=map.get(tj);
			 
				String value=textField_8.getText().trim();
			 
				getSelgoods(tj,value);
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.BOLD, 23));
		btnNewButton_2.setBounds(571, 22, 130, 31);
		panel_3.add(btnNewButton_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\u552E\u51FA\u5546\u54C1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_4.setBounds(44, 561, 922, 172);
		jf.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		
		/*��JTable��GUI����ռλ��ʾ֮ǰ ��Ҫװ����ʾ��������*/
		getSelgoods("","");
		  table_1=new JTable(model_1);
		  table_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				/*��ȡ  ���������*/
				int  num=table_1.getSelectedRow();
				lblNewLabel_4.setText(model_1.getValueAt(num, 0)+"");
				textField_9.setText(model_1.getValueAt(num, 1)+"");
				textField_10.setText(model_1.getValueAt(num, 2)+"");
				textField_11.setText(model_1.getValueAt(num, 3)+"");
				textField_12.setText(model_1.getValueAt(num, 4)+"");
				textField_13.setText(model_1.getValueAt(num, 5)+"");
				textField_14.setText(model_1.getValueAt(num, 6)+"");
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 20, 902, 142);
		panel_4.add(scrollPane_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u5546\u54C1\u6570\u636E\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_5.setBounds(44, 743, 922, 159);
		jf.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setBounds(10, 34, 45, 23);
		panel_5.add(lblNewLabel_3);
		
		  lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(65, 36, 67, 19);
		panel_5.add(lblNewLabel_4);
		
		JLabel label_8 = new JLabel("\u79CD\u7C7B\uFF1A");
		label_8.setBounds(142, 38, 54, 23);
		panel_5.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(190, 37, 80, 23);
		panel_5.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel label_9 = new JLabel("\u5546\u54C1\u540D\uFF1A");
		label_9.setBounds(358, 38, 54, 23);
		panel_5.add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(408, 37, 86, 23);
		panel_5.add(textField_10);
		
		JLabel label_10 = new JLabel("\u5355\u4EF7\uFF1A");
		label_10.setBounds(562, 38, 54, 23);
		panel_5.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(597, 37, 86, 23);
		panel_5.add(textField_11);
		
		JLabel label_11 = new JLabel("\u6570\u91CF\uFF1A");
		label_11.setBounds(142, 81, 45, 23);
		panel_5.add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(190, 79, 86, 23);
		panel_5.add(textField_12);
		
		JLabel label_12 = new JLabel("\u603B\u4EF7\uFF1A");
		label_12.setBounds(358, 82, 54, 23);
		panel_5.add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(408, 81, 86, 23);
		panel_5.add(textField_13);
		
		JLabel label_13 = new JLabel("\u552E\u51FA\u4FE1\u606F\uFF1A");
		label_13.setBounds(518, 80, 75, 23);
		panel_5.add(label_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(597, 79, 230, 21);
		panel_5.add(textField_14);
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		String seid=lblNewLabel_4.getText();
			if(dao.deleteSelgoodsById(seid)>0){
				JOptionPane
				.showMessageDialog(InforManager.this, "������Ʒ��Ϣɾ���ɹ���");
			}else{
				JOptionPane
				.showMessageDialog(InforManager.this, "������Ʒ��Ϣɾ��ʧ�ܣ�","��������",JOptionPane.ERROR_MESSAGE);
			}
			/*��Ҫ������table�ڲ����ݵ�  2�θ�λ*/
			textField_8.setText("");
			getSelgoods("", "");
			}
		});
		btnNewButton_3.setBounds(91, 116, 105, 35);
		panel_5.add(btnNewButton_3);
		
		JButton button_2 = new JButton("\u518D\u6B21\u91C7\u8D2D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String,Object>  map=new HashMap<String,Object>();
				map.put("gkind", textField_9.getText()+"");
				map.put("gname", textField_10.getText()+"");
				map.put("price", textField_11.getText()+"");
				map.put("gcount", textField_12.getText()+"");
				if(dao.insertGoodsOne(map)>0){
					JOptionPane
					.showMessageDialog(InforManager.this, "��Ʒ���ϼ������ɹ���");
				}else{
					JOptionPane
					.showMessageDialog(InforManager.this, "��Ʒ���ϼ�����ʧ�ܣ�","��������",JOptionPane.ERROR_MESSAGE);
				}
				/*��Ҫ������table�ڲ����ݵ�  2�θ�λ*/
				textField_8.setText("");
				getSelgoods("", "");
			}
		});
		button_2.setBounds(233, 115, 105, 35);
		panel_5.add(button_2);
		
		JButton btnNewButton_4 = new JButton("\u4FEE\u6539\u9500\u552E\u5546\u54C1\u4FE1\u606F");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*lblNewLabel_4.setText(model_1.getValueAt(num, 0)+"");
				textField_9.setText(model_1.getValueAt(num, 1)+"");
				textField_10.setText(model_1.getValueAt(num, 2)+"");
				textField_11.setText(model_1.getValueAt(num, 3)+"");
				textField_12.setText(model_1.getValueAt(num, 4)+"");
				textField_13.setText(model_1.getValueAt(num, 5)+"");
				textField_14.setText(model_1.getValueAt(num, 6)+"");*/
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("seid", lblNewLabel_4.getText());
				map.put("sekind", textField_9.getText());
				map.put("sename", textField_10.getText());
				map.put("secount", textField_11.getText());
				map.put("seprice", textField_12.getText());
				map.put("secountprice", textField_13.getText());
				/*map.put("setime", textField_14.getText());*/
				try {
				 new Date( textField_14.getText());
				map.put("setime", textField_14.getText());
				if(dao.updateGoodsById(map)>0){
					JOptionPane
					.showMessageDialog(InforManager.this, "�޸�������Ʒ��Ϣ�ɹ���");
				}else{
					JOptionPane
					.showMessageDialog(InforManager.this, "�޸�������Ʒ��Ϣʧ�ܣ�����¼����Ϣ���ٴ��޸Ĳ���","��������",JOptionPane.ERROR_MESSAGE);
				}
				}catch (Exception e1) {
					// TODO: handle exception
					JOptionPane
					.showMessageDialog(InforManager.this, "�޸�������Ʒʱ���ʽ��Ϣ����","ʱ���ʽ����",JOptionPane.ERROR_MESSAGE);
				}finally{
					/*��Ҫ������table�ڲ����ݵ�  2�θ�λ*/
					textField_8.setText("");
					getSelgoods("", "");
				}
			 
			}
		});
		btnNewButton_4.setBounds(387, 116, 154, 35);
		panel_5.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u8F6C\u5230\u5458\u5DE5\u64CD\u4F5C\u754C\u9762\uFF08\u6682\u65E0\uFF09");
		 
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] args={"����Ա",mname1};
				    InforEmployee.main(args);
				   jf.dispose();
			}
		});
		btnNewButton_5.setBounds(198, 912, 195, 37);
		jf.getContentPane().add(btnNewButton_5);
		
		JButton button_3 = new JButton("\u5173\u95ED\u7CFB\u7EDF");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
		button_3.setBounds(722, 911, 144, 39);
		jf.getContentPane().add(button_3);
	
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
		args[0]="����";
	}
	 
  new InforManager(args[0]);
	}
 private    void getEmployee(String tj,String value){
	 List<Map<String,Object>>  list=dao.selectEmployeeAllOrWhere(tj, value);
	 String title[]={"���","�û���","����","�Ա�","��˾ְ��","�ֻ���","ϵͳ��������","����ҵ��"};
	String title1[]={"eid","ename","epassword","esex","epost","ephone","achievement","ework"};
	 String data[][]=new String[list.size()][title.length];
     /*��ǰ�� ��ѯ�����listת���ɶ�ά����
      * table�ؼ� ����װ�� ��ֵ����*/ 
	 for (int i = 0; i < data.length; i++) {
		for(int x=0;x<title1.length;x++){
			data[i][x]=list.get(i).get(title1[x])+"";
		}
		 /* data[i][0]=list.get(i).get("eid")+"";
		 data[i][1]=list.get(i).get("ename")+"";
		 data[i][2]=list.get(i).get("epassword")+"";
		 data[i][3]=list.get(i).get("esex")+"";
		 data[i][4]=list.get(i).get("epost")+"";
		 data[i][5]=list.get(i).get("ephone")+"";
		 data[i][6]=list.get(i).get("achievement")+"";
		 data[i][7]=list.get(i).get("ework")+"";*/
	}
      model.setDataVector(data, title);
 }
 private  void getSelgoods(String tj,String value){
	 /*��ѯ ������һ�� ���ݽṹ*/
	  List<Map<String,Object>> list=dao.selectSelgoodsAllOrWhere(tj, value);
	/*  System.out.println(list);*/
	  String title[]={"���","����","��Ʒ��","����","����","�ܼ�","�۳�ʱ��"};
	  String title0[]={"seid","sekind","sename","secount","seprice","secountprice","setime"};
	  String data[][]=new String[list.size()][title.length];
	 for(int i=0;i<data.length;i++ ){
		 for(int x=0;x<title0.length;x++){
			 data[i][x]=list.get(i).get(title0[x])+"";
		 }
	 }
	 model_1.setDataVector(data, title);
 }
}
