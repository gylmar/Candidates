package Classifier;

public class GPA{
    private double value;
    private double scale;

    private GPA( double value, double scale) throws IllegalArgumentException{
        if( value < 0.0 ){ throw new IllegalArgumentException("GPA value must be positive"); }
        if( scale < 0.0 ){ throw new IllegalArgumentException("GPA scale must be positive"); }

        this.value = value;
        this.scale = scale;
    }

    public double calculate_percentage(){
        return this.value / this.scale; // Constructor guarantees non-zero division
    }

    // Getters
    public double getValue(){
        return this.value;
    }
    public double getScale(){
        return this.scale;
    }

    // Setters
    public void setValue( double value ){
        this.value = value;
    }
    public void setScale( double scale ){
        this.scale = scale;
    }

    public static class GPABuilder{
        private double value;
        private double scale = 4.0;
         
        public GPA build(){
            return new GPA( this.value, this.scale );
        }
        public GPABuilder setValue( double val ){
            this.value = val;
            return this;
        }
        public GPABuilder setScale( double scale ){
            this.scale = scale;
            return this;
        }
    }
}
