package bank.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	private Object path;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();
		map.put("/join.do", new JoinController());
		map.put("/login.do", new LoginController());
		map.put("/deposit.do", new DepositController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}
}
