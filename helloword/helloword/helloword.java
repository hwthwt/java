package helloword;
public class helloword{
   public helloword(String name){
      //�������������һ��������name
      System.out.println("С���������� : " + name ); 
   }
   public static void main(String []args){
      // �������佫����һ��Puppy����
	   helloword myPuppy = new helloword( "tommy" );
   }
}