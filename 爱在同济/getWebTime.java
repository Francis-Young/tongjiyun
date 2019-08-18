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


 
	       // String webUrl2 = "http://www.baidu.com";//百度


	    /**
	     * 获取指定网站的日期时间
	     * 
	     * @param webUrl
	     * @return
	     */
	    public static java.sql.Date getWebsiteDate(String webUrl){
	        try {
	            URL url = new URL(webUrl);// 取得资源对象
	            URLConnection uc = url.openConnection();// 生成连接对象
	            uc.connect();// 发出连接
	            long ld = uc.getDate();// 读取网站日期时间
	            Date date = new Date(ld);// 转换为标准时间对象
	            java.sql.Date date1=new java.sql.Date(date.getTime());//年 月 日
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
	            URL url = new URL(webUrl);// 取得资源对象
	            URLConnection uc = url.openConnection();// 生成连接对象
	            uc.connect();// 发出连接
	            long ld = uc.getDate();// 读取网站日期时间
	            Date date = new Date(ld);// 转换为标准时间对象
	        
                java.sql.Time date2=new java.sql.Time(date.getTime());//时   分    秒 
	            return date2;
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

 }