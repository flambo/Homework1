package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		//perform business logic.Return a bean as a result	
		
		//CustomerService service = (CustomerService)CustomerService.getInstance();///완성
		//Customer customer = service.findCustomer(id);
		//request.setAttribute("customer", customer);//customer에 대한 정보 저장해놓음.
		name = new String(name.getBytes("8859_1"), "UTF-8");
		Customer customer = new Customer(id, password, name, gender, email);//객체 생성
		CustomerService.getInstance().addCustomer(customer);//Map에 customer put
		
		String page;
		if(customer == null){
			page = "/view/error.jsp";
			request.setAttribute("id", id);
		}
			else{
				page = "/view/registerSuccess.jsp";
				request.setAttribute("customer", customer);
			}
		RequestDispatcher dispatcher =  request.getRequestDispatcher(page);
		//해당 페이지로 이동
		dispatcher.forward(request, response);  //41 43줄 포워딩.
			
		
	}

}
