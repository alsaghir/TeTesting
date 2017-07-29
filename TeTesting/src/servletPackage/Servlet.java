package servletPackage;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;

public class Servlet extends HttpServlet implements javax.servlet.Servlet {

	private final static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@EJB
	BeanInt BeanObject;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		System.out.println(request.getRequestURI());

		if ("/TeTesting/delete".equals(request.getRequestURI())) {

			BeanObject.deleteEntity(Integer.parseInt(request.getParameter("id")));

			response.sendRedirect("/TeTesting/plain");
			return;
		}

		List entityList = BeanObject.getEntities();

		if (entityList != null)
			request.getSession().setAttribute("entityList", entityList);

		if ((request.getContextPath() + "/plain").equals(request.getRequestURI())
				|| (request.getContextPath() + "/").equals(request.getRequestURI())) {
			request.getRequestDispatcher("/views/return.jsp").forward(request, response);
		}

		else if ((request.getContextPath() + "/edit").equals(request.getRequestURI())) {
			Entity toEditEntity = null;
			if (request.getParameter("id") != null)
				toEditEntity = BeanObject.getOneEntity(Integer.parseInt(request.getParameter("id")));
			 request.getSession().setAttribute("toEditEntity", toEditEntity);
			request.getRequestDispatcher("/views/entry.jsp").forward(request, response);
			request.getSession().invalidate();
		}

		else
			request.getRequestDispatcher("/views/entry.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("/TeTesting/entry".equals(request.getRequestURI())) {
			boolean tempSuccess = request.getParameter("success") == null ? false : true;
			Entity newEntity = new Entity(request.getParameter("name"), request.getParameter("title"),
					Integer.parseInt(request.getParameter("age")), tempSuccess);
			BeanObject.addEntity(newEntity);
			response.sendRedirect("/TeTesting/plain");
			return;
		}

		else if ("/TeTesting/edit".equals(request.getRequestURI())) {
			System.out.println("INSIDE EDIT");
			boolean tempSuccess = request.getParameter("success") == null ? false : true;
			Entity newEntity = new Entity(request.getParameter("name"), request.getParameter("title"),
					Integer.parseInt(request.getParameter("age")), tempSuccess);
			newEntity.setId(Integer.parseInt(request.getParameter("id")));
			BeanObject.updateEntity(newEntity);
			response.sendRedirect("/TeTesting/plain");
			return;
		}
	}
}
