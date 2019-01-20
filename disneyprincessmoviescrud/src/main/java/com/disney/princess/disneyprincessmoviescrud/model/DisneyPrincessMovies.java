/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disney.princess.disneyprincessmoviescrud.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Macor
 */
@Entity
@Table(name = "disneyprincessmovies")
public class DisneyPrincessMovies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "disneyprincessname")
    private String disneyprincessname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "moviename")
    private String moviename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "year")
    private String year;
   

    public DisneyPrincessMovies() {
    }

    public DisneyPrincessMovies(Integer id) {
        this.id = id;
    }

    public DisneyPrincessMovies(Integer id, String disneyprincessname, String moviename, String year) {
        this.id = id;
        this.disneyprincessname = disneyprincessname;
        this.moviename = moviename;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   

    public String getDisneyprincessname() {
		return disneyprincessname;
	}

	public void setDisneyprincessname(String disneyprincessname) {
		this.disneyprincessname = disneyprincessname;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisneyPrincessMovies)) {
            return false;
        }
        DisneyPrincessMovies other = (DisneyPrincessMovies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.disney.princess.disneyprincessmoviescrud.model.DisneyPrincessMovies[ id=" + id + " ]";
    }
    
}