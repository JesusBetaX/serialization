package xml;

import java.io.File;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root
public class Example {

  @Element
  private String text;

  @Attribute
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
      Serializer serializer = new Persister();
      Example example = new Example("Example message", 123);
      File result = new File("example.xml");

      serializer.write(example, result);
    }

    {
      // Deserializing a simple object
      Serializer serializer = new Persister();
      File source = new File("example.xml");

      Example example = serializer.read(Example.class, source);
      System.out.println(example.text);
    }
  }
}
