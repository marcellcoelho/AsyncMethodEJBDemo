package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
@Asynchronous
public class CalculatorBean {

	public Future<Integer> adicao(StringBuilder sb, int num1, int num2) {
		sb.append("<font color='red'> Thread: "+Thread.currentThread().getName()+": foi iniciada em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " - Método 'adicao' </font> <br/>");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int result = num1 + num2;
		sb.append("<br/> <font color='red'> Thread: "+Thread.currentThread().getName()+": foi finalizada em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " - Método 'adicao' </font> <br/>");
		return new AsyncResult<Integer>(result);
	}

	public Future<Integer> subtracao(StringBuilder sb, int num1, int num2) {
		sb.append("<font color='blue'> Thread: "+Thread.currentThread().getName()+": foi iniciada em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " - Método 'subtracao' </font> <br/>");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int result = num1 - num2;
		sb.append("<font color='blue'> Thread: "+Thread.currentThread().getName()+": foi finalizada em: " +new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " - Método 'subtracao' </font> <br/>");
		return new AsyncResult<Integer>(result);

	}
	
	public Future<Integer> multiplicacao(StringBuilder sb, int num1, int num2) {
		sb.append("<font color='FFAE00'> Thread: "+Thread.currentThread().getName()+": foi iniciada em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())  + " - Método 'multiplicacao' </font> <br/>");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int result = num1 * num2;
		sb.append("<font color='FFAE00'> Thread: "+Thread.currentThread().getName()+": foi finalizada em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())  + " - Método 'multiplicacao' <br/>");
		return new AsyncResult<Integer>(result);

	}

}
