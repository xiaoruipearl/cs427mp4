package edu.illinois.cs427.mp4;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Container class for all the collections (that eventually contain books).
 * Its main responsibility is to save the collections to a file and restore them from a file.
 */
public final class Library {
    private List<Collection> collections;

    /**
     * Builds a new, empty library.
     */
    public Library() {
        collections = new ArrayList<Collection>();
    }

    /**
     * Builds a new library and restores its contents from the given file.
     *
     * @param fileName the file from where to restore the library.
     */
    public Library(String fileName) throws IOException{
        this();
        String stringRep = "";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (true) {
            String currentLine = reader.readLine();
            if (currentLine == null)
                break;
            else
                stringRep += currentLine;
        }

        JSONObject lib = new JSONObject(stringRep);
        JSONArray collections = lib.getJSONArray("collections");
        for (int i = 0; i < collections.length(); i++) {
            Collection coll = Collection.restoreCollection(collections.getJSONObject(i).toString());
            this.collections.add(coll);
        }
    }

    /**
     * Saved the contents of the library to the given file.
         *
     * @param fileName the file where to save the library
     */
    public void saveLibraryToFile(String fileName) throws IOException{
        Gson gson = new Gson();
        String stringRep = gson.toJson(this);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(stringRep);
        writer.close();
    }

    /**
     * Returns the collections contained in the library.
     *
     * @return library contained elements
     */
    public List<Collection> getCollections() {
        return collections;
    }
}
