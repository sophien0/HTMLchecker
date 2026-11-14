import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
//the constructor takes in a Queue of HTMLTags that make up an HTML page
  public HTMLManager(Queue<HTMLTag> html) {
  //if the Queue passed is null, the constructor throws an IllegalArgumentException
   if(html == null) {
      throw new IllegalArgumentException();
   }
   //store the passed information in its Queue field
   tags = new LinkedList<HTMLTag>();
   
   int size = html.size();
   //copy all the values into a new (queue) field
   for(int i = 0; i < size; i++) {
      //remove all from the original queue
      HTMLTag tag = html.remove();
      
      //add them back to the queue(back to original order)
      tags.add(tag);
      tags.add(tag);
   }
 }
 //Returns the queue of HTMLTags being managed
 public Queue<HTMLTag> getTags() {
      return tags;
   }
 //create a toSting method  
 public String toString() {
      String result = "";
      
      int size = tags.size();
         
         //the for loop go through all the element in the queue
         for(int i = 0; i < size; i++) {
         HTMLTag tag = tags.remove();
         //use trim() to remove extra space
         result += tag.toString().trim();
         //add the element back to the riginal queue
         tags.add(tag);
         }
         
      return result;

 }
}