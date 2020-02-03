package com.study.springboot.springbootbbs.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll() // 모두 허용
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/guest/**").permitAll()
                .antMatchers("/member/**").hasAnyRole("USER", "ADMIN") // user 혹은 admin 롤에게만 허용
                .antMatchers("/admin/**").hasRole("ADMIN") // admin 롤 에게만 허용
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/loginForm") // default: /login
//                .loginProcessingUrl("/j_spring_security_check")
//                .failureUrl("/login?error") // default: /login?error
                .failureHandler(authenticationFailureHandler)
                .usernameParameter("j_username") // default: j_username
                .passwordParameter("j_password") // default: j_password
                .permitAll(); // 로그인폼 모두에게 허용
        http.logout()
                .logoutUrl("/logout") // default: /logout
                .logoutSuccessUrl("/")
                .permitAll(); // 로그아웃 모두에게 허용

        // ssl을 사용하지 않으면 true로 사용
        http.csrf().disable();
    }

    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication() // 테스트용으로 Memory에 기록되는 유저를 추가함
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
                // ROLE_ADMIN 에서 ROLE_는 자동으로 붙는다.
    }
    */

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        System.out.println(passwordEncoder().encode("1234"));

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select name as userName, password, enabled" + "from user_list where name = ?")
                .authoritiesByUsernameQuery("select name as userName, authority" + "from user_list where name = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    // passwordEncode() 추가
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
