package ex0404.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String name = request.getParameter("name");
		String subjet = request.getParameter("subject");
		String file = request.getParameter("file");*/
		
		String saveDir= request.getServletContext().getRealPath("/save");	//파일 저장경로인데 앞에 getRealPath는 실제 배포하면 실제 저장 위치라함 
		//우리는 개발용도로 webapp에 save폴더를 만든듯? 잘모르겠음
		int maxSize =1024*1024*100;//100M
	    String encoding="UTF-8";
		
		MultipartRequest m = 
			new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());	//맨뒤에 녀석은 동일한 이름으로 들어가면 맨뒤에숫자가 붙는 라벨링
		
		 
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		//이런 파일네임은 이름을 못받는다?
		String fileSystemName = m.getFilesystemName("file");// name="file"	
		String originalName = m.getOriginalFileName("file");// name="file"	얘는 진짜 사람이 올린 이름이다.(내부적으로 변경안된다?)
		
		
		//폼에서 enctype="multipart/form-data" 설정이 있으면 request로 받을수 없다.
		System.out.println("name : " + name);
		System.out.println("subject : " + subject);
		System.out.println("fileSystemName : " + fileSystemName);
		System.out.println("originalName : " + originalName);
		
		//뷰페이지쪽으로 전달할 데이터를 저장!!
		request.setAttribute("saveDir", saveDir); //뷰에서 ${requestScope.saveDir}
		request.setAttribute("name", name);
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("originalName", originalName);
		
		
		//뷰페이지로 이동
		request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
		
		//
		
	}

}





