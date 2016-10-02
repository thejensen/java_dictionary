import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
  }

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Yo");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void all_returnsAllWords_true() {
    Word firstTestWord = new Word("Yo");
    Word secondTestWord = new Word("Winning");
    assertEquals(true, Word.all().contains(firstTestWord));
    assertEquals(true, Word.all().contains(secondTestWord));
  }

  @Test
  public void getDefinitions_returnsAllDefinitions_ArrayList() {
    Word testWord = new Word("Yo");
    Definition testDefinition = new Definition("A colloquial greeting among friends in US cities.");
    Definition secondTestDefinition = new Definition("Sometimes it means just Hi and a response isn't necessary, so.");
    testWord.addDefinition(testDefinition);
    testWord.addDefinition(secondTestDefinition);
    assertEquals(true, testWord.getDefinitions().contains(testDefinition));
    assertEquals(true, testWord.getDefinitions().contains(secondTestDefinition));
  }

  @Test
  public void getId_wordInstantiatesWithAnID_1() {
    Word.clear();
    Word testWord = new Word("Yo");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Word firstTestWord = new Word("Yo");
    Word secondTestWord = new Word("Winning");
    assertEquals(Word.find(secondTestWord.getId()), secondTestWord);
  }

  @Test public void getName_returnsNameOfWord_String() {
    Word testWord = new Word("Yo");
    assertEquals("Yo", testWord.getName());
  }


}
