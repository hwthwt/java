package helloword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReader {
	 public static void main(String args[]) throws IOException
	  {
	    char c;
	    // ʹ�� System.in ���� BufferedReader 
	    BufferedReader br = new BufferedReader(new 
	                       InputStreamReader(System.in));
	    System.out.println("�����ַ�, ���� 'q' ���˳���");
	    // ��ȡ�ַ�
	    do {
	       c = (char) br.read();
	       System.out.println(c);
	    } while(c != 'q');
	  }
}
