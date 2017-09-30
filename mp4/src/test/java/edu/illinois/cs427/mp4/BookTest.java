package edu.illinois.cs427.mp4;
import junit.framework.TestCase;

import junit.framework.TestCase;
import static junit.framework.Assert.assertEquals;

public class BookTest extends TestCase{
    public void testBookConstructor1() {
      Book book1 = new Book("hello", "world");
      assertEquals("hello", book1.getTitle());
      assertEquals("world", book1.getAuthor());
    }

    public void testBookConstructor2() {
      Book book2 = new Book("{\"title\":\"bo, ok2\",\"author(s)\":\"pe, arl\"}");
      assertEquals("bo, ok2", book2.getTitle());
      assertEquals("pe, arl", book2.getAuthor());
    }
    public void testGetStringRepresentation1() {
        Book book1 = new Book("hello", "world");
        assertEquals("{\"title\":\"hello\",\"author(s)\":\"world\"}",book1.getStringRepresentation());
    }

    public void testGetContainingCollections1() {
        //TODO implement this
    }
}
