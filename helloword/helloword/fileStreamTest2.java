package helloword;

import java.io.*;

public class fileStreamTest2{
  public static void main(String[] args) throws IOException {
    
    File f = new File("a.txt");
   // FileOutputStream fop = new FileOutputStream(f);
    // ����FileOutputStream����,�ļ������ڻ��Զ��½�
    
//    OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
//    // ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk
//    
//    writer.append("��������");
//    // д�뵽������
//    
//    writer.append("\r\n");
//    //����
//    
//    writer.append("English");
//    // ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��
//    
//    writer.close();
//    //�ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�
//    
//    fop.close();
    // �ر������,�ͷ�ϵͳ��Դ
 
    FileInputStream fip = new FileInputStream(f);
    // ����FileInputStream����
    
    InputStreamReader reader = new InputStreamReader(fip, "utf-8");
    // ����InputStreamReader����,������д����ͬ
 
    StringBuffer sb = new StringBuffer();
    while (reader.ready()) {
      sb.append((char) reader.read());
      // ת��char�ӵ�StringBuffer������
    }
    System.out.println(sb.toString());
    reader.close();
    // �رն�ȡ��
    
    fip.close();
    // �ر�������,�ͷ�ϵͳ��Դ
    
    File f1=new File("./");
    if(f1.isDirectory()) {
    	System.out.println("Ŀ¼"+"./");
    	String [] s = f1.list();
    	for(int i=0;i<s.length;i++) {
    		File f2=new File("./"+s[i]);
    		if(f2.isDirectory()){
    		 System.out.println(s[i]+"��һ��Ŀ¼");    			
    		}
    		else {
    			System.out.println(s[i]+"��һ���ļ�"); 
    		}
    	}
    }
 
  }
}