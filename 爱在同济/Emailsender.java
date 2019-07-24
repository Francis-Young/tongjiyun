package servlets;

import java.io.File;
import java.util.Date;

import java.util.Properties;  
  
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;  
import javax.mail.BodyPart;  
import javax.mail.Message;  
import javax.mail.Multipart;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;  
import javax.mail.internet.MimeMessage;  
import javax.mail.internet.MimeMultipart;  
import javax.mail.internet.MimeUtility;  

public class Emailsender
{
	String recevierAddress;
	String text;
	Emailsender(String recevierAddress,String text)
	{
		this.recevierAddress=recevierAddress;
		this.text= text;
	}
	public void send() throws Exception {

        Properties props = new Properties(); //可以加载一个配置文件
        // 使用smtp：简单邮件传输协议
        props.put("mail.smtp.host", "smtp.qq.com");//存储发送邮件服务器的信息
        props.put("mail.smtp.auth", "true");//同时通过验证
        Session session = Session.getInstance(props);//根据属性新建一个邮件会话
//        session.setDebug(true); //有他会打印一些调试信息。

        MimeMessage message = new MimeMessage(session);//由邮件会话新建一个消息对象
        message.setFrom(new InternetAddress("1209267765@qq.com"));//设置发件人的地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1751716@tongji.edu.cn"));//设置收件人,并设置其接收类型为TO
        message.setSubject("同学，你有一封信待查收！");//设置标题
        //设置信件内容
//        message.setText(mailContent); //发送 纯文本 邮件 todo
        //message.setContent("232323232323", "text/html;charset=gbk"); //发送HTML邮件，内容样式比较丰富
        message.setSentDate(new Date());//设置发信时间

        // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        Multipart multipart = new MimeMultipart();
     
        props.setProperty("mail.transport.protocol", "smtp");//重要声明
   
        // 设置邮件的文本内容
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setText(text+"\n快上同济云找找这个发件人吧！");
        multipart.addBodyPart(contentPart);
/*       // 添加附件
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource dataSource = new FileDataSource(new File("‪E:\\IMG_20180325_191851.jpg"));
        // 添加附件的内容
        messageBodyPart.setDataHandler(new DataHandler(dataSource));
        // 添加附件的标题
        // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
        messageBodyPart.setFileName(MimeUtility.encodeText(dataSource.getName()));
        multipart.addBodyPart(messageBodyPart);
*/        // 将multipart对象放到message中
        message.setContent(multipart);
        message.saveChanges();//存储邮件信息
 
        //发送邮件
        Transport transport = session.getTransport();
    
        transport.connect("1209267765@qq.com", "hiytlajgulruhhjc");//发送邮件的账号， 授权码

        transport.sendMessage(message, message.getAllRecipients());//发送邮件,其中第二个参数是所有已设好的收件人地址
       
        transport.close();
    }
}
