package com.tothenew.sharda.Entities;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 
@Entity
@Table(name = "bankcheck")
//@DiscriminatorValue("ch")
@PrimaryKeyJoinColumn(name = "id")
public class Check extends Payment {
    private String checknumber;
 
    public String getChecknumber() {
        return checknumber;
    }
 
    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}