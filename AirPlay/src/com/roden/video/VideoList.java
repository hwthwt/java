package com.roden.video;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoList
 */
@WebServlet(description = "get mp4 file list", urlPatterns = { "/VideoList" })
public class VideoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilenameFilter filenamefilter = new FilenameFilter() {
        public boolean accept(File dir,String name) {
            //if the file extension is .txt return true, else false
            if (name.endsWith(".mp4")) {
                return true;
            }
            return false;
        }
	};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String videoPath = getServletContext().getInitParameter("VideoPath");
		response.setCharacterEncoding("UTF-8");		
		request.setAttribute("VideoList",myListFiles(videoPath));
		request.getRequestDispatcher("/VideoList.jsp").forward(request, response);
	}

	private File[] myListFiles(String Path) {
		// TODO Auto-generated method stub
		File directory = new File(Path);

        if (!directory.isDirectory()) {
            System.out.println("No directory provided");
            return null;
        }

        File[] files = directory.listFiles(filenamefilter);

        for (File f : files) {
            System.out.println(f.getName());            
        }
        return files;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
