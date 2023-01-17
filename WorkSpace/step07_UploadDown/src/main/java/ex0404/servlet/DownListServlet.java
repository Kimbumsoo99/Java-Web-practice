package ex0404.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownListServlet
 */
@WebServlet("/downList")
public class DownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		  Map<String, String> fileMap = new HashMap<String, String>();
		
		  //save폴더안에 있는 파일목록을 저장해서 뷰로 이동한다.
		  String saveDir = request.getServletContext().getRealPath("/save");
		  File file = new File(saveDir);
		  if(file.exists()) {
			  String fileNames [] = file.list();	//폴더안에 있는 파일이름을 String 배열로 만든다.
			  request.setAttribute("fileNames", fileNames); //뷰에서 ${requestScope.fileNames}
			  
			  
			  //맵 사용해서 한것
			   for(String fileName : fileNames) {
				   fileMap.put(fileName, URLEncoder.encode(fileName, "UTF-8"));
			   }
			   
			   request.setAttribute("fileMap", fileMap);
			  
		  }
		  
		  //이동
		  request.getRequestDispatcher("downList.jsp").forward(request, response);
		

	}
}
