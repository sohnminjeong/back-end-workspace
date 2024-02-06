package servlet.life;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성자 호출..");
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		// 시작할 때 
		System.out.println("init 호출..");  
	}

	
	public void destroy() {
		// 끝날 때
		System.out.println("destroy 호출..");  // 서버가 꺼지는 순간에 일어남 
	}

	// 1. service에 구현
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// service는 doget과 dopost과 합쳐진 것
//		System.out.println("service 호출..");
//	}

	// 2. doGet에 구현
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 받으면 doget으로 옴
		System.out.println("doGet 호출..");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 받으면 dopost로 옴 
		System.out.println("doPost 호출..");
	}

}
