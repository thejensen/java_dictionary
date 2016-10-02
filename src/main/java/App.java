import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      // get / receives post requests from index.vtl, which is also our homepage that has a form where a user can enter a word and definition into a form. The post / request includes the data entered that must be posted(e.g. user-updated) so that it can be displayed here. No need to re-define the stuff in the get request that's defined grabbed in the post request.
      Map<String, Object> model = new HashMap<String, Object>();
      // the HashMap is sparky that we write every time in a get or post request to offer ourselves the ability to dynamically enter data from our application into our webpages. The "string" in the map is any rando word you want to use to call up in html, using $example-word notation.
      model.put("words", Word.all());
      // Here, we put "words" in the Map's "string", and "Word.all()" in for the Object, which Word.all() totes represents an Object. This way you can call $words in your html and velocity will be all, "HEY! I see you want the content of Words.all()" up in this piece, you got it!" Note: if you want to use FOREACH LOOPS on your .all() function, it's a good idea to make the "string" plural so you can use #foreach ($word in $words) in your html. Remember that $words will call your Word.all(), but the $word is #foreach loop notation that asks for individual objects stored in your class.
      model.put("template", "templates/index.vtl");
      // this is a standard thing! We have a layout.vtl file in which we will put $template in the body of a basic html layout page. This allows you to keep your code DRY, ...meaning in this case you don't have to declare your !DOCTYPE, call in bootstrap and css files, etc etc etc in every one of your html pages.
      return new ModelAndView(model, layout);
      // the f is ModelAndView? SPARKY! The return value of the get request is THIS: to your ModelAndView, the KEY: all the stuff from your HashMap (e.g. "words, Word.all(); template, templates/index.vtl"). The VALUE: the layout, or the standard html template.
    }, new VelocityTemplateEngine());
    // voila we instantiate a new VelocityTemplateEngine, which is what renders the html to THE INTERNETTT with the ModelAndView returning the contents of our get request. Hoo.

    post("/", (request, response) -> {
      // post / represents all the stuff the user can input into our form, that we're posting to the get /. The info's all on index.vtl aka the homepage.
      Map<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      // we're gathering input from our form, whose input name is "word", and storing it as a variable called word, which is supposed to be a string, so doth we declare!
      Word newWord = new Word(word);
      // Even though we so stored our form's input in a variable, we have to give it to our backend to do anything with it. So here, we startup a new variable that is part of the Word class (or Word newWord), that is a new Word(or instantiated object), in which we pass our word gathered from the form as an argument. It's like new Word() teleports our word to the backend. Poof, be stored and transformed little word!!!
      model.put("words", Word.all());
      // see above. I think you have to put this in the post request too? Honestly, I don't remember if this line is necessary...
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      // Integer.parseInt(request.params(":id")) is passed in as an argument for find, the :id is spark notation that allows the server to use the object's unique id to locate the object, and render the page containing its details. The links is being dynamically created in the velocity loop in the index.vtl template which links to word.getId().

      //request.params(":id") is sparky notation that grabs from "get("/word/:id"), which is dynamically generated in index.vtl as word.getId(). Tricky, right? So the argument passed in the find function to poop out the object we're looking for is generated from index.vtl! Buuut, the :id is always a string somehow, so we need to use Integer.parseInt() to convert it to an int. The webs we weave.
      model.put("word", word);
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/word/:id", (request, response) -> {
      // please don't forget to include the form action and method in your form tag, ok?
      Map<String, Object> model = new HashMap<String, Object>();
      Definition definition = new Definition(request.queryParams("anotherDefinition"));
      // definition grabs the input for "anotherDefinition".
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      // this locates the object via its unique id, not sure that it's necessary for the post request? but I need the word to act on in the front end, so yes, it's necessary here.
      word.setDefinition(definition);
      // here, supposedly we're passing the definition we made a definition object into the setDefinition function which takes Definitions and puts them into an arraylist.
      model.put("word", word);
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

 }
}
