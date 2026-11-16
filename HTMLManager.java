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
         result = result + tag.toString().trim();
      }
      return result;
  }
  
  // fix missing or extra tags in queue
  public void fixHTML() {
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
            if (!open.isEmpty()) {
               tags.add(tag);
               open.pop();
            }
         }
         }
         
         while (!open.isEmpty()) {
            tags.add(open.pop().getMatching());
         }
      }
}

/* Output:

 ----jGRASP exec: java HTMLChecker
===============================
Processing tests/test1.html...
===============================
HTML: <b><i><br /></b></i>
Checking HTML for errors...
HTML after fix: <b><i><br /></i></b>
----> Result matches Expected Output!

===============================
Processing tests/test2.html...
===============================
HTML: <a><a><a></a>
Checking HTML for errors...
HTML after fix: <a><a><a></a></a></a>
----> Result matches Expected Output!

===============================
Processing tests/test3.html...
===============================
HTML: <br /></p></p>
Checking HTML for errors...
HTML after fix: <br />
----> Result matches Expected Output!

===============================
Processing tests/test4.html...
===============================
HTML: <div><div><ul><li></li><li></li><li></ul></div>
Checking HTML for errors...
HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
----> Result matches Expected Output!

===============================
Processing tests/test5.html...
===============================
HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
Checking HTML for errors...
HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
----> Result matches Expected Output!

===============================
        All tests passed!
===============================

 ----jGRASP: Operation complete.
*/