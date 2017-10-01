package edu.illinois.cs427.mp4;

import junit.framework.TestCase;
import static junit.framework.Assert.assertEquals;

public class CollectionTest extends TestCase{
    public void testRestoreCollection1() {
        Collection coll = new Collection("wiki");
        Element book1 = new Book("hi","you");
        Element book2 = new Book("hi again","rachel");
        Element subCol = new Collection("sub");
        coll.addElement(book1);
        coll.addElement(book2);
        coll.addElement(subCol);
        Collection restored = Collection.restoreCollection(coll.getStringRepresentation());
        assertEquals(coll.getElements(), restored.getElements());
        assertEquals(coll.getName(), restored.getName());
    }

    public void testGetStringRepresentation1() {
        //TODO implement this
    }

    public void testAddElement1() {
        //TODO implement this
    }

    public void testDeleteElement1() {
        //TODO implement this
    }
}
