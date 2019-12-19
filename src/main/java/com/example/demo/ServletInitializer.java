package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet Initializer.
 * @author Cedrick Pennec
 */
public class ServletInitializer extends SpringBootServletInitializer {

  /**
 *@param application SpringApplicationBuilder
 *@return SpringApplicationBuilder
 */
@Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
    return application.sources(Onvageeker1Application.class);
  }
}
