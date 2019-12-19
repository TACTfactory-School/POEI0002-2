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

/**
 * Configuration file of Oauth2.
 * @author Cheikh Ejeyed
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

  /**
 * Validity duration of token in seconds. 50 000 by default.
 */
@Value("${token.validity:50000}")
  int tokenValidity;

  /**
 * Validity duration of refreshed token in seconds. 25 000 by default.
 */
@Value("${token.refresh.validity:25000}")
  int tokenRefreshValidity;

  /**
 * SigningKey.
 */
@Value("${security.signing-key}")
  private String signingKey;

  /**
 * Id of client.
 */
@Value("${security.jwt.client-id}")
  private String clientId;

  /**
 * ClientSecret.
 */
@Value("${security.jwt.client-secret}")
  private String clientSecret;

  /**
 * GrantType.
 */
@Value("${security.jwt.grant-type}")
  private String grantType;

  /**
 * scopeRead
 */
@Value("${security.jwt.scope-read}")
  private String scopeRead;

  /**
 * scopeWrite
 */
@Value("${security.jwt.scope-write}")
  private String scopeWrite = "write";

  /**
 * resourceIds
 */
@Value("${security.jwt.resource-ids}")
  private String resourceIds;


  /**
 * accessTokenConverter
 */
@Autowired
  private JwtAccessTokenConverter accessTokenConverter;

  /**
 * authenticationManager
 */
@Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;

  /**
 * userDetailsService
 */
@Autowired
  private UserDetailsService userDetailsService;

  /**
 * @return instance of NoOpPasswordEncoder
 */
@SuppressWarnings("deprecation")
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }

  /**
 * @return converter JwtAccessTokenConverter
 */
@Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey(signingKey);
    return converter;
  }

  /**
 * @return JwtTokenStore
 */
@Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(accessTokenConverter());
  }

  /**
 * @return defaultTokenServices DefaultTokenServices
 */
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

  /**
   * configurer configuration.
 * @param configurer ClientDetailsServiceConfigurer
 */
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

  /**
 * @param security AuthorizationServerSecurityConfigurer
 */
@Override
  public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  /**
 *@param endpoints AuthorizationServerEndpointsConfigurer
 */
@Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
    endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter)
      .tokenEnhancer(enhancerChain)
      .authenticationManager(authenticationManager).userDetailsService(userDetailsService)
      .reuseRefreshTokens(false);
  }
}
