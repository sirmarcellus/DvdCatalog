/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dvdcatalog.ui;

import com.as.dvdcatalog.dto.dvd;
import java.util.List;

/**
 *
 * @author Austin
 */
public class dvdCatalogView {

    //private UserIO io = new UserIOConsoleImpl();
    private UserIO io;

    public dvdCatalogView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List all DVDs");
        io.print("2. Create New DVD");
        io.print("3. View info on a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Find a DVD by Title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }

    public dvd getNewDvdInfo() {
        String dvdTitle = io.readString("Please enter Dvd title");
        String dvdReleaseYear = io.readString("Please enter Dvd release year");
        String mpaaRating = io.readString("Please enter Dvd rating");
        String dvdDirector = io.readString("Please enter Dvd Director");
        String dvdStudio = io.readString("Please enter Dvd Studio");
        String dvdNotes = io.readString("Please enter Dvd notes");

        dvd currentDvd = new dvd(dvdTitle);
        currentDvd.setDvdReleaseYear(dvdReleaseYear);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDvdDirector(dvdDirector);
        currentDvd.setDvdStudio(dvdStudio);
        currentDvd.setDvdNotes(dvdNotes);

        return currentDvd;

    }
    
    public dvd getEditNewDvdInfo() {
        String dvdTitle = io.readString("Please enter Dvd title");
        String dvdReleaseYear = io.readString("Please enter Dvd release year");
        String mpaaRating = io.readString("Please enter Dvd rating");
        String dvdDirector = io.readString("Please enter Dvd Director");
        String dvdStudio = io.readString("Please enter Dvd Studio");
        String dvdNotes = io.readString("Please enter Dvd notes");

        dvd currentDvd = new dvd(dvdTitle);
        currentDvd.setDvdReleaseYear(dvdReleaseYear);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDvdDirector(dvdDirector);
        currentDvd.setDvdStudio(dvdStudio);
        currentDvd.setDvdNotes(dvdNotes);

        return currentDvd;

    }
    

    public void displayDvdBanner() {
        io.print("=== Create a Dvd Here ! ===");
    }

    public void displayDvdCreateSuccessBanner() {
        io.readString("Dvd created successfully. Press Enter to Continue");
    }

    public void displayDvdCatalog(List<dvd> dvdCatalog) {
        for (dvd currentDvd : dvdCatalog) {
            String dvdInfo = String.format("#%s : %s %s %s %s %s",
                    currentDvd.getDvdTitle(),
                    currentDvd.getDvdReleaseYear(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDvdDirector(),
                    currentDvd.getDvdStudio(),
                    currentDvd.getDvdNotes());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllDvdBanner() {
        io.print("=== Display all Dvds ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter dvd title to find ");
    }

    public void displayDvd(dvd dvD) {
        if (dvD != null) {
            io.print(dvD.getDvdTitle());
            io.print(dvD.getDvdReleaseYear());
            io.print(dvD.getMpaaRating());
            io.print(dvD.getDvdDirector());
            io.print(dvD.getDvdStudio());
            io.print(dvD.getDvdNotes());
            io.print("");
        } else {
            io.print("No such Dvd exists");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd from catalog ===");
    }

    public void displayRemoveDvdResults(dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("Dvd successfully removed ");
        } else {
            io.print("No such dvd exists");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayIsDvdExistBanner() {
        io.print("=== Is there this Dvd ===");
    }

    public boolean isThereDvdResult(dvd dvD) {
        if (dvD != null) {
            io.print(dvD.getDvdTitle());
            io.print(" Does Exists ");
            //io.readString("Please hit enter to continue");
            return true;
        } else {
            io.print("No such Dvd exists");
            //io.readString("Please hit enter to continue");
            return false;
        }
        //io.readString("Please hit enter to continue");
    }
    
    public void displayNext(){
        io.readString("Please hit enter to continue");
    }
    

    public void displayEditDvdBanner() {
        io.print("=== Edit Dvd Banner ===");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
