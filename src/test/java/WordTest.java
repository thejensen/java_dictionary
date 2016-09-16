import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Yo");
    assertEquals(true, testWord instanceof Word);
  }
}
