import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  // create a constructor that takes in a Queue of HTMLTags
  public HTMLManager(Queue<HTMLTag> html) {
      if (html == null) {
         throw new IllegalArgumentException();
      }
      page = new LinkedList<HTMLTag>();
      // go through each tag and copy them
      for (HTMLTag tag : html) {
         page.add(tag);
      }
   }
       
}
