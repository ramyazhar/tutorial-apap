package apap.tutorial.traveloke.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/api/v1/**").permitAll()
                .antMatchers("/hotel/**").hasAuthority("RECEPTIONIST")
                .antMatchers("/user/addUser").hasAuthority("ADMIN")
                .antMatchers("/kamar/add/**").hasAuthority("RECEPTIONIST")
                .antMatchers("/user/updatePassword").hasAnyAuthority("USER", "RECEPTIONIST", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();

    }
    @Bean
    public BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder(); }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("odading").password(encoder().encode("mangoleh"))
//                .roles("USER");
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}