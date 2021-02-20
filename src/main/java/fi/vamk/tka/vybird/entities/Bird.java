package fi.vamk.tka.vybird.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement the id for next record
    private int id;
    private String finnish;
    private String swedish;
    private String english;
    private String latin;
    private String textid;

    public Bird() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFinnish() {
        return this.finnish;
    }

    public void setFinnish(String finnish) {
        this.finnish = finnish;
    }

    public String getSwedish() {
        return this.swedish;
    }

    public void setSwedish(String swedish) {
        this.swedish = swedish;
    }

    public String getEnglish() {
        return this.english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getLatin() {
        return this.latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getTextid() {
        return this.textid;
    }

    public void setTextid(String textid) {
        this.textid = textid;
    }

}
