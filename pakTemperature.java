package converterPackage;

/** Class made to refer to for arithmetic process of converting 
 * between °Celsius and °Fahrenheit scale metrics. */
class Temperature{
    /** Variable "reading" used for calculations. */
    private double reading = 0;
    /** A flag simply to indicate the metric of the value 
     * stored. Made for testing stages of class. 
     * False == Fahrenheit. */
    private boolean metric = true;
    //False == Fahrenheit.
    public Temperature(double n){
        this.reading = n;
    }
    /*public Temperature(String a){
        FloatInputPad.splitInput(a);
    } In case I integrate the text box with the actual splitInput() function. Temporarily here for me to figure out later.*/
    
    /* Just in case I can't set it any other way for some 
reason, this sets the temperature value. */
    public void setTemperature(double n){
        this.reading = n;
    }
    /* Returns the temperature value. */
    public double getTemperature(){
        return this.reading;
    }

    /** The following method processes a number using an 
     * equation made to convert to °Celsius. */
    public double convertToCelsius(double x)
    {
        /** "meter" is a temporary variable used in this 
         * class's methods to store conversion results. */
        double meter = ((x - 32) / 1.8);
        this.reading = meter;
        this.metric = true;
        return meter;
    }
    /** Processes the stored value using an equation made to 
     * convert to °Celsius. */
    public double convertToCelsius()
    {
        double meter = ((this.reading - 32) / 1.8);
        this.reading = meter;
        this.metric = true;
        return meter;
    }

    /** Processes a number using an equation made to 
     * convert to °Fahrenheit. */
    public double convertToFaren(double x)
    {
        double meter = (x * 1.8) + 32;
        this.reading = meter;
        this.metric = false;
        return meter;
    }
    /** Processes the stored value using an equation made to 
     * convert to °Fahrenheit. */
    public double convertToFaren()
    {
        double meter = (this.reading * 1.8) + 32;
        this.reading = meter;
        this.metric = false;
        return meter;
    }

    /** Separate method made to set the temperature to 
     * °Celsius just in case I needed it. */
    private void setToCelsius(){
        this.metric = true;
        //System.out.println("Temperature is now in °Celsius.");
    }
    /** Separate method made to set the temperature to 
     * °Fahrenheit just in case I needed it. */
    private void setToFaren(){
        this.metric = false;
        //System.out.println("Temperature is now in °Fahrenheit.");
    }
}

