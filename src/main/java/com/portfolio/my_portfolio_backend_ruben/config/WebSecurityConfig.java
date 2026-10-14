package com.portfolio.my_portfolio_backend_ruben.config;

import com.portfolio.my_portfolio_backend_ruben.service.IUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final IUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth ->
                auth
                        .requestMatchers("/education", "/experience", "/skills", "/projects", "/personal-info").authenticated()
                        .requestMatchers("/education/new-education", "/education/save", "/education/edit/**", "/education/delete/**").authenticated()
                        .requestMatchers("/experience/new-experience", "/experience/save", "/experience/edit/**", "/experience/delete/**").authenticated()
                        .requestMatchers("/skills/new-skill", "/skills/save", "/skills/edit/**", "/skills/delete/**").authenticated()
                        .requestMatchers("/projects/new-project", "/projects/save", "/projects/edit/**", "/projects/delete/**").authenticated()
                        .requestMatchers("/personal-info/create", "/personal-info/edit/**", "/personal-info/save").authenticated()

                        // Las rutas de búsqueda por personalInfoId
                        .requestMatchers("/education/personal/**", "/experience/personal/**", "/skills/personal/**").authenticated()
                        .anyRequest().permitAll()
        )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/education", true) // Redirige a /education si el login es exitoso
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }




//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails user = User.withUsername("admin")
//                .password(passwordEncoder.encode("1234"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
