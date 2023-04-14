package asyx.sharing.simplebackend.kernel;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests().antMatchers("/api/v1**").authenticated();
		
		http.apply(new TokenFilterConfigure());
		http.httpBasic();
	}
	
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring()
		.antMatchers("/api-docs/**")//
		.antMatchers("/swagger-resources/**")//
		.antMatchers("/swagger-ui.html")//
		.antMatchers("/swagger-ui-custom.html")//
		.antMatchers("/configuration/**")//
		.antMatchers("/swagger-ui/**")//
		.antMatchers("/webjars/**")//
		.antMatchers("/public")
		.and().ignoring().antMatchers("/h2-console/**/**");
	}
	

}
