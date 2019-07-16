package bigHomework;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

//登录界面

public class Register {

	    JFrame reg=new JFrame("登录窗口");
        JLabel userId=new JLabel("用户名：");
        JLabel password=new JLabel("密码：");
        JButton log=new JButton("登录");
        JButton register=new JButton("注册");
        JButton exit=new JButton("退出");
        JTextField idTextfield=new JTextField(20);
        JPasswordField pwField=new JPasswordField(20);
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        Box b=Box.createVerticalBox();
        
        //获取屏幕尺寸
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    	int inset=300;
        
    	//字体
    	Font font1=new Font("微软雅黑",Font.BOLD,20);
    	Font font2=new Font("微软雅黑",Font.PLAIN,16);
    	Font font3=new Font("仿宋",Font.BOLD,18);
    	
        public void init()
        {
        	p1.add(userId);
        	p1.add(idTextfield);
        	p2.add(password);
        	p2.add(pwField);
        	p3.add(log);
        	p3.add(register);
        	p3.add(exit);
        	b.add(p1);
        	
        	b.add(p2);
            b.add(p3);
            reg.add(b);
            
         
            //背景图片设置
            //使用相对路径时，图片位于项目的一级目录下
            ImageIcon icon =new ImageIcon("DNA1.jpg");
            JLabel label=new JLabel(icon);
            //坐标是相对坐标
            label.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
            reg.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            JPanel j=(JPanel)reg.getContentPane();
            
            //设置透明
            j.setOpaque(false);
           
            p1.setOpaque(false);
            p2.setOpaque(false);
            p3.setOpaque(false);
            b.setOpaque(false);
            
            
            //控制窗口大致出现在屏幕中央
            reg.setBounds(inset+350, inset+50, icon.getIconWidth(), icon.getIconHeight());
            reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		reg.setVisible(true);
    		
    		
    		//登录键响应事件
    		log.addActionListener( log-> {
    			//判断登录是否有效
    			boolean a=validate(idTextfield.getText(),String.valueOf(pwField.getPassword()));
    			if(a==true)
    			{
    				JOptionPane.showMessageDialog(reg, "登录成功！","成功提示", JOptionPane.INFORMATION_MESSAGE);
    				
    				//调出主界面，释放注册界面
    				MainInterface m=new MainInterface();
    				reg.dispose();
    				m.init();

    			}
    			else JOptionPane.showMessageDialog(reg, "用户不存在或密码错误！","错误提示",JOptionPane.ERROR_MESSAGE);
    			
    		});
    		
    		//退出键响应事件
    		exit.addActionListener(exit->{
    			System.exit(0);
    		});
    		
    		//注册键响应事件
    		register.addActionListener(register->{
    			//添加用户名和密码至数据库中
    			userAppend(idTextfield.getText(),String.valueOf(pwField.getPassword()));
    			
    		});
    		
        }
        
        //判断是否为有效用户，是否可以登录
        private boolean validate(String userName, String userPass)
        {
        	
        	// 将资源声明在try()中,当语句结束,资源将被关闭
			try (
				Connection conn=DataBase.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from 用户表 where 用户名=? and 用户密码=?"))
			{
				pstmt.setString(1, userName);
				pstmt.setString(2,userPass);
				
				try(
						ResultSet rs=pstmt.executeQuery())
				{
					//如果查询的ResultSet中有且仅有1条记录则登录成功
					//这点在注册时也已经进行检查，不允许出现两个完全一样的用户名
					if(rs.next()==true && rs.next()==false)
					{
						//将用户名传入User类，为后续使用做准备
		                User.setName(userName);
		                User.setPassword(userPass);
						return true;
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return false;
        }
        
        //注册添加用户
        private void userAppend(String userName, String userPass)
        {
        	try(
        		Connection conn=DataBase.getConnection();
        		PreparedStatement pstmt=conn.prepareStatement("insert into 用户表 values(?,?,0,null)");
        		PreparedStatement pstmt1=conn.prepareStatement("select 用户名 from 用户表 ")	
        			)
        	{
        		
        		try(ResultSet rs=pstmt1.executeQuery()){
        			boolean tag=false;//指示用户名是否已存在
        			while(rs.next())
        			{
        				//==比较会比较地址，equals方法比较内容
        				if(rs.getString("用户名").equals(userName)) {
        					
        					tag=true;break;
        				}
        			}
        			
        		//用户名不存在
        		if(tag==false) {	
        		pstmt.setString(1, userName);
				pstmt.setString(2,userPass);
				
				int a=pstmt.executeUpdate();//返回受影响的记录条数
				
				   if(a==1)
				   {
					JOptionPane.showMessageDialog(reg, "注册成功！","成功提示", JOptionPane.INFORMATION_MESSAGE);
				   }
				   else JOptionPane.showMessageDialog(reg, "注册失败！","错误提示",JOptionPane.ERROR_MESSAGE);
				
        	    }
        		//用户名存在
        		else JOptionPane.showMessageDialog(reg, "用户名已存在！","提示",JOptionPane.ERROR_MESSAGE);
        		}
        } catch (SQLException e1) {
			
			e1.printStackTrace();
		}
}
}
