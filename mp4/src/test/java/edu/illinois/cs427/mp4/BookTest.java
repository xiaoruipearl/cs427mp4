package edu.illinois.cs427.mp4;

import java.util.List;
import org.junit.*;
import static junit.framework.Assert.*;

public class BookTest{

    @Test
    public void testBookConstructor1() {
        Book book1 = new Book("hello", "world");
        assertEquals("hello", book1.getTitle());
        assertEquals("world", book1.getAuthor());
    }

    @Test
    public void testBookConstructor2() {
        Book book2 = new Book("helloworld", "pearl");
        Book book3 = new Book(book2.getStringRepresentation());
        assertEquals("helloworld", book3.getTitle());
        assertEquals("pearl", book3.getAuthor());
    }

    @Test
    public void testGetStringRepresentation1() {
        Book book1 = new Book("hello", "world");
        assertEquals("{\"title\":\"hello\",\"author\":\"world\"}",book1.getStringRepresentation());
    }

    @Test
    public void testGetContainingCollections1() {
        Book book1 = new Book("hello", "world");
        Collection coll = new Collection("coll");
        coll.addElement(book1);
        Collection collP = new Collection("collP");
        collP.addElement(coll);
        List<Collection> parents = book1.getContainingCollections();
        assertEquals(coll, parents.get(0));
        assertEquals(collP, parents.get(1));
    }

    @Test
    public void testGetContainingCollections2() {
        Book book1 = new Book("hello", "world");
        List<Collection> parents = book1.getContainingCollections();
        assertEquals(0, parents.size());
    }
}
