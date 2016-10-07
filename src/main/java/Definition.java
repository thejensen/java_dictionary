import java.util.List;
import java.util.ArrayList;

public class Definition {
  private String mDescription;
  private static List<Definition> instances = new ArrayList<Definition>();

  public Definition(String description){
    mDescription = description;
    instances.add(this);
  }

  public String getDefinition(){
    return mDescription;
  }

  public static List<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }
}
