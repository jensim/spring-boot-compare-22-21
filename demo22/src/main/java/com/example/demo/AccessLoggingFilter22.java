package com.example.demo;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AccessLoggingFilter22 extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessLoggingFilter22.class);

    public AccessLoggingFilter22() {
        logger.info("AccessLoggingFilter active");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        long startTimeNanos = System.nanoTime();
        try {
            filterChain.doFilter(request, response);
        } finally {
            double elapsedTimeMillis = (System.nanoTime() - startTimeNanos) / 1_000_000d;

            int httpStatus = response.getStatus();
            String httpUri = request.getRequestURI();
            logger.trace("Request uri {} got status {} and took {}ms", httpUri, httpStatus, elapsedTimeMillis);
        }
    }
}
