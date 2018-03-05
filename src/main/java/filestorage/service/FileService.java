package filestorage.service;

import filestorage.repository.FileRepository;
import filestorage.type.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aramb on Mar, 2018
 */
@Service
public class FileService {
  private final FileRepository fileRepository;

  @Autowired
  public FileService(FileRepository fileRepository)
  {
    this.fileRepository = fileRepository;
  }

  public void addFile(File file)
  {
    fileRepository.save(file);
  }

  public File findById(String fileId)
  {
    return fileRepository.findById(fileId);
  }

  public int deleteById(String fileId)
  {
    return fileRepository.delete(fileId);
  }
}
