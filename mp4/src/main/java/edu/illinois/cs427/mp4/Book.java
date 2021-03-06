package edu.illinois.cs427.mp4;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.json.JSONObject;

/**
 * This class contains the information needed to represent a book.
 */
public final class Book extends Element {
    private String title;
    private String author;
    /**
     * Builds a book with the given title and author.
     *
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Builds a book from the string representation,
     * which contains the title and author of the book.
     *
     * @param stringRepresentation the string representation
     */
    public Book(String stringRepresentation) {
        JSONObject book = new JSONObject(stringRepresentation);
        title = book.getString("title");
        author = book.getString("author");
    }

    /**
     * Returns the string representation of the given book.
     * The representation contains the title and author of the book.
     *
     * @return the string representation
     */
    public String getStringRepresentation() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Returns all the collections that this book belongs to directly and indirectly.
     * Consider the following.
     * (1) Computer Science is a collection.
     * (2) Operating Systems is a collection under Computer Science.
     * (3) The Linux Kernel is a book under Operating System collection.
     * Then, getContainingCollections method for The Linux Kernel should return a list
     * of these two collections (Operating Systems, Computer Science), starting from
     * the direct collection to more indirect collections.
     *
     * @return the list of collections
     */
    public List<Collection> getContainingCollections() {
        List<Collection> coll = new ArrayList<Collection>();
        Element curr = this;
        while (true) {
            Collection parent = curr.getParentCollection();
            if (parent == null)
                break;
            coll.add(parent);
            curr = parent;
        }
        return coll;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
}
