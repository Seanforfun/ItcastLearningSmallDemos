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

public class AjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Products> products = new ArrayList<Products>();
		response.setContentType("text/html;charset=utf-8");
		products.add(new Products(1, "washing machine", 1800));
		products.add(new Products(2, "TV", 1900));
		products.add(new Products(3, "air condition", 1500));
		
		PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		
		builder.append("<table><tr><td>Product id</td><td>Product name</td><td>Product price</td></tr>");
		
		for(int i = 0; i < products.size(); i++)
		{
			Products curentProduct = products.get(i);
			builder.append("<tr><td>"+ curentProduct.getId()+"</td><td>"+curentProduct.getName()+"</td><td>"+curentProduct.getPrice()+"</td></tr>");
		}
		
		builder.append("</table>");
		out.write(builder.toString());
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
