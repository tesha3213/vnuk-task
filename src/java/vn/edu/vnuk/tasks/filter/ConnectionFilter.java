/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vnuk.tasks.filter;

/**
 *
 * @author Admin
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import vn.edu.vnuk.tasks.jdbc.ConnectionFactory;
@WebFilter("/*")
public class ConnectionFilter implements Filter {
     @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        try {
            Connection connection = new ConnectionFactory().getConnection();

            request.setAttribute("myConnection", connection);
            chain.doFilter(request, response);
            connection.close();
        } 
        
        catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
    }
    
}
