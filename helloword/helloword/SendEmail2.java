package helloword;

// ��Ҫ�û��������ʼ�����ʵ��
//�ļ��� SendEmail2.java
//��ʵ����QQ����Ϊ��������Ҫ��qq��̨����
 
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail2
{
   public static void main(String [] args)
   {
      // �ռ��˵�������
      String to = "zhengzheng@wjrcb.com";
 
      // �����˵�������
      String from = "zhengzheng@wjrcb.com";
 
      // ָ�������ʼ�������Ϊ smtp.qq.com
      String host = "mail.wjrcb.com";  //QQ �ʼ�������
 
      // ��ȡϵͳ����
      Properties properties = System.getProperties();
 
      // �����ʼ�������
      properties.setProperty("mail.smtp.host", host);
 
      properties.put("mail.smtp.auth", "true");
      // ��ȡĬ��session����
      Session session = Session.getDefaultInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication()
        {
         return new PasswordAuthentication("zhengzheng@wjrcb.com", "wqzz121113"); //�������ʼ��û���������
        }
       });
 
      try{
         // ����Ĭ�ϵ� MimeMessage ����
         MimeMessage message = new MimeMessage(session);
 
         // Set From: ͷ��ͷ�ֶ�
         message.setFrom(new InternetAddress(from));
 
         // Set To: ͷ��ͷ�ֶ�
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
 
         // Set Subject: ͷ��ͷ�ֶ�
         message.setSubject("��������");
 
         // ������Ϣ��
         message.setText("This is ���� message");
 
         // ������Ϣ
         Transport.send(message);
         System.out.println("Sent message successfully....from runoob.com");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}