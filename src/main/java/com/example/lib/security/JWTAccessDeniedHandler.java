package com.example.lib.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAccessDeniedHandler implements AccessDeniedHandler { //yetkimiz olmayan bir yere gitmek istediğimizde sadece 403 dönmek yerine bizim custom mesajımızı dönsün

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        // TODO FRONTEND SHOULD HANDLE THIS -> ERROR PAGE
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getOutputStream().println("{ \"error\": \"" + accessDeniedException.getMessage() + "\" }");  //json dönmek için.
    }
}
