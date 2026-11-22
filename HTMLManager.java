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
      
      for (HTMLTag tag : tags) {
         result = result + tag.toString().trim();
      }
         //int size = tags.size();
         //the for loop go through all the element in the queue
         //for(int i = 0; i < size; i++) {
         //HTMLTag tag = tags.remove();
         //use trim() to remove extra space
         //result += tag.toString().trim();
         //add the element back to the riginal queue
         //tags.add(tag);
         //}
         
      return result;

 }
 
 // fix missing or extra tags in queue
  public void fixHTML() {
   //using a stack to keep track of opening tags that haven't been closed
      Stack<HTMLTag> open = new Stack<HTMLTag>();
      int size = tags.size();
      
      //check each tages in order
      for (int i = 0; i < size; i++) {
         HTMLTag tag = tags.remove();
         //self-closing tags don't need a matching tag
         if (tag.isSelfClosing()) {
            tags.add(tag);
         //opening tag: add to queue and remember in the stack
         } else if (tag.isOpening()) {
            tags.add(tag);
            open.push(tag);
         //closing tags
         } else {
            //close any tags that don't match this closing tag
            while(!open.isEmpty() && !open.peek().matches(tag)) {
               tags.add(open.pop().getMatching());
            }
            //if a matching opning tag is found, keep this closing tag
            if (!open.isEmpty()) {
               tags.add(tag);
               open.pop();
            }
         }
         }
         //if the stack is empty, this closing tag is extra, so we toss it
         
         //close any opening tags that were never closed
         while (!open.isEmpty()) {
            tags.add(open.pop().getMatching());
         }
      }
}