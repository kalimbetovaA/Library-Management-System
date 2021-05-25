package kz.iitu.demo.config;

import kz.iitu.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                .permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers( "/users/me/**").authenticated()
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/books/**", "/authors/**", "/publishers/**").hasAuthority("LIBRARIAN")
                .antMatchers(HttpMethod.PUT,"/books/**", "/authors/**", "/publishers/**").hasAuthority("LIBRARIAN")
                .antMatchers(HttpMethod.DELETE, "/books/**", "/authors/**", "/publishers/**").hasAuthority("LIBRARIAN")
                .antMatchers(HttpMethod.PATCH, "/books/**", "/authors/**", "/publishers/**").hasAuthority("LIBRARIAN")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
