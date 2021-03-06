package com.ideas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import waffle.windows.auth.IWindowsAccount;
import waffle.windows.auth.impl.WindowsAuthProviderImpl;

@WebServlet(name = "WelcomeServlet", urlPatterns = { "/Welcome" })
public class WelcomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("userName");
		if (username != null) {
			try {
				if(request.getSession().getAttribute("browser").toString().indexOf("MSIE")!=-1){
					System.out.println("HEY HEy");
		              WindowsAuthProviderImpl provider = new WindowsAuthProviderImpl();
		              IWindowsAccount account = provider.lookupAccount(username);
		              response.sendRedirect("Sucess.jsp");
				}
				String REQUESTEDFIELDS = "employeeNumber,displayName,mail,telephoneNumber,employeeType,department,title";
				Employee retrievedUserInfo = null;
				retrievedUserInfo = new ActiveDirectoryUserInfo("ROW\\" + username, REQUESTEDFIELDS).getUserDetails();
				if (!((String) retrievedUserInfo.getEmployeeType()).contains("Contractor")) {
					retrievedUserInfo.setAuthorized("Authorized");
				}
				request.getSession().setAttribute("user", retrievedUserInfo);
				response.sendRedirect("Forms.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("index.jsp");
		}

	}

	// private String AccountToJson(Employee retrievedUserInfo) {
	// Gson gson = new Gson();
	// return gson.toJson(retrievedUserInfo);
	// }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String form = (String) request.getParameter("operation");
		Employee employee = (Employee) request.getSession().getAttribute("user");
		String employeeName = employee.getName();
		FormService service  = new FormService();
		
		
	
		String amount = request.getParameter("amount");
		String employeeNumber = employee.getEmployeeID();
		String date = request.getParameter("date");
		System.out.println(form + amount+employeeName+employeeNumber+date);
		String hospital = request.getParameter("hospital");
		String description = request.getParameter("details");
		
	
		if(null!= form && form.equalsIgnoreCase("healthCare") ){
			double amountTillNow = 0;
			try {
				amountTillNow = service.getTotalAmount(form, employeeName);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(amount==null ||amount.equalsIgnoreCase("")){
				amount = "0";
			}
			double totalAmount = Double.valueOf(amount)+amountTillNow;
			if(totalAmount >2500){
				request.setAttribute("amount", totalAmount-2500);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request,response);
				 
			}
			else{
				try {
					service.saveForm(employeeName, employeeNumber, amount, form,date);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("balance", 2500-totalAmount);
				Form1 form1;
				form1 = new Form1(employee, hospital, description, date, amount);
				request.setAttribute("data", form1);
				request.setAttribute("amount", amount);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
				dispatcher.forward(request,response);
			}
		}
		
		

	}

}
