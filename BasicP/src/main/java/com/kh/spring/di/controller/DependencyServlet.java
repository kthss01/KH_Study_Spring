package com.kh.spring.di.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.spring.di.model.vo.Singer;
import com.kh.spring.di.model.vo.SingerMgt;

/**
 * Servlet implementation class DependencyServlet
 */
@WebServlet("/dependency.do")
public class DependencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* IOC & DI
		 * 개발자가 직접 new 하여 객체를 생성하던 방식에서 개발자의 부담을 덜어주며,
		 * 보다 편하게 개발 가능하도록 객체를 생성, 수정, 삭제(소멸) 하도록 구현한 기술
		 */
		
		// 1. 일반 클래스 생성   
		// version 1 version 2로 변경 시 모든 내용을 변경해야하는 경우가 생김 
		// 이를 결합도가 높다고 표현 -> 유지보수 어려움
		// -> 개발자가 new를 통해 직접 생성
//		Twice singer = new Twice();
//		BlackPink singer= new BlackPink();
//		singer.compose();
//		singer.sing();
		
		// 2. 인터페이스를 사용하여 결합도 낮추기
		// 개발자가 new를 통해 객체를 직접 생성
//		Singer singer = new BlackPink();
//		singer.compose();
//		singer.sing();
//		singer.dance();
		
		// 3. 전략 디자인 패턴(Strategy Pattern)을 이용하여 결합도 낮추기
		// 전달받은 값에 따라 해당하는 객체를 바꿔서 만들어주는 방식		
//		Singer singer = (Singer) BeanFactory.getBean(request.getParameter("bean"));
//		singer.compose();
//		singer.sing();
//		singer.dance();
		
		// 4. 스프링 컨테이너를 사용한 객체 생성하기 (xml)
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/sample-context.xml");
		
		Singer singer = (cntx.getBean("singerMgt", SingerMgt.class)).getSinger();
//		Singer singer = (cntx.getBean(SingerMgt.class)).getSinger();
//		Singer singer = ((SingerMgt) cntx.getBean("singerMgt")).getSinger();
		
		singer.compose();
		singer.sing();
		singer.dance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
