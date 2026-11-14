import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
//the constructor takes in a Queue of HTMLTags that make up an HTML page
  HTMLManager(Quene<HTMLTag> html) {
  //if the Queue passed is null, the constructor throws an IllegalArgumentException
   if(html == null) {
      throw new IllegalArgumentExpecption();
   }
   //store the passed information in its Queue field
   tags = new LinkedList<HTMLTag>();
   
   int size = html.size();
   //copy all the values into a new (queue) field
   for(int = 0; i < size; i++) {
      //remove all from the original queue
      HTMLTag tag = html.remove();
      
      //add them back to the queue(back to original order)
      tags.add(tag);
      tags.add(tag);
   }
 }
}