import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  // create a constructor that takes in a Queue of HTMLTags
  public HTMLManager(Queue<HTMLTag> html) {
      if (html == null) {
         throw new IllegalArgumentException();
      }
      tags = new LinkedList<HTMLTag>();
      // go through each tag and copy them
      for (HTMLTag tag : html) {
         tags.add(tag);
      }
   }
   
   public Queue<HTMLTag> getTags() {
         return tags;
   }
   
   public String toString() {
      String result = "";
      for (HTMLTag tag : tags) {
         result = result + tag.toString();
      }
      return result;
  }
  
  // fix missing or extra tags in queue
  public void fixHTML();
      Stack<HTMLTag> open = new Stack<HTMLTag>();
      int size = tags.size();
      
      for (int i = 0; i < size; i++) {
         HTMLTag tag = tags.remove();
         
         if (tag.isSelfClosing()) {
            tags.add(tag);
         } else if (tag.isOpening()) {
            tags.add(tag);
            open.push(tag);
         } else {
            while(!open.isEmpty() && !open.peek().matches(tag)) {
               tags.add(open.pop().getMatching());
            }
         }
         }
      }
       
}
