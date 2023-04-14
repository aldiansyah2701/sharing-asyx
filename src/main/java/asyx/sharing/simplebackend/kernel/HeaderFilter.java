package asyx.sharing.simplebackend.kernel;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String headerToken = request.getHeader("Authorization");
		log.info("header : " + headerToken);

		if (resolveToken(request) == null) {
			response.sendError(HttpStatus.FORBIDDEN.value(), "need authorization");
		}

		filterChain.doFilter(request, response);

	}
	
	public String resolveToken(HttpServletRequest req) {
	    String bearerToken = req.getHeader("Authorization");
	    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
	      return bearerToken.substring(7);
	    }
	    return null;
	  }

}
