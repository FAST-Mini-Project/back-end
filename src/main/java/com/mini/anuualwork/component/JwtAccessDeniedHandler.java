package com.mini.anuualwork.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.anuualwork.core.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,

            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ApiErrorResponse errorResponse = new ApiErrorResponse(new String[]{"접근 권한이 없습니다."});
        String jsonResponseData = mapper.writeValueAsString(errorResponse);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(jsonResponseData);
    }
}