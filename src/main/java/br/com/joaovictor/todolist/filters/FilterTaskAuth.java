package br.com.joaovictor.todolist.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Pegar a autenticação (usuario e senha)
        String[] authorization = request.getHeader("Authorization").split(" ");

        byte[] authDecode = Base64.getDecoder().decode(authorization[1]);

        String[] authString = new String(authDecode).split(":");

        String username = authString[0];
        String password = authString[1];

        


        // Passando a requsição para frente
        filterChain.doFilter(request, response);
    }
}
