//package filestorage.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * Created by aramb on Mar, 2018
// */
//
//@SuppressWarnings("SpringJavaAutowiringInspection")
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  private final AppConfig appConfig;
//  private final AccessTokenAuthenticationProvider accessTokenAuthenticationProvider;
//  private final AuthenticationEntryPoint restAuthenticationEntryPoint;
//
//  @Autowired
//  public SecurityConfig(AuthenticationEntryPoint restAuthenticationEntryPoint, AppConfig appConfig,
//      AccessTokenAuthenticationProvider accessTokenAuthenticationProvider) {
//    this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
//    this.appConfig = appConfig;
//    this.accessTokenAuthenticationProvider = accessTokenAuthenticationProvider;
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.addFilterAfter(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//    http.httpBasic()
//        .disable()
//        .formLogin()
//        .disable()
//        .x509()
//        .disable()
//        .jee()
//        .disable()
//        .csrf()
//        .disable()
//        .logout()
//        .disable()
//        .rememberMe()
//        .disable();
//
//    http.exceptionHandling()
//        .authenticationEntryPoint(restAuthenticationEntryPoint)
//        .and()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//    http.authorizeRequests()
//        //Swagger
//        .antMatchers("/v2/api-docs")
//        .permitAll()
//        .antMatchers("/api-docs")
//        .permitAll()
//        .antMatchers("/webjars/springfox-swagger-ui/**")
//        .permitAll()
//        .antMatchers("/swagger-resources/**")
//        .permitAll()
//        .antMatchers("/swagger-ui.html")
//        .permitAll()
//
//        .antMatchers(appConfig.getBaseUrl() + "/test/**")
//        .permitAll()
//
//        .antMatchers(HttpMethod.POST, appConfig.getBaseUrl() + "/users")
//        .permitAll()
//
//        .antMatchers(HttpMethod.POST, appConfig.getBaseUrl() + "/token")
//        .permitAll()
//
//        .antMatchers(HttpMethod.PATCH, appConfig.getBaseUrl() + "/token")
//        .permitAll()
//
//        .antMatchers(appConfig.getBaseUrl() + "/**")
//        .hasRole(Constants.ROLE_USER)
//
//        .antMatchers("/**")
//        .denyAll();
//    //        .permitAll();
//
//    http.csrf().disable();
//  }
//
//  @Bean
//  public AuthenticationManager authenticationManager() {
//    List<AuthenticationProvider> providers = new ArrayList<>();
//    providers.add(accessTokenAuthenticationProvider);
//    return new ProviderManager(providers);
//  }
//
//  @Bean
//  public TokenAuthenticationFilter tokenAuthenticationFilter() {
//    return new TokenAuthenticationFilter(authenticationManager());
//  }
//}
//
