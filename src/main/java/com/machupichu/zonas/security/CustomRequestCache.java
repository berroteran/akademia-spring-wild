package com.machupichu.zonas.security;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta clase es para hacer el redirect a la ultima pagina utilizada al iniciar sessino.
 */
public class CustomRequestCache extends HttpSessionRequestCache {
    @Override
    public void saveRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //System.out.println("Saving request to " + httpServletRequest.getRequestURI());
        super.saveRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    public HttpServletRequest getMatchingRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //System.out.println("Returning request for " + httpServletRequest.getRequestURI());
        return super.getMatchingRequest(httpServletRequest, httpServletResponse);
    }
}
