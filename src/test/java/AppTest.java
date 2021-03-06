import java.util.ArrayList;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Tamagotchi");
  }

  @Test
  public void nameIsCreated() {
    goTo("http://localhost:4567/");
    fill("#name").with("Dragon");
    submit(".btn");
    assertThat(pageSource()).contains("My pet name:");
  }

  @Test
  public void foodDescresesByOne() {
    goTo("http://localhost:4567/");
    fill("#name").with("Dragon");
    submit(".btn");
    click("#playButton");
    assertThat(pageSource()).contains("Food: 9");
  }
}
