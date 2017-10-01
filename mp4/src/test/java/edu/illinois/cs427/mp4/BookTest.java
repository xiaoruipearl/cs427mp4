package edu.illinois.cs427.mp4;

import junit.framework.TestCase;
import static junit.framework.Assert.assertEquals;

public class BookTest extends TestCase{
    public void testBookConstructor1() {
      Book book1 = new Book("hello", "world");
      assertEquals("hello", book1.getTitle());
      assertEquals("world", book1.getAuthor());
    }

    public void testBookConstructor2() {
      Book book2 = new Book("helloworld", "pearl");
      Book book3 = new Book(book2.getStringRepresentation());
        assertEquals("helloworld", book3.getTitle());
        assertEquals("pearl", book3.getAuthor());
    }

    public void testGetStringRepresentation1() {
        Book book1 = new Book("hello", "world");
        assertEquals("{\"title\":\"hello\",\"author\":\"world\"}",book1.getStringRepresentation());
    }

    public void testGetContainingCollections1() {
        //TODO implement this
    }
}
