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

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition testDefinition = new Definition("A common greeting among young friends in US cities.");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionInstantiatesWithAnID_1() {
    Definition.clear();
    Definition testDefinition = new Definition("A common greeting among young friends in US cities.");
    assertEquals(1, testDefinition.getId());
  }

}
