import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    post("/tamagotchi", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String petName = request.queryParams("name");

      Tamagotchi newTamagotchi = new Tamagotchi(petName, 10, 0, 10);
      model.put("name", petName);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }
  //
  // public static String methodName(String inputVar) {}

}
