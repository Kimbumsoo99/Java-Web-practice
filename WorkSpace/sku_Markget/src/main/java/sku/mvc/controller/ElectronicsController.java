package sku.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sku.mvc.dto.Electronics;
import sku.mvc.dto.UserDTO;
import sku.mvc.service.ElectronicsService;
import sku.mvc.service.ElectronicsServiceImpl;

public class ElectronicsController implements Controller {
	
	private ElectronicsService elecService = new ElectronicsServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  전체검색
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		  String pageNo = request.getParameter("pageNo");
		  if(pageNo==null || pageNo.equals("")) {
			  pageNo="1";
		  }
		
		List<Electronics> list = elecService.selectAll();
		
		 // List<Electronics> list = elecService.selectAll( Integer.parseInt(pageNo) );
		  
		request.setAttribute("list", list);//뷰에서 ${list}
		//request.setAttribute("pageNo", pageNo); //뷰에서 ${pageNo}
		
		return new ModelAndView("elec/list.jsp"); //forward방식으로 이동
	}
	
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//폼에서 enctype="multipart/form-data" 설정되어 있기때문에 request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save"); //
		int maxSize=1024*1024*100; //100M
		String encoding="UTF-8";
		
		MultipartRequest m = 
		 new MultipartRequest(request,saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		HttpSession session = request.getSession();
		//전송된 데이터 받기 
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		UserDTO userDTO = (UserDTO) session.getAttribute("loginUser");
		String password = userDTO.getPwd();
		
		Electronics elec = 
			new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
		System.out.println("등록 사용자 : "+userDTO.getUserId());
		elec.setWriteUser(userDTO.getUserId());
		//만약, 파일첨부가 되었다면....
		if(m.getFilesystemName("file") != null) {
			//파일이름저장
			elec.setFname(m.getFilesystemName("file"));
			
			//파일크기저장
			long size = m.getFile("file").length();
			elec.setFsize( (int)size );
		}
		
		elecService.insert(elec);

	   return new ModelAndView("front", true);//key=elec&methodName=select 기본으로 설정된다.	
	}
	
	/**
	 * 상세보기 
	 * */

	public ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 String modelNum = request.getParameter("modelNum");
		 boolean state = request.getParameter("flag")==null ? true : false;
		 
		String pageNo =  request.getParameter("pageNo");
		 
		 //두번째 인수 boolean 조회수 증가여부를판단할 인수(true이면, false이면 증가안함)
		Electronics electronics = elecService.selectByModelnum(modelNum, state);
		request.setAttribute("elec", electronics);
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/read.jsp"); //forward방식 
	}
	
	
	/**
	 *  수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum  = request.getParameter("modelNum");
		String pageNo  = request.getParameter("pageNo");
		
		Electronics elec = elecService.selectByModelnum(modelNum, false);
		request.setAttribute("elec", elec);
		request.setAttribute("pageNo", pageNo);
		
		return new ModelAndView("elec/update.jsp");//forward방식
	}
	
	/**
	 * 수정완료
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   //수정할 정보 5개 받기
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("loginUser");
		String password = userDTO.getPwd();
		System.out.println("패스워드"+password);
		String pageNo = request.getParameter("pageNo");
		
		elecService.update( new Electronics(modelNum, modelName, Integer.parseInt(price), 
				description, password) );
		
		//수정이 완료가 된후....
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=elec&methodName=selectByModelNum&modelNum="+modelNum+"&flag=1&pageNo="+pageNo);
	    mv.setRedirect(true);
		return mv;
	}
	/**
	 * 삭제
	 * 
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//전송되는 2개받기
		HttpSession session = request.getSession();
		String modelNum = request.getParameter("modelNum");
		UserDTO userDTO = (UserDTO) session.getAttribute("loginUser");
		String password = userDTO.getPwd();
		
		//첨부된 파일을 삭제하는 경우라면 삭제가 되었을때 폴더에서 파일도 삭제한다. - 이 기능을 service한다.
		String saveDir = request.getServletContext().getRealPath("/save");
		
		elecService.delete(modelNum, password , saveDir);
		
		return new ModelAndView("front", true);
	}
	
}//classEnd



























