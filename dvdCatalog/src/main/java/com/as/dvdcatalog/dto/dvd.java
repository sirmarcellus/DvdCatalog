/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dvdcatalog.dto;

/**
 *
 * @author Austin
 */
public class dvd {
    private String dvdTitle;
    private String dvdReleaseYear;
    private String mpaaRating;
    private String dvdDirector;
    private String dvdStudio;
    private String dvdNotes;
    
    

    public dvd(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }
    
    public String getDvdTitle(){
        return dvdTitle;
    }

    public String getDvdReleaseYear() {
        return dvdReleaseYear;
    }

    public void setDvdReleaseYear(String dvdReleaseYear) {
        this.dvdReleaseYear = dvdReleaseYear;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDvdDirector() {
        return dvdDirector;
    }

    public void setDvdDirector(String dvdDirector) {
        this.dvdDirector = dvdDirector;
    }

    public String getDvdStudio() {
        return dvdStudio;
    }

    public void setDvdStudio(String dvdStudio) {
        this.dvdStudio = dvdStudio;
    }

    public String getDvdNotes() {
        return dvdNotes;
    }

    public void setDvdNotes(String dvdNotes) {
        this.dvdNotes = dvdNotes;
    }

    
    
    
}
