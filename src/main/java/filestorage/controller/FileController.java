package filestorage.controller;

import filestorage.service.FileService;
import filestorage.type.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aramb on Mar, 2018
 */
@RestController
@RequestMapping("api/file")
public class FileController {
  private FileService fileService;

  @Autowired
  public FileController(FileService fileService)
  {
    this.fileService = fileService;
  }

  @PostMapping()
  public void saveFile(@RequestBody File file)
  {
    fileService.addFile(file);
  }

  @GetMapping("/{fileId}")
  public File findById(@PathVariable String fileId)
  {
    return fileService.findById(fileId);
  }

  @DeleteMapping("/{fileId}")
  public int deleteById(@PathVariable String fileId)
  {
    return fileService.deleteById(fileId);
  }
}
