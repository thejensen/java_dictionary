import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    Definition.clear();
  }

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("A common greeting among young friends in US cities.");
    assertEquals(true, testDefinition instanceof Definition);
  }
}
