package filestorage.repository;

import com.mongodb.WriteResult;
import filestorage.type.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

  public int delete(String fileId)
  {
    WriteResult writeResult = mongoTemplate.remove(Query.query(Criteria.where("id").is(fileId)), FILE_COLLECTION);

    return writeResult.getN();
  }
}
