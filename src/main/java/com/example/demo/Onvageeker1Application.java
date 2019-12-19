package com.example.demo;

import com.example.demo.services.fixtures.FixtureService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableResourceServer
public class Onvageeker1Application implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(Onvageeker1Application.class);

  @Autowired(required = false)
  private FixtureService fixtures;

  public static void main(final String[] args) {
    SpringApplication.run(Onvageeker1Application.class, args);
  }

  @Bean
  public ModelMapper buildMapper() {
    return new ModelMapper();
  }

  @Override
  public void run(final String... args) throws Exception {
    if (this.fixtures != null) {
      LOGGER.debug("Fixtures loading...");

      this.fixtures.load();

      LOGGER.debug("Fixtures loaded");
    }
  }
}
