package fi.vamk.tka.vybird.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement the id for next record
    private int id;
    private int birdid;
    private String place;
    private java.sql.Date time;
    private String user;

    public Observation() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBirdid() {
        return this.birdid;
    }

    public void setBirdid(int birdid) {
        this.birdid = birdid;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public java.sql.Date getTime() {
        return this.time;
    }

    public void setTime(java.sql.Date time) {
        this.time = time;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", birdid='" + getBirdid() + "'" + ", place='" + getPlace() + "'"
                + ", time='" + getTime() + "'" + ", user='" + getUser() + "'" + "}";
    }

}
