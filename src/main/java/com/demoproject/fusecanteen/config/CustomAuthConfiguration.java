package com.demoproject.fusecanteen.config;

import com.demoproject.fusecanteen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserRepository

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        String passwordEncodedAyush = passwordEncoder().encode("12345");
//        String passwordEncodedKamlesh = passwordEncoder().encode("12345");
//        auth.inMemoryAuthentication().withUser("ayush").password(passwordEncodedAyush).roles("admin")
//                .and().withUser("kamlesh").password(passwordEncodedKamlesh).roles("employee");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/employee/**").hasRole("employee")
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
