package filestorage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by aramb on Mar, 2018
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "filestorage")
public class AppConfig {

  // Server
  private String baseUrl;

  // MongoDB properties
  private String mongodbHost;
  private Integer mongodbPort;
  private String mongodbName;
  private String mongodbUserName;
  private String mongodbPassword;


  public String getBaseUrl()
  {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl)
  {
    this.baseUrl = baseUrl;
  }

  public String getMongodbHost()
  {
    return mongodbHost;
  }

  public void setMongodbHost(String mongodbHost)
  {
    this.mongodbHost = mongodbHost;
  }

  public Integer getMongodbPort()
  {
    return mongodbPort;
  }

  public void setMongodbPort(Integer mongodbPort)
  {
    this.mongodbPort = mongodbPort;
  }

  public String getMongodbName()
  {
    return mongodbName;
  }

  public void setMongodbName(String mongodbName)
  {
    this.mongodbName = mongodbName;
  }

  public String getMongodbUserName()
  {
    return mongodbUserName;
  }

  public void setMongodbUserName(String mongodbUserName)
  {
    this.mongodbUserName = mongodbUserName;
  }

  public String getMongodbPassword()
  {
    return mongodbPassword;
  }

  public void setMongodbPassword(String mongodbPassword)
  {
    this.mongodbPassword = mongodbPassword;
  }
}
