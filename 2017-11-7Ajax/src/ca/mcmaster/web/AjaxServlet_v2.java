package ca.mcmaster.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.mcmaster.vo.Products;

public class AjaxServlet_v2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Products> products = new ArrayList<Products>();
		response.setContentType("text/html;charset=utf-8");
		products.add(new Products(1, "washing machine", 1800));
		products.add(new Products(2, "TV", 1900));
		products.add(new Products(3, "air condition", 1500));
		
//		PrintWriter out = response.getWriter();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
