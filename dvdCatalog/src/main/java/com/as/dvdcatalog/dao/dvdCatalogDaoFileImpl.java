/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dvdcatalog.dao;

import com.as.dvdcatalog.dto.dvd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Austin
 */
public class dvdCatalogDaoFileImpl implements dvdCatalogDao {

    private Map<String, dvd> dvdS = new HashMap<>();

    public static final String CATALOG_FILE = "catalog.txt";
    public static final String DELIMITER = "::";

    @Override
    public dvd addDvd(String dvdTitle, dvd dvD)
            throws dvdCatalogDaoException {
        loadCatalog();
        dvd prevDvd = dvdS.put(dvdTitle, dvD);
        writeCatalog();
        return prevDvd;
    }

    @Override
    public List<dvd> getAllDvds()
            throws dvdCatalogDaoException {
        loadCatalog();
        //loadNewDvdCatalog();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new ArrayList<dvd>(dvdS.values());
    }

    @Override
    public dvd getDvd(String dvdTitle)
            throws dvdCatalogDaoException {
        loadCatalog();
        return dvdS.get(dvdTitle);
    }

    @Override
    public dvd removeDvd(String dvdTitle)
            throws dvdCatalogDaoException {
        loadCatalog();
        dvd removedDvd = dvdS.remove(dvdTitle);
        writeCatalog();
        return removedDvd;
    }

    @Override
    public dvd isDvd(String dvdTitle) throws dvdCatalogDaoException {
        loadCatalog();
        return dvdS.get(dvdTitle);
    }

    @Override
    public dvd editDvd(String dvdTitle, dvd dvD) throws dvdCatalogDaoException {
        loadCatalog();
        dvd edittedDvd = dvdS.put(dvdTitle, dvD);
        writeCatalog();
        return edittedDvd;
    }

    private dvd unmarshallDvd(String dvdAsText) {
        // pattern dvdTitle::releaseYr::MPAA::Director::Studio::Notes
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String dvdTitle = dvdTokens[0];
        dvd dvdFromFile = new dvd(dvdTitle);

        dvdFromFile.setDvdReleaseYear(dvdTokens[1]);
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        dvdFromFile.setDvdDirector(dvdTokens[3]);
        dvdFromFile.setDvdStudio(dvdTokens[4]);
        dvdFromFile.setDvdNotes(dvdTokens[5]);

        return dvdFromFile;
    }

    private void loadCatalog() throws dvdCatalogDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(CATALOG_FILE)));
        } catch (FileNotFoundException e) {
            throw new dvdCatalogDaoException(
                    "-_- Could not load catalog to memory.", e);
        }
        String currentLine;

        dvd currentDvd;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvdS.put(currentDvd.getDvdTitle(), currentDvd);
        }

        scanner.close();
    }

    private String marshallDvd(dvd aDvd) {
        String dvdAsText = aDvd.getDvdTitle() + DELIMITER;
        dvdAsText += aDvd.getDvdReleaseYear() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDvdDirector() + DELIMITER;
        dvdAsText += aDvd.getDvdStudio() + DELIMITER;
        dvdAsText += aDvd.getDvdNotes();

        return dvdAsText;
    }

    private void writeCatalog() throws dvdCatalogDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(CATALOG_FILE));
        } catch (IOException e) {
            throw new dvdCatalogDaoException(
                    "Could not save dvd data.", e);
        }

        String dvdAsText;
        List<dvd> dvdList = new ArrayList(dvdS.values());
        for (dvd currentDvd : dvdList) {

            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }


}
