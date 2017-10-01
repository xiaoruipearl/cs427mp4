package edu.illinois.cs427.mp4;

import junit.framework.TestCase;
import static junit.framework.Assert.*;

public class CollectionTest extends TestCase{
    public void testRestoreCollection1() {
        // Collection coll = new Collection("wiki");
        // Element book1 = new Book("hi","you");
        // Element book2 = new Book("hi again","rachel");
        // Element subCol = new Collection("sub");
        // coll.addElement(book1);
        // coll.addElement(book2);
        // coll.addElement(subCol);
        // Collection restored = Collection.restoreCollection(coll.getStringRepresentation());
        // assertEquals(coll.getElements(), restored.getElements());
        // assertEquals(coll.getName(), restored.getName());
    }

    public void testGetStringRepresentation1() {
      Collection coll = new Collection("wiki");
      Book book1 = new Book("hi","you");
      Book book2 = new Book("hi again","rachel");
      Collection subCol = new Collection("sub");
      coll.addElement(book1);
      coll.addElement(book2);
      coll.addElement(subCol);
      assertEquals("", coll.getStringRepresentation());
    }

    public void testAddElement1() {
      Collection coll = new Collection("wiki");
      Book book1 = new Book("hi","you");
      Collection subCol = new Collection("sub");
      assertTrue(coll.addElement(book1));
      assertTrue(coll.addElement(subCol));
    }

    public void testDeleteElement1() {
      Collection coll = new Collection("wiki");
      Book book1 = new Book("hi","you");
      Collection subCol = new Collection("sub");
      coll.addElement(book1);
      coll.addElement(subCol);
      assertTrue(coll.deleteElement(book1));
      assertTrue(!coll.deleteElement(book1));
      assertTrue(coll.deleteElement(subCol));
      assertTrue(!coll.deleteElement(subCol));
    }
}
