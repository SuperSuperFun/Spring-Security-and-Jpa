package com.wangli.springsecurity.config;

import com.wangli.springsecurity.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author wangli
 * 参考 http://blog.csdn.net/u012702547/article/details/54319508
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and().logout().permitAll();
    }

    /**
     * 更多的权限控制方式：
     * access(String) String EL表达式结果为true时可访问
     * anonymous() 匿名可访问
     * denyAll() 用户不可访问
     * fullyAuthenticated() 用户完全认证可访问（非remember me下自动登录）
     * hasAnyAuthority(String) 参数中任意权限的用户可访问
     * hasAnyRole(String) 参数中任意角色的用户可访问
     * hasAuthority(String) 某一权限的用户可访问
     * hasRole(String) 某一角色的用户可访问
     * permitAll() 所有用户可访问
     * rememberMe() 允许通过remember me登录的用户访问
     * authenticated() 用户登录后可访问
     * hasIpAddress(String) 用户来自参数中的ip可访问
     *
     * 上面的方法还可以做更多的配置，如下：
     * http.authorizeRequests()
     .anyRequest().authenticated()
     .and().formLogin().loginPage("/login")
     //设置默认登录成功跳转页面
     .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
     .and()
     //开启cookie保存用户数据
     .rememberMe()
     //设置cookie有效期
     .tokenValiditySeconds(60 * 60 * 24 * 7)
     //设置cookie的私钥
     .key("")
     .and()
     .logout()
     //默认注销行为为logout，可以通过下面的方式来修改
     .logoutUrl("/custom-logout")
     //设置注销成功后跳转页面，默认是跳转到登录页面
     .logoutSuccessUrl("")
     .permitAll();
     * */
}
