package ru.urfu.javaprogramming.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsersProperties usersProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/public/api/**")
            .permitAll()
            .antMatchers("/admin/api/**")
            .hasAnyRole("ADMIN")
            .antMatchers("/support/api/**")
            .hasAnyRole("SUPPORT")
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(users(usersProperties));
    }

    @Bean
    public UserDetailsService users(UsersProperties usersProperties) {
        UsersProperties.User adminProperties = usersProperties.getAdmin();
        UserDetails admin = User.builder()
                                .username(adminProperties.getUsername())
                                .password(passwordEncoder().encode(adminProperties.getPassword()))
                                .roles("ADMIN")
                                .build();
        UsersProperties.User supportProperties = usersProperties.getSupport();
        UserDetails support = User.builder()
                                  .username(supportProperties.getUsername())
                                  .password(passwordEncoder().encode(supportProperties.getPassword()))
                                  .roles("SUPPORT")
                                  .build();
        return new InMemoryUserDetailsManager(admin, support);
    }

}
