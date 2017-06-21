package Classifier;

import Classifier.*;
import java.util.Date;

public class Felony{
    private String crime;
    private Date date;

    private Felony(String crime, Date date){
        this.crime = crime;
        this.date  = date;
    }
    public String getCrime(){
        return this.crime;
    }
    public Date getDate(){
        return this.date;
    }

    public static class FelonyBuilder{ // Lol
        private String crime;
        private Date date;

        public Felony build(){
            return new Felony( this.crime, this.date );
        }
        public FelonyBuilder setCrime( String crime ){
            this.crime = crime;
            return this;
        }
        public FelonyBuilder setDate( Date date ){
            this.date = date;
            return this;
        }
    }
}
