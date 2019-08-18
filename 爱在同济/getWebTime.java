package servlets;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Locale;


public class getWebTime {


 
	       // String webUrl2 = "http://www.baidu.com";//�ٶ�


	    /**
	     * ��ȡָ����վ������ʱ��
	     * 
	     * @param webUrl
	     * @return
	     */
	    public static java.sql.Date getWebsiteDate(String webUrl){
	        try {
	            URL url = new URL(webUrl);// ȡ����Դ����
	            URLConnection uc = url.openConnection();// �������Ӷ���
	            uc.connect();// ��������
	            long ld = uc.getDate();// ��ȡ��վ����ʱ��
	            Date date = new Date(ld);// ת��Ϊ��׼ʱ�����
	            java.sql.Date date1=new java.sql.Date(date.getTime());//�� �� ��
	            return date1;
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    public static Time getWebsiteTime(String webUrl){
	        try {
	            URL url = new URL(webUrl);// ȡ����Դ����
	            URLConnection uc = url.openConnection();// �������Ӷ���
	            uc.connect();// ��������
	            long ld = uc.getDate();// ��ȡ��վ����ʱ��
	            Date date = new Date(ld);// ת��Ϊ��׼ʱ�����
	        
                java.sql.Time date2=new java.sql.Time(date.getTime());//ʱ   ��    �� 
	            return date2;
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

 }