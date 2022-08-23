package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.security;

import javax.sql.DataSource;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.models.Gestionnaire;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity 
@EnableGlobalMethodSecurity(securedEnabled = true)
public class webConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void globalConfig( AuthenticationManagerBuilder auth , DataSource dataSource ) throws Exception{
    //  auth.inMemoryAuthentication().withUser("user").password("{noop}passer").roles("GESTIONNAIRE","CLIENT");
    //  auth.inMemoryAuthentication().withUser("client").password("{noop}passer").roles("CLIENT"); 
    //  auth.inMemoryAuthentication().withUser("admin").password("{noop}passer").roles("GESTIONNAIRE"); 

    // auth.jdbcAuthentication()
    //     .dataSource(dataSource)
    //     .usersByUsernameQuery("select nom as principal, password as credentials,true from user where nom=?") 
    //     .authoritiesByUsernameQuery("select id as principal,libelle as role from role where libelle=?  ");
     }
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(encoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
      return NoOpPasswordEncoder.getInstance();
    }
  
    @Bean
    BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder(); }
  
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/inscription").permitAll()
        .antMatchers("/Produit").permitAll()
        .antMatchers("/detail/{type}/{id}").permitAll()
        .antMatchers("/gestionnaire").permitAll()
        .antMatchers("/gestionnaire/home").permitAll()


            .anyRequest()
                .authenticated()
                    .and()
                    
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/gestionnaire/home", true)
        .usernameParameter("username")
        .passwordParameter("password")
        .permitAll()
            .and()
            .logout()
                .permitAll();
        }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
        .ignoring()
        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    
}