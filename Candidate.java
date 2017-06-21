package Classifier;

import Classifier.*;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

public class Candidate{
    private String firstName;
    private String lastName;
    private GPA gpa;
    private int age;
    private Hashtable<Exam.type,Exam> exams; // Guarantees single type of exam
    private List<Felony> felonies;
    private status status;
    private String[] status_notes;

    public static enum status{
        ACCEPTED,
        REJECTED,
        PENDING
    }

    private Candidate(String firstName, String lastName, int age,
                      GPA gpa, Hashtable<Exam.type,Exam> exams,
                      List<Felony> felonies) throws IllegalArgumentException{
        if( firstName.length() == 0 || lastName.length() == 0 ){
            throw new IllegalArgumentException("Names need to have at least one character each");
        }
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
        this.gpa       = gpa;
        this.exams     = exams;
        this.felonies  = felonies;
    }

    public static class CandidateBuilder{
        private Hashtable<Exam.type,Exam> exams;
        private String firstName;
        private String lastName;
        private List<Felony> felonies = new ArrayList<Felony>();
        private GPA gpa;
        private int age;

        public Candidate build(){
            return new Candidate(this.firstName, this.lastName, this.age, this.gpa, this.exams, this.felonies);
        }
        public CandidateBuilder setFirst( String first ){
            this.firstName = first;
            return this;
        }
        public CandidateBuilder setLast( String last ){
            this.lastName = last;
            return this;
        }
        public CandidateBuilder setExam( Exam e ){
            this.exams.put(e.type,e); // this will replace existing "type" exam
            return this;
        }
        public CandidateBuilder setGPA( GPA g ){
            this.gpa = g;
            return this;
        }
        public CandidateBuilder setAge( int age ){
            this.age = age;
            return this;
        }
        public CandidateBuilder addFelony( Felony f ){
            this.felonies.add(f);
            return this;
        }
    }
}
