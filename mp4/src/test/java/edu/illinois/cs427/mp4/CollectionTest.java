package edu.illinois.cs427.mp4;

import junit.framework.TestCase;

import java.util.List;

import static junit.framework.Assert.*;

public class CollectionTest extends TestCase{
    public void testRestoreCollection1() {
        Collection coll = new Collection("wiki");
        coll.addElement(new Book("hi","you"));
        coll.addElement(new Book("hi again","rachel"));
        Collection subcoll = new Collection("sub");
        subcoll.addElement(new Book("how are you?", "pearl"));
        coll.addElement(subcoll);
        Collection restored = Collection.restoreCollection(coll.getStringRepresentation());
        assertEquals(coll.getName(), restored.getName());
        List<Element> collElems = coll.getElements();
        List<Element> restoredElems = restored.getElements();
        for (int i = 0; i < collElems.size(); i++){
            if(collElems.get(i) instanceof Book)
                assertEquals(((Book) collElems.get(i)).getTitle(), ((Book) restoredElems.get(i)).getTitle());
            else
                assertEquals(((Collection) collElems.get(i)).getName(), ((Collection) restoredElems.get(i)).getName());
        }
    }

    public void testGetStringRepresentation1() {
        Collection coll = new Collection("wiki");
        coll.addElement(new Book("hi","you"));
        coll.addElement(new Book("hi again","rachel"));
        Collection subcoll = new Collection("sub");
        subcoll.addElement(new Book("how are you?", "pearl"));
        coll.addElement(subcoll);
        assertEquals("{\"elements\":[{\"title\":\"hi\",\"author\":\"you\"},{\"title\":\"hi again\",\"author\":\"rachel\"},{\"elements\":[{\"title\":\"how are you?\",\"author\":\"pearl\"}],\"name\":\"sub\"}],\"name\":\"wiki\"}", coll.getStringRepresentation());
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
