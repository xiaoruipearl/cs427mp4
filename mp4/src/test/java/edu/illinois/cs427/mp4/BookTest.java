package edu.illinois.cs427.mp4;
import junit.framework.TestCase;

import junit.framework.TestCase;
import static junit.framework.Assert.assertEquals;

public class BookTest extends TestCase{
    public void testBookConstructor1() {
<<<<<<< HEAD
        Book book1 = new Book("hello", "world");
        assertEquals("hello", book1.getTitle());
        assertEquals("world", book1.getAuthor());
=======
      Book book1 = new Book("hello", "world");
      assertEquals("hello", book1.getTitle());
      assertEquals("world", book1.getAuthor());
>>>>>>> f0e5eb09df1430d9e293126366391e46e22141b6
    }

    public void testGetStringRepresentation1() {
        //TODO implement this
    }

    public void testGetContainingCollections1() {
        //TODO implement this
    }
}
