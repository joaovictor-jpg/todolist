package br.com.joaovictor.todolist.filters;

import br.com.joaovictor.todolist.Helpers.Bcrypt;
import br.com.joaovictor.todolist.model.Repository.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Pegar a autenticação (usuario e senha)
        String[] authorization = request.getHeader("Authorization").split(" ");
        byte[] authDecode = Base64.getDecoder().decode(authorization[1]);
        String[] authString = new String(authDecode).split(":");
        String username = authString[0];
        String password = authString[1];

        // Validar usuario e senha
        var user = this.userRepository.findByUserName(username);
        if(user == null) {
            response.sendError(401);
        } else {
            var isTrue = Bcrypt.description(password, user);
            if(isTrue) {
                // Passando a requsição para frente
                filterChain.doFilter(request, response);
            } else {
                response.sendError(401);
            }
        }
    }
}
