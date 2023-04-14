package asyx.sharing.simplebackend.kernel;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class TokenFilterConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		HeaderFilter filter = new HeaderFilter();
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

}
