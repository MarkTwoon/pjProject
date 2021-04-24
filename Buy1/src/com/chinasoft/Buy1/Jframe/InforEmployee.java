package com.chinasoft.Buy1.Jframe;

import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class InforEmployee {
  private JFrame jf;
	
  InforEmployee(String eid,String ename){
		jf=new JFrame("超市会员系统职工界面-当前用户:"+ename+"  编号:"+eid);
		jf.setBounds(100, 100, 800, 800);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
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
			args[0]="00";
			args[1]="暂无";
		}
		new InforEmployee(args[0], args[1]);
	}

}
