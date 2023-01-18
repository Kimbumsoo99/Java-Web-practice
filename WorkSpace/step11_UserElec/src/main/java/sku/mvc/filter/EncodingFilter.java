package kosta.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingFilter
 */
/*@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})*/
public class EncodingFilter implements Filter {
	
	private String encoding;
	
	public EncodingFilter() {
		System.out.println("EncodingFilter 생성됨....");
	}
	
    public void init(FilterConfig fConfig) throws ServletException {
    	encoding = fConfig.getInitParameter("encoding");
    	System.out.println("encoding = " + encoding);
	}

	public void destroy() { }

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전처리
		System.out.println("Encoding.....");
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		//사후처리
	}

	

}
