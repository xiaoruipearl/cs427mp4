package edu.illinois.cs427.mp4;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Represents a collection of books or (sub)collections.
 */
public final class Collection extends Element {
    List<Element> elements;
    private String name;

    /**
     * Creates a new collection with the given name.
     *
     * @param name the name of the collection
     */
    public Collection(String name) {
        this.name = name;
        this.elements = new ArrayList<Element>();
    }

    /**
     * Restores a collection from its given string representation.
     *
     * @param stringRepresentation the string representation
     */
    public static Collection restoreCollection(String stringRepresentation) {
        Gson gson = new Gson();
        JSONObject collection = new JSONObject(stringRepresentation);
        Collection restore = new Collection(collection.getString("name"));
        JSONArray elems = collection.getJSONArray("elements");
        for(int i = 0; i < elems.length(); i++){
            JSONObject elem = elems.getJSONObject(i);
            if(elem.has("title"))
                restore.addElement(new Book(elem.getString("title"), elem.getString("author")));
            else{
                Collection temp = restoreCollection(elem.toString());
                restore.addElement(temp);
            }
        }
        return restore;
    }

    /**
     * Returns the string representation of a collection.
     * The string representation should have the name of this collection,
     * and all elements (books/subcollections) contained in this collection.
     *
     * @return string representation of this collection
     */
    public String getStringRepresentation() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Returns the name of the collection.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds an element to the collection.
     * If parentCollection of given element is not null,
     * do not actually add, but just return false.
     * (explanation: if given element is already a part of
     * another collection, you should have deleted the element
     * from that collection before adding to another collection)
     *
     * @param element the element to add
     * @return true on success, false on fail
     */
    public boolean addElement(Element element) {
        if (element.getParentCollection() != null){
            return false;
        }
        elements.add(element);
        element.setParentCollection(this);
        return true;
    }

    /**
     * Deletes an element from the collection.
     * Returns false if the collection does not have
     * this element.
     * Hint: Do not forget to clear parentCollection
     * of given element
     *
     * @param element the element to remove
     * @return true on success, false on fail
     */
    public boolean deleteElement(Element element) {
        if (!elements.contains(element)){
            return false;
        }
        element.setParentCollection(null);
        elements.remove(element);
        return true;
    }

    /**
     * Returns the list of elements.
     *
     * @return the list of elements
     */
    public List<Element> getElements() {
        return elements;
    }
}
