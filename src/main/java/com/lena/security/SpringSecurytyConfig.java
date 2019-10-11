package com.lena.security;

import com.lena.security.authentication.MyAuthenctiationFailureHandler;
import com.lena.security.authentication.MyAuthenticationSuccessHandler;
import com.lena.security.authentication.MyLogoutSuccessHandler;
import com.lena.security.authentication.RestAuthenticationAccessDeniedhandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @ClassName SpringSecurytyConfig
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/10/9 16:13
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SpringSecurytyConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Autowired
    private RestAuthenticationAccessDeniedhandler restAuthenticationAccessDeniedhandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.authorizeRequests()
                .antMatchers("/static/**",
                        "/login",
                        "/xadmin/**",
                        "treetable-lay/**",
                        "dtree/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenctiationFailureHandler);
        //异常处理
        http.exceptionHandling()
                .accessDeniedHandler(restAuthenticationAccessDeniedhandler);
        http.logout()
                .permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESIONID")
                .logoutSuccessHandler(myLogoutSuccessHandler);
        http.rememberMe();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/xadmin/**");
        web.ignoring().antMatchers("/treetable-lay/**");
        web.ignoring().antMatchers("/dtree/**");
        web.ignoring().antMatchers("/myjs/**");
    }


}
