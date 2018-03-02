package filestorage.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aramb on Mar, 2018
 */
public class File {
  private String id;
  private String name;
  private Map<String, String> content = new HashMap<>();

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Map<String, String> getContent()
  {
    return content;
  }

  public void setContent(Map<String, String> content)
  {
    this.content = content;
  }
}
