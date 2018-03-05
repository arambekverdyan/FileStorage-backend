package filestorage.config;

import java.util.Collections;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 * Created by aramb on Mar, 2018
 */
@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration {

  private final AppConfig appConfig;

  @Autowired
  public MongoDbConfig(AppConfig appConfig)
  {
    this.appConfig = appConfig;
  }

  @Override
  public String getDatabaseName()
  {
    return appConfig.getMongodbName();
  }

  @Override
  @Bean
  public Mongo mongo()
  {
    if (appConfig.getMongodbUserName() == null || appConfig.getMongodbUserName().isEmpty()) {
      return new MongoClient(Collections.singletonList(new ServerAddress(appConfig.getMongodbHost(), appConfig
          .getMongodbPort())));
    } else {
      MongoCredential userCredentials = MongoCredential.createCredential(appConfig.getMongodbUserName(), appConfig
          .getMongodbName(), appConfig
          .getMongodbPassword()
          .toCharArray());

      return new MongoClient(Collections.singletonList(new ServerAddress(appConfig.getMongodbHost(), appConfig
          .getMongodbPort())), Collections
          .singletonList(userCredentials));
    }
  }

  @Bean
  public MongoTemplate mongoTemplate()
  {
    MongoTemplate mongoTemplate = new MongoTemplate(mongo(), appConfig.getMongodbName());
    MappingMongoConverter mmc = (MappingMongoConverter) mongoTemplate.getConverter();
    mmc.setCustomConversions(customConversions());
    mmc.afterPropertiesSet();

    return mongoTemplate;
  }
}
