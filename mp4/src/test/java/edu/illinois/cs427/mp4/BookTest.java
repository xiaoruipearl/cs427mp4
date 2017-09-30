package edu.illinois.cs427.mp4;

import junit.framework.TestCase;
import static junit.framework.Assert.assertEquals;

public class BookTest extends TestCase{
    public void testBookConstructor1() {
        Book book1 = new Book("hello", "world");
        assertEquals("hello", book1.getTitle());
        assertEquals("world", book1.getAuthor());
    }

    public void testGetStringRepresentation1() {
        //TODO implement this
    }

    public void testGetContainingCollections1() {
        //TODO implement this
    }
}
