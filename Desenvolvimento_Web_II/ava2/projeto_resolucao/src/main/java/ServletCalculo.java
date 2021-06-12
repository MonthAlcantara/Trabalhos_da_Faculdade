import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Montival Junior
 * @Matricula 193003252
 * @Materia Desenvolvimento de Aplicações distribuídas 
 *
 */
@WebServlet(urlPatterns = { "/Calculo" })
public class ServletCalculo extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private static final String ERRO_VALOR2 = "erroValor2";
		private static final String ERRO_VALOR1 = "erroValor1";
		private static final String ERRO_VALOR_2_INVALIDO = "Valor 2 invalido!";
		private static final String ERRO_VALOR_1_INVALIDO = "Valor 1 invalido!";
		private static final String VALOR_02 = "valor2";
		private static final String VALOR_01 = "valor1";
		private static final String ERRO_DIVISAO_POR_ZERO = "Divisao por zero";

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Float primeiroValor = null;
		Float segundoValor = null;
		String expressao = null;
		String tmp = null;

		boolean isPrimeiroValorInvalido = false;
		boolean isSegundoValorInvalido = false;
		
		if (Objects.nonNull(request.getParameter(VALOR_01))) {
			try {
				tmp = request.getParameter(VALOR_01);
				primeiroValor = Float.parseFloat(tmp.replaceAll(",", "."));
			} catch (Exception e) {
				isPrimeiroValorInvalido = true;
				request.setAttribute(ERRO_VALOR1, ERRO_VALOR_1_INVALIDO);
			}
		}

		if (Objects.nonNull(request.getParameter(VALOR_02))) {
			try {
				tmp = request.getParameter(VALOR_02);
				segundoValor = Float.parseFloat(tmp.replaceAll(",", "."));
			} catch (Exception e) {
				isSegundoValorInvalido = true;
				request.setAttribute(ERRO_VALOR2, ERRO_VALOR_2_INVALIDO);
				request.setAttribute(VALOR_02, request.getParameter(VALOR_02));
			}
		}
		if (isPrimeiroValorInvalido) {
			request.setAttribute(VALOR_01, request.getParameter(VALOR_01));
			request.setAttribute(VALOR_02, request.getParameter(VALOR_02));
			request.setAttribute(ERRO_VALOR1, ERRO_VALOR_1_INVALIDO);
		}

		if (isSegundoValorInvalido) {
			request.setAttribute(VALOR_01, request.getParameter(VALOR_01));
			request.setAttribute(VALOR_02, request.getParameter(VALOR_02));
			request.setAttribute(ERRO_VALOR2, ERRO_VALOR_2_INVALIDO);
		}

		if (!isPrimeiroValorInvalido && !isSegundoValorInvalido && primeiroValor != null && segundoValor != null) {
			Float resultado = null;
			char operacao = request.getParameter("op").charAt(0);

			switch (operacao) {
			case '+':
				resultado = primeiroValor + segundoValor;
				break;
			case '-':
				resultado = primeiroValor - segundoValor;
				break;
			case '*':
				resultado = primeiroValor * segundoValor;
				break;
			case '/':
				if (segundoValor != 0) {
					resultado = primeiroValor / segundoValor;
				} else {
					request.setAttribute(VALOR_01, request.getParameter(VALOR_01));
					request.setAttribute(VALOR_02, request.getParameter(VALOR_02));
					request.setAttribute("erroDiv", ERRO_DIVISAO_POR_ZERO);
				}
				break;
			}

			if (resultado != null) {
				expressao = String.format("%f %c %f = %f", primeiroValor, operacao, segundoValor, resultado);
				request.setAttribute("tmp", "Expressao: ");
				request.setAttribute("expressao", expressao);
			}
		}

		request.getRequestDispatcher("calcula.jsp").forward(request, response);
	}
	
}