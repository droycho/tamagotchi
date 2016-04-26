import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void Tamagotchi_instantiatesCorrectly_true() {
    Tamagotchi myTamagotchi = new Tamagotchi("Dragon");
    assertEquals(true, myTamagotchi instanceof Tamagotchi);
  }

  @Test
  public void Tamagotchi_instantiatesWithName_String() {
    Tamagotchi myTamagotchi = new Tamagotchi("Dragon");
    assertEquals("Dragon", myTamagotchi.getPetName());
  }

  @Test
  public void isAlive_foodLevelAbove0_true() {
    Tamagotchi myTamagotchi = new Tamagotchi("Dragon");
    assertEquals(true, myTamagotchi.isAlive());
  }
}
