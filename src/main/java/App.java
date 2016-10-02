import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = new Word(request.queryParams("word"));
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Definition anotherDefinition = new Definition(request.queryParams("anotherDefinition"));
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      word.addDefinition(anotherDefinition);
      model.put("word", word);
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

 }
}
