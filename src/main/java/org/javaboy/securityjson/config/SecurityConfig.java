package org.javaboy.securityjson.config;

import org.javaboy.securityjson.filter.ResetLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/22 17:36
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    ResetLoginFilter loginFilter() throws Exception {
        ResetLoginFilter filter = new ResetLoginFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
