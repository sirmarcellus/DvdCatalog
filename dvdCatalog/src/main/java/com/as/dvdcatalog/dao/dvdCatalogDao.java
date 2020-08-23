/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dvdcatalog.dao;

import com.as.dvdcatalog.dto.dvd;
import java.util.List;

/**
 *
 * @author Austin
 */
public interface dvdCatalogDao {
    // method declar for adding dvd by title 
    dvd addDvd(String dvdTitle, dvd dvD)
            throws dvdCatalogDaoException;
    // method list all current dvds
    List<dvd> getAllDvds()
            throws dvdCatalogDaoException;
    // method search for 1 current dvd by title
    dvd getDvd(String dvdTitle)
            throws dvdCatalogDaoException;
    // method remove 1 dvd by title
    dvd removeDvd(String dvdTitle)
            throws dvdCatalogDaoException;
    // method edit 1 dvd info by title
    dvd isDvd(String dvdTitle)
            throws dvdCatalogDaoException;
    // method to edit one dvd
    dvd editDvd(String dvdTitle, dvd dvD)
            throws dvdCatalogDaoException;
    
}
