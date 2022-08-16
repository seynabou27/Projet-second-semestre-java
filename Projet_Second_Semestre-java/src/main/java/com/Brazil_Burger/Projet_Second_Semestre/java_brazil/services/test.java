// package com.Brazil_Burger.Projet_Second_Semestre.java_brazil.services;

// public class test {

//     @Autowired
//     private BCryptPasswordEncoder bCryptPasswordEncoder;

//     @Autowired
//     private MyUserDetailsService userDetailsService;



//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//                 auth
//                     .userDetailsService(userDetailsService)
//                     .passwordEncoder(bCryptPasswordEncoder);
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {

//         http.
//                 authorizeRequests()
//                 .antMatchers("/").permitAll()
//                 .antMatchers("/login").permitAll()
//                 .antMatchers("/registration").permitAll()
//                 .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//                 .authenticated().and().csrf().disable().formLogin()
//                 .loginPage("/login").failureUrl("/login?error=true")
//                 .defaultSuccessUrl("/admin/home")
//                 .usernameParameter("user_name")
//                 .passwordParameter("password")
//                 .and().logout()
//                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                 .logoutSuccessUrl("/login").and().exceptionHandling()
//                 .accessDeniedPage("/access-denied");
//     }

//     @Override
//     public void configure(WebSecurity web) throws Exception {
//         web
//                 .ignoring()
//                 .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//     }
    
// }



// //ori


// @Autowired
// private MyUserDetailsService userDetailsService;


// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     auth.userDetailsService(userDetailsService)
//     .passwordEncoder(encoder());
// }

// @Override
// protected void configure(HttpSecurity http) throws Exception {
//     http.authorizeRequests()
//     .antMatchers("/").permitAll()
//     .antMatchers("/login").permitAll()
//     .antMatchers("/inscription").permitAll()
//     .antMatchers("/index").permitAll()
//     .antMatchers("/catalogue").permitAll()
//     .antMatchers("/gestionnaire/**").hasAuthority("GESTIONNAIRE").anyRequest()
//     .authenticated().and().csrf().disable().formLogin()
//     .loginPage("/login").failureUrl("/login?error=true")
//     .defaultSuccessUrl("/gestionnaire/home")
//     .usernameParameter("user_name")
//     .passwordParameter("password")
//     .and().logout()
//     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//             .logoutSuccessUrl("/login").and().exceptionHandling()
//             .accessDeniedPage("/access-denied");
// }

// @Override
// public void configure(WebSecurity web) throws Exception {
//     web
//             .ignoring()
//             .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return NoOpPasswordEncoder.getInstance();
// }

// @Bean
// BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder(); }
