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

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String petName = request.queryParams("name");
      Tamagotchi newTamagotchi = new Tamagotchi(petName, 10, 0, 10);
      request.session().attribute("tamagotchi", newTamagotchi);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());



    post("/tamagotchi", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("tamagotchi", request.session().attribute("newTamagotchi"));
      //take tamagotchi out of session and then run methods on it
      Integer food = newTamagotchi.getFoodLevel();
      Integer newPetName = newTamagotchi.getPetName();
      Integer sleep = newTamagotchi.getSleepLevel();
      Integer activity = newTamagotchi.getActivityLevel();
      model.put("name", newPetName);
      model.put("food", food);
      model.put("sleep", sleep);
      model.put("activity", activity);

      String action = request.queryParams("action");
      if (action == "play") {
      model.put("food", newTamagotchi.downFoodLevel(food));
    }

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());



  }
}
