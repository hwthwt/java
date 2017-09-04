package com.airplay.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public  class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 使用 GBK 设置中文正常显示
				response.setCharacterEncoding("UTF-8");
				
				request.setAttribute("filelist",myListFiles("e:/Media/mp4"));
				request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public File[] myListFiles(String dir) {

        File directory = new File(dir);

        if (!directory.isDirectory()) {
            System.out.println("No directory provided");
            return null;
        }

        File[] files = directory.listFiles(filefilter);

        for (File f : files) {
            System.out.println(f.getName());            
        }
        return files;
    }
     FileFilter filefilter = new FileFilter() {

        public boolean accept(File file) {
            //if the file extension is .txt return true, else false
            if (file.getName().endsWith(".mp4")) {
                return true;
            }
            return false;
        }
    };
//    public static void main(String[] args) {
//    	myListFiles("e:/job");
//    }
//	
	public boolean readfile(String filepath) throws FileNotFoundException, IOException {
         try {

                 File file = new File(filepath);
                 if (!file.isDirectory()) {
                         System.out.println("文件");
                         System.out.println("path=" + file.getPath());
                         System.out.println("absolutepath=" + file.getAbsolutePath());
                         System.out.println("name=" + file.getName());

                 } else if (file.isDirectory()) {
                         System.out.println("文件夹");
                         String[] filelist = file.list();
                         for (int i = 0; i < filelist.length; i++) {
                                 File readfile = new File(filepath + "\\" + filelist[i]);
                                 if (!readfile.isDirectory()) {
                                         System.out.println("path=" + readfile.getPath());
                                         System.out.println("absolutepath="
                                                         + readfile.getAbsolutePath());
                                         System.out.println("name=" + readfile.getName());

                                 } else if (readfile.isDirectory()) {
                                         readfile(filepath + "\\" + filelist[i]);
                                 }
                         }

                 }

         } catch (FileNotFoundException e) {
                 System.out.println("readfile()   Exception:" + e.getMessage());
         }
         return true;
 }


}
