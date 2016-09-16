import java.util.List;
import java.util.ArrayList;

public class Definition {
  private String mDefinition;
  private static List<Definition> instances = new ArrayList<Definition>();
  private int mId;

  public Definition(String definition) {
    mDefinition = definition;
    instances.add(this);
    mId = instances.size();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public static List<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Definition find(int id) {
    return instances.get(id-1);
  }
}
