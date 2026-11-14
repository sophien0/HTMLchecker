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

}
}