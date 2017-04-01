package app.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth)throws Exception {
		
		auth.inMemoryAuthentication().withUser("juniorro").password("antergos").roles("ADMIN", "USER");
		
		auth.inMemoryAuthentication().withUser("client").password("gnome").roles("USER");
		
	}
	
	@Override
	protected void configure (HttpSecurity http)throws Exception {
		
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/home", "/accounts", "/transactions").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/home", "/accounts").hasRole("USER");
		
	}

}
