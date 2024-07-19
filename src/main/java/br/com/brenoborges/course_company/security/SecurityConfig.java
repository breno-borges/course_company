package br.com.brenoborges.course_company.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // O Spring verifica as configs a serem feitas.
public class SecurityConfig {

    @Bean
    // Gerencia as requisições
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilitando pois a configuração será manual.
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/cursos/").permitAll(); // Liberar a rota.
                    auth.anyRequest().authenticated(); // Travar todas as demais rotas
                });
        return http.build();
    }
}
