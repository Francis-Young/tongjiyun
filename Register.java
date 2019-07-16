package bigHomework;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

//��¼����

public class Register {

	    JFrame reg=new JFrame("��¼����");
        JLabel userId=new JLabel("�û�����");
        JLabel password=new JLabel("���룺");
        JButton log=new JButton("��¼");
        JButton register=new JButton("ע��");
        JButton exit=new JButton("�˳�");
        JTextField idTextfield=new JTextField(20);
        JPasswordField pwField=new JPasswordField(20);
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        Box b=Box.createVerticalBox();
        
        //��ȡ��Ļ�ߴ�
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    	int inset=300;
        
    	//����
    	Font font1=new Font("΢���ź�",Font.BOLD,20);
    	Font font2=new Font("΢���ź�",Font.PLAIN,16);
    	Font font3=new Font("����",Font.BOLD,18);
    	
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
            
         
            //����ͼƬ����
            //ʹ�����·��ʱ��ͼƬλ����Ŀ��һ��Ŀ¼��
            ImageIcon icon =new ImageIcon("DNA1.jpg");
            JLabel label=new JLabel(icon);
            //�������������
            label.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
            reg.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            JPanel j=(JPanel)reg.getContentPane();
            
            //����͸��
            j.setOpaque(false);
           
            p1.setOpaque(false);
            p2.setOpaque(false);
            p3.setOpaque(false);
            b.setOpaque(false);
            
            
            //���ƴ��ڴ��³�������Ļ����
            reg.setBounds(inset+350, inset+50, icon.getIconWidth(), icon.getIconHeight());
            reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		reg.setVisible(true);
    		
    		
    		//��¼����Ӧ�¼�
    		log.addActionListener( log-> {
    			//�жϵ�¼�Ƿ���Ч
    			boolean a=validate(idTextfield.getText(),String.valueOf(pwField.getPassword()));
    			if(a==true)
    			{
    				JOptionPane.showMessageDialog(reg, "��¼�ɹ���","�ɹ���ʾ", JOptionPane.INFORMATION_MESSAGE);
    				
    				//���������棬�ͷ�ע�����
    				MainInterface m=new MainInterface();
    				reg.dispose();
    				m.init();

    			}
    			else JOptionPane.showMessageDialog(reg, "�û������ڻ��������","������ʾ",JOptionPane.ERROR_MESSAGE);
    			
    		});
    		
    		//�˳�����Ӧ�¼�
    		exit.addActionListener(exit->{
    			System.exit(0);
    		});
    		
    		//ע�����Ӧ�¼�
    		register.addActionListener(register->{
    			//����û��������������ݿ���
    			userAppend(idTextfield.getText(),String.valueOf(pwField.getPassword()));
    			
    		});
    		
        }
        
        //�ж��Ƿ�Ϊ��Ч�û����Ƿ���Ե�¼
        private boolean validate(String userName, String userPass)
        {
        	
        	// ����Դ������try()��,��������,��Դ�����ر�
			try (
				Connection conn=DataBase.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from �û��� where �û���=? and �û�����=?"))
			{
				pstmt.setString(1, userName);
				pstmt.setString(2,userPass);
				
				try(
						ResultSet rs=pstmt.executeQuery())
				{
					//�����ѯ��ResultSet�����ҽ���1����¼���¼�ɹ�
					//�����ע��ʱҲ�Ѿ����м�飬���������������ȫһ�����û���
					if(rs.next()==true && rs.next()==false)
					{
						//���û�������User�࣬Ϊ����ʹ����׼��
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
        
        //ע������û�
        private void userAppend(String userName, String userPass)
        {
        	try(
        		Connection conn=DataBase.getConnection();
        		PreparedStatement pstmt=conn.prepareStatement("insert into �û��� values(?,?,0,null)");
        		PreparedStatement pstmt1=conn.prepareStatement("select �û��� from �û��� ")	
        			)
        	{
        		
        		try(ResultSet rs=pstmt1.executeQuery()){
        			boolean tag=false;//ָʾ�û����Ƿ��Ѵ���
        			while(rs.next())
        			{
        				//==�Ƚϻ�Ƚϵ�ַ��equals�����Ƚ�����
        				if(rs.getString("�û���").equals(userName)) {
        					
        					tag=true;break;
        				}
        			}
        			
        		//�û���������
        		if(tag==false) {	
        		pstmt.setString(1, userName);
				pstmt.setString(2,userPass);
				
				int a=pstmt.executeUpdate();//������Ӱ��ļ�¼����
				
				   if(a==1)
				   {
					JOptionPane.showMessageDialog(reg, "ע��ɹ���","�ɹ���ʾ", JOptionPane.INFORMATION_MESSAGE);
				   }
				   else JOptionPane.showMessageDialog(reg, "ע��ʧ�ܣ�","������ʾ",JOptionPane.ERROR_MESSAGE);
				
        	    }
        		//�û�������
        		else JOptionPane.showMessageDialog(reg, "�û����Ѵ��ڣ�","��ʾ",JOptionPane.ERROR_MESSAGE);
        		}
        } catch (SQLException e1) {
			
			e1.printStackTrace();
		}
}
}
