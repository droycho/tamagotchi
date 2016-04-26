import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void Tamagotchi_instantiatesCorrectly_true() {
    Tamagotchi myTamagotchi = new Tamagotchi("Dragon", 10, 0, 10);
    assertEquals(true, myTamagotchi instanceof Tamagotchi);
  }

  @Test
  public void Tamagotchi_instantiatesWithName_String() {
    Tamagotchi myTamagotchi = new Tamagotchi("Dragon", 10, 0, 10);
    assertEquals("Dragon", myTamagotchi.getPetName());
  }

  @Test
  public void isAlive_foodLevelAbove0_String() {
    Tamagotchi myTamagotchi = new Tamagotchi("Dragon", 10, 0, 10);
    assertEquals("Dragon is alive.", myTamagotchi.isAlive());
  }

}
