package chapter02;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hwj
 * @date 2019/4/13 12:16
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		System.out.println("AuthenticationSuccessHandlerImpl...onAuthenticationSuccess...");
		response.sendRedirect(request.getContextPath());
	}

}