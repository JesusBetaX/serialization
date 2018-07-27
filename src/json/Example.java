package json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Example {

  @SerializedName("text")
  private String text;

  @SerializedName("index")
  private int index;

  public Example() {
    super();
  }

  public Example(String text, int index) {
    this.text = text;
    this.index = index;
  }

  public String getMessage() {
    return text;
  }

  public int getId() {
    return index;
  }
  
  public static void main(String[] args) throws Exception {
    {
      // Serializing a simple object
      Gson gson = new Gson();
      Example example = new Example("Example message", 123);
      File result = new File("example.json");
      FileWriter writer = new FileWriter(result);
      gson.toJson(example, writer);
      writer.close();
    }

    {
      // Deserializing a simple object
      Gson gson = new Gson();
      File source = new File("example.json");
      JsonReader reader = new JsonReader(new FileReader(source));
      
      Example example = gson.fromJson(reader, Example.class);
      System.out.println(example.text);
    }
  }
}
