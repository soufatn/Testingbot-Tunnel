package com.testingbot.tunnel.proxy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.proxy.ConnectHandler;

/**
 *
 * @author TestingBot
 */
public class CustomConnectHandler extends ConnectHandler {
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        if (method.equalsIgnoreCase("CONNECT")) {
            Logger.getLogger(CustomConnectHandler.class.getName()).log(Level.INFO, "<< [{0}] {1}", new Object[]{method, request.getRequestURL().toString()});
        }
        
        super.handle(target, baseRequest, request, response);
    }
}
