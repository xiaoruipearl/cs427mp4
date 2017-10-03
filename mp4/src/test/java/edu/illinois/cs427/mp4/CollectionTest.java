package edu.illinois.cs427.mp4;

import java.util.List;
import org.junit.*;
import static junit.framework.Assert.*;

public class CollectionTest{

    @Test
    public void testRestoreCollection1() {
        Collection coll = new Collection("wiki");
        coll.addElement(new Book("hi","you"));
        coll.addElement(new Book("hi \n again","rachel"));
        Collection subcoll = new Collection("sub");
        subcoll.addElement(new Book("how are you?", "pearl"));
        subcoll.addElement(new Collection("bbb"));
        coll.addElement(subcoll);
        Collection restored = Collection.restoreCollection(coll.getStringRepresentation());
        collectionComp(coll, restored);
    }

    private void collectionComp(Collection coll, Collection restored) {
        assertEquals(coll.getName(), restored.getName());
        List<Element> collElems = coll.getElements();
        List<Element> restoredElems = restored.getElements();
        assertEquals(collElems.size(), restoredElems.size());
        for (int i = 0; i < collElems.size(); i++){
            if(collElems.get(i) instanceof Book) {
                assertEquals(((Book) collElems.get(i)).getTitle(), ((Book) restoredElems.get(i)).getTitle());
                assertEquals(((Book) collElems.get(i)).getAuthor(), ((Book) restoredElems.get(i)).getAuthor());
            }
            else
                collectionComp((Collection) collElems.get(i), (Collection) restoredElems.get(i));
        }
    }

    @Test
    public void testGetStringRepresentation1() {
        Collection coll = new Collection("wiki");
        coll.addElement(new Book("hi","you"));
        coll.addElement(new Book("hi again","rachel"));
        Collection subcoll = new Collection("sub");
        subcoll.addElement(new Book("how are you?", "pearl"));
        coll.addElement(subcoll);
        assertEquals("{\"elements\":[{\"title\":\"hi\",\"author\":\"you\"},{\"title\":\"hi again\",\"author\":\"rachel\"},{\"elements\":[{\"title\":\"how are you?\",\"author\":\"pearl\"}],\"name\":\"sub\"}],\"name\":\"wiki\"}", coll.getStringRepresentation());
    }

    @Test
    public void testAddElement1() {
        Collection coll1 = new Collection("wiki");
        Book book = new Book("hi~!","you<>-");
        Collection subCol = new Collection("sub;");
        assertTrue(coll1.addElement(book));
        assertTrue(coll1.addElement(subCol));

        Collection coll2 = new Collection("pedia");
        assertTrue(!coll2.addElement(book));
        assertTrue(!coll2.addElement(subCol));
    }

    @Test
    public void testAddElement2() {
      Collection coll = new Collection("coll");
      assertTrue(!coll.addElement(null));
    }
    @Test
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
