package com.ideas;

import java.io.IOException;
import java.io.PrintWriter;

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
		String employeeName = request.getParameter("name");
		String amount = request.getParameter("amount");
		String employeeNumber = request.getParameter("empNo");
		FormService service  = new FormService();
		System.out.println(form + amount+employeeName+employeeNumber);
	
		if(null!= form && form.equalsIgnoreCase("healthCare")){
			double amountTillNow = service.getTotalAmount(form, employeeName);
			if(amount==null ||amount.equalsIgnoreCase("")){
				amount = "0";
			}
			double totalAmount = Double.valueOf(amount)+amountTillNow;
			if(totalAmount >2500){
				PrintWriter writer = response.getWriter();
				writer.write("You have surpassed the limit by "+(totalAmount-2500));
			}
			else{
				service.saveForm(employeeName, employeeNumber, amount, form);
				request.setAttribute("status", "Success");
				response.sendRedirect("healthCare.jsp");
			}
		}
		

	}

}
