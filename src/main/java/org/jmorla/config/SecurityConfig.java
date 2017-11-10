package org.jmorla.config;

import org.jmorla.util.PasswordMD5Encoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by jmorla on 27/10/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login/")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/dashboard/")
                .loginProcessingUrl("/login")
                .failureUrl("/login/?error")
            .and()
                .authorizeRequests()
                    .antMatchers("/dashboard/","/add/contact/")
                    .authenticated()
                    .anyRequest()
                    .permitAll()
            .and()
                .rememberMe()
                    .tokenValiditySeconds(1_000_000)
                    .key("contactKey")
            .and()
                .logout()
                    .logoutSuccessUrl("/login/?logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,true " +
                        "from users u " +
                        "where u.username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_ADMIN' " +
                        "from users u " +
                        "where u.username=?")
                .passwordEncoder(new PasswordMD5Encoder());
    }
}
