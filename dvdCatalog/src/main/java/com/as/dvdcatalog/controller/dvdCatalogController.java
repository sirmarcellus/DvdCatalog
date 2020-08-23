/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dvdcatalog.controller;

import com.as.dvdcatalog.dao.dvdCatalogDao;
import com.as.dvdcatalog.dao.dvdCatalogDaoException;
import com.as.dvdcatalog.dao.dvdCatalogDaoFileImpl;
import com.as.dvdcatalog.dto.dvd;
import com.as.dvdcatalog.ui.UserIO;
import com.as.dvdcatalog.ui.UserIOConsoleImpl;
import com.as.dvdcatalog.ui.dvdCatalogView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Austin
 */
public class dvdCatalogController {

    private UserIO io = new UserIOConsoleImpl();
    //private dvdCatalogView view = new dvdCatalogView();
    //private dvdCatalogDao dao = new dvdCatalogDaoFileImpl();

    private dvdCatalogView view;
    private dvdCatalogDao dao;

    public dvdCatalogController(dvdCatalogDao dao, dvdCatalogView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws IOException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        //io.print("LIST STUDENTS");
                        //io.print("List all DVDs");
                        listAllDvds();
                        break;
                    case 2:
                        //io.print("CREATE STUDENT");
                        //io.print("Create a new DVD");
                        createDvd();
                        break;
                    case 3:
                        //io.print("VIEW STUDENT");
                        //io.print("View DVD info");
                        viewDvdInfo();
                        break;
                    case 4:
                        //io.print("REMOVE STUDENT");
                        //io.print("Remove a DVD");
                        removeDvd();
                        break;
                    case 5:
                        //keepGoing = false;
                        //io.print("Edit a DVD");
                        isThereDvd();
                        if(isThereDvd() == true){
                            parseComing();
                            editOldDvd();
                        } 
                        
                        
                        break;
                    case 6:
                        //keepGoing = false;
                        //io.print("Find existence of DVD by Title");
                        isThereDvd();
                        parseComing();
                        break;
                    case 7:
                        keepGoing = false;
                        //io.print("Exit");
                        break;

                    default:
                        //io.print("UNKNOWN COMMAND");
                        unknownCommand();
                }

            }
            // fix here
            io.print("GOOD BYE");
            exitMessage();
        } catch (dvdCatalogDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    // get userInput for menu selection 
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // method add new dvd
    private void createDvd() throws dvdCatalogDaoException {
        view.displayDvdBanner();
        dvd newDvD = view.getNewDvdInfo();
        dao.addDvd(newDvD.getDvdTitle(), newDvD);
        view.displayDvdCreateSuccessBanner();
    }

    // method display all dvds in catalog
    private void listAllDvds() throws dvdCatalogDaoException {
        view.displayDisplayAllDvdBanner();
        List<dvd> dvdList = dao.getAllDvds();
        view.displayDvdCatalog(dvdList);
    }

    // method search catalog for dvd by title
    private void viewDvdInfo() throws dvdCatalogDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitleNew = view.getDvdTitleChoice();
        dvd dvD = dao.getDvd(dvdTitleNew);
        view.displayDvd(dvD);
    }

    // method to remove a dvd by title
    private void removeDvd() throws dvdCatalogDaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        dvd removedDvd = dao.removeDvd(dvdTitle);
        view.displayRemoveDvdResults(removedDvd);
    }

    // method to check if theres a dvd by title 
    private boolean isThereDvd() throws dvdCatalogDaoException {
        view.displayIsDvdExistBanner();
        String dvdIdExist = view.getDvdTitleChoice();
        dvd checkedDvd = dao.isDvd(dvdIdExist);
        return view.isThereDvdResult(checkedDvd) == true;
        
        //view.displayNext();
        //return view.isThereDvdResult(checkedDvd) == true;
    }

    // it verifys what the users wants to edit and what their editing 
    // explicit ask for a title if/not exist 
    // method to edit a dvd by title then edit all fields
    private void editOldDvd() throws dvdCatalogDaoException {
        view.displayEditDvdBanner();
        /*
        dvd newDvd = view.getNewDvdInfo();
        dao.editDvd(newDvd.getDvdTitle(), newDvd);
        */
        
        //dao.editDvd(checkedDvd.getDvdTitle(), checkedDvd);
        dvd newDvd = view.getNewDvdInfo();
        dao.editDvd(newDvd.getDvdTitle(), newDvd);
        view.displayDvdCreateSuccessBanner();
        
    }
    
    private void parseComing() throws dvdCatalogDaoException {
        view.displayNext();
    }


    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
