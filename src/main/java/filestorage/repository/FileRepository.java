package filestorage.repository;

import filestorage.type.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by aramb on Mar, 2018
 */
@Repository
public class FileRepository {
  private final MongoTemplate mongoTemplate;

  @Autowired
  public FileRepository(MongoTemplate mongoTemplate)
  {
    this.mongoTemplate = mongoTemplate;
  }

  private final String FILE_COLLECTION = "Files";

  public void save(File file)
  {
    mongoTemplate.save(file, FILE_COLLECTION);
  }

  public File findById(String fileId)
  {
    return mongoTemplate.findById(fileId, File.class, FILE_COLLECTION);
  }
}
