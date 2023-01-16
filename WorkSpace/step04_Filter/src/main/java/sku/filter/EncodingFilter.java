package sku.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName = "encodingFilter", urlPatterns = { "/*"})
public class EncodingFilter implements Filter {
       
    public EncodingFilter() {
    	System.out.println("EncodingFilter 생성자 호출");
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("EncodingFilter init 호출");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전처리
		System.out.println("EncodingFilter의 사전 처리 중입니다.");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);	//실제 타겟대상을 호출해주고 다시와서 사후처리를 한다.
		
		//사후처리
		System.out.println("EncodingFilter의 사후 처리 중입니다.");
	}


	public void destroy() {
		System.out.println("EncodingFilter destroy 호출");
	}
}
