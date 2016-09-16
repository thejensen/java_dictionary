import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mWord;
  private static List<Word> instances = new ArrayList<Word>();
  private List<Definition> mDefinitions;
  private int mId;

  public Word(String word) {
    mWord = word;
    instances.add(this);
    mDefinitions = new ArrayList<Definition>();
    mId = instances.size();
  }

  public String getWord() {
    return mWord;
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

}
