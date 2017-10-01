package edu.illinois.cs427.mp4;
import java.util.List;
import java.io.IOException;
import java.lang.RuntimeException;
import org.junit.*;
import static junit.framework.Assert.*;

public class LibraryTest {
    public void testLibraryConstructorFromFile1() {
        //TODO implement this
    }

    @Test
    public void testSaveLibraryToFile1() throws IOException{
        Collection coll1 = new Collection("coll1");
        coll1.addElement(new Book("book1", "author1"));
        coll1.addElement(new Book("book2", "author2"));
        Collection subcoll1 = new Collection("subcoll1");
        subcoll1.addElement(new Book("book3", "author3"));
        subcoll1.addElement(new Book("book4", "author4"));
        coll1.addElement(subcoll1);

        Collection coll2 = new Collection("coll2");
        coll1.addElement(new Book("book5", "author5"));
        Collection subcoll2 = new Collection("subcoll2");
        subcoll2.addElement(new Book("book6", "author6"));
        subcoll2.addElement(new Book("book7", "author7"));
        coll2.addElement(subcoll2);
        coll2.addElement(new Book("book8", "author8"));
        Collection subcoll3 = new Collection("subcoll3");
        coll2.addElement(subcoll3);
        subcoll3.addElement(new Book("book9", "author9"));

        Library lib = new Library();
        List<Collection> collections = lib.getCollections();
        collections.add(coll1);
        collections.add(coll2);
        lib.saveLibraryToFile("testSaveLibraryToFile1.txt");
    }
}
