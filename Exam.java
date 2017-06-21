package Classifier;

public class Exam{
    private final type type;
    private int score;

    public static enum type {
        SAT (600,2400,1920),
        ACT (1,36,27)
        //ADD MORE EXAMS HERE
        ;

        private final int min;
        private final int max;
        private final int threshold;

        type(int min, int max, int threshold) throws IllegalArgumentException{
            if( !(max > min) ){
                throw new IllegalArgumentException("Exam 'max' must be greater than 'min'");
            }
            if( threshold > max || threshold < min ){ 
                throw new IllegalArgumentException("Exam 'threshold' must fall between min and max value'");
            }

            this.min = min;
            this.max = max;
            this.threshold = threshold;
        }
    }

    private Exam( type t, int score ) throws IllegalArgumentException{
        /* Note: potential for explosion if we add an exam score that of type "double" */
        if( score < 0 ){ throw new IllegalArgumentException("Exam score must be positive"); }

        this.type  = t;
        this.score = score;
    }

    public boolean exceedsThreshold(){
        return this.score >= this.type.threshold;
    }

    // Getters
    public type getType(){
        return this.type;
    }
    public int getScore(){
        return this.score;
    }

    // Setters
    // Note: Omitting an Exam.type setter due to additional score overhead.
    // It is preferrable to detach existing Exam reference and create a new one in
    // that situation.

    public void setScore( int score ){
        if (score > this.type.max || score < this.type.min){
            throw new IllegalArgumentException("Score must fall between exam range") 
        }
        this.score = score;
    }

    public static class ExamBuilder{
        private type type;
        private int score;
         
        public Exam build(){
            return new Exam( this.type, this.score );
        }
        public ExamBuilder setType( type t ){
            this.type = t;
            return this;
        }
        public ExamBuilder setScore( int score ){
            this.score = score;
            return this;
        }
    }
}
