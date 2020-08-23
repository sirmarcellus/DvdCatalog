/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dvdcatalog;

import com.as.dvdcatalog.controller.dvdCatalogController;
import com.as.dvdcatalog.dao.dvdCatalogDao;
import com.as.dvdcatalog.dao.dvdCatalogDaoFileImpl;
import com.as.dvdcatalog.ui.UserIO;
import com.as.dvdcatalog.ui.UserIOConsoleImpl;
import com.as.dvdcatalog.ui.dvdCatalogView;
import java.io.IOException;

/**
 *
 * @author Austin
 */
public class app {
    public static void main(String[] args) throws IOException {
        //dvdCatalogController controller = new dvdCatalogController();
        UserIO myIo = new UserIOConsoleImpl();
        dvdCatalogView myView = new dvdCatalogView(myIo);
        dvdCatalogDao myDao = new dvdCatalogDaoFileImpl();
        dvdCatalogController controller = new dvdCatalogController(myDao, myView);
       
        controller.run();
    }
}
