package edu.illinois.cs427.mp4;
import java.util.List;
import java.io.IOException;
import java.lang.RuntimeException;
import org.junit.*;
import static junit.framework.Assert.*;

public class LibraryTest {
    Collection coll1;
    Collection coll2;
    Library lib;

    @Before
    public void setUp(){
      coll1 = new Collection("coll1");
      coll1.addElement(new Book("book1", "author1"));
      coll1.addElement(new Book("book2", "author2"));
      Collection subcoll1 = new Collection("subcoll1");
      subcoll1.addElement(new Book("book3", "author3"));
      subcoll1.addElement(new Book("book4", "author4"));
      coll1.addElement(subcoll1);

      coll2 = new Collection("coll2");
      coll1.addElement(new Book("book5", "author5"));
      Collection subcoll2 = new Collection("subcoll2");
      subcoll2.addElement(new Book("book6", "author6"));
      subcoll2.addElement(new Book("book7", "author7"));
      coll2.addElement(subcoll2);
      coll2.addElement(new Book("book8", "author8"));
      Collection subcoll3 = new Collection("subcoll3");
      coll2.addElement(subcoll3);
      subcoll3.addElement(new Book("book9", "author9"));

      lib = new Library();
      List<Collection> collections = lib.getCollections();
      collections.add(coll1);
      collections.add(coll2);
    }

    @After
    public void tearDown() {
      coll1 = null;
      coll2 = null;
      lib = null;
    }

    @Test
    public void testLibraryConstructorFromFile1() throws IOException{
        Library restoredLib = new Library("testSaveLibraryToFile1.txt");
        List<Collection> restoredColls = restoredLib.getCollections();
        List<Collection> colls = lib.getCollections();
        assertEquals(colls.size(), restoredColls.size());
        for (int i = 0; i < colls.size(); i++) {
          collectionComp(colls.get(i), restoredColls.get(i));
        }
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
          else {
              assertEquals(((Collection) collElems.get(i)).getName(), ((Collection) restoredElems.get(i)).getName());
              collectionComp((Collection) collElems.get(i), (Collection)restoredElems.get(i));
            }
      }
    }

    @Test
    public void testSaveLibraryToFile1() throws IOException{
        lib.saveLibraryToFile("testSaveLibraryToFile1.txt");
    }
}
