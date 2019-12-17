package com.example.demo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

  @Value("${token.validity:50000}")
  int tokenValidity;

  @Value("${token.refresh.validity:25000}")
  int tokenRefreshValidity;

  @Value("${security.signing-key}")
  private String signingKey;

  @Value("${security.jwt.client-id}")
  private String clientId;

  @Value("${security.jwt.client-secret}")
  private String clientSecret;

  @Value("${security.jwt.grant-type}")
  private String grantType;

  @Value("${security.jwt.scope-read}")
  private String scopeRead;

  @Value("${security.jwt.scope-write}")
  private String scopeWrite = "write";

  @Value("${security.jwt.resource-ids}")
  private String resourceIds;


  @Autowired
  private JwtAccessTokenConverter accessTokenConverter;

  @Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @SuppressWarnings("deprecation")
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey(signingKey);
    return converter;
  }

  @Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(accessTokenConverter());
  }

  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    defaultTokenServices.setReuseRefreshToken(false);
    defaultTokenServices.setAccessTokenValiditySeconds(this.tokenValidity);
    defaultTokenServices.setRefreshTokenValiditySeconds(this.tokenRefreshValidity);
    return defaultTokenServices;
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer configurer) throws Exception {
    configurer
    .inMemory()
    .withClient(clientId)
    .secret(passwordEncoder().encode(clientSecret))
    .authorizedGrantTypes(grantType, "authorization_code", "refresh_token", "client_credentials")
    .scopes(scopeRead, scopeWrite)
    .accessTokenValiditySeconds(tokenValidity)
    .refreshTokenValiditySeconds(tokenRefreshValidity);
  }

  @Override
  public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
    endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter).tokenEnhancer(enhancerChain)
    .authenticationManager(authenticationManager).userDetailsService(userDetailsService)
    .reuseRefreshTokens(false);
  }
}
