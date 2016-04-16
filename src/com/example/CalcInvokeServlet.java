package com.example;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcInvokeServlet
 */
@WebServlet("/CalcInvokeServlet")
public class CalcInvokeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	CalculatorBean calcBean;

	public CalcInvokeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();

		Future<Integer> soma = calcBean.adicao(sb, 2, 2);
		Future<Integer> subtracao = calcBean.subtracao(sb, 2, 2);
		Future<Integer> multiplicacao = calcBean.multiplicacao(sb, 2, 2);
		

		try {
			System.out.println(soma.get() + subtracao.get() +  multiplicacao.get());
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}

		request.setAttribute("message", sb.toString());
		request.getRequestDispatcher("response.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
