package ptithcm.internship.movieapp.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/", "/login", "/logout", "/hotfilm" ,"/hotfilm/*",
            			"/categories" ,"/categories/*", "/countries" ,"/countries/*","/add-new", "/add-new/*",
            			"/review", "/review/*", "/watch", "/watch/*").permitAll()
            .antMatchers(HttpMethod.POST, "/add-new", "/add-new/*").permitAll()
            .antMatchers("/filmmanager", "/filmmanager/*", "/review-has-role", "/review-has-role/*", 
            		"/accept-film-request", "/accept-film-request/*","/delete-film-request", 
            		"/delete-film-request/*", "/watch-has-role", "/watch-has-role/*").hasAnyRole("MEMBER", "ADMIN")
            .antMatchers("/admin", "/admin/*").hasRole("ADMIN")
            .and()
        .formLogin()
            .loginPage("/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/filmManager")
            .failureUrl("/login?error")
            .and()
        .exceptionHandling()
            .accessDeniedPage("/403");
    }
 
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}
