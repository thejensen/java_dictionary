import java.util.List;
import java.util.ArrayList;


public class Definition {
  private String mDefinition;
  private static List<Definition> instances = new ArrayList<Definition>();

  public Definition(String definition) {
    mDefinition = definition;
    instances.add(this);
  }

  public String getDefinition() {
    return mDefinition;
  }

  public static List<Definition> all() {
    return instances;
  }
}
