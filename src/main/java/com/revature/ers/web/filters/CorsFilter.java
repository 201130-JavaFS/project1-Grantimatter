package com.revature.ers.web.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {
    static Logger log = LogManager.getLogger(CorsFilter.class);
    /*
     * The idea of a Filter, is that before the request is delegated to a Servlet,
     * it must first pass through any and all filters
     * These filters can manipulate the request/response as needed
     *
     * In this particular case, we will be adding certain headers required to allow Cross
     * Origin requests
     *
     * However, we can have filters to detect certain requests, and perhaps deny them
     * before they even reach a Servlet
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        log.info("CORS Filter leveraged");

        if(!(response instanceof HttpServletResponse)) {
            chain.doFilter(request, response);
            return;
        }

        // Cast the response as an HttpServletResponse
        // Which is important, because we are going to set
        // headers, which is specific to HTTP
        HttpServletResponse res = (HttpServletResponse) response;

        // Use for deployment
        res.setHeader("Access-Control-Allow-Origin", "http://javafs-ers.s3.us-east-2.amazonaws.com"); // Allow S3 Bucket connection
        // Use for local
        //res.setHeader("Access-Control-Allow-Origin", "null"); // Allow any connection

        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        // Allow specific HTTP Verbs

        res.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,"
                + "Access-Control-Request-Method, Access-Control-Request-Headers");
        // Allow specific HTTP Headers (there's a fair few)

        res.setHeader("Access-Control-Allow-Credentials", "true");
        // Credentials are allowed

        chain.doFilter(request, response);
        // Continue the filter chain
    }
}
