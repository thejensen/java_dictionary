import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mName;
  private static List<Word> instances = new ArrayList<Word>();
  private List<Definition> mDefinitions;
  private int mId;

  public Word(String name) {
    mName = name;
    instances.add(this);
    mDefinitions = new ArrayList<Definition>();
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public static List<Word> all() {
    return instances;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public List<Definition> getDefinition() {
    return mDefinitions;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
    return instances.get(id-1);
  }
}
