//Mickie Blair
//Final Project - Exotic Moves
//Car Abstract Class

package finalprojectexoticmoves;

import javafx.scene.image.Image;

public abstract class Car {
    private String brand;
    private String model;
    private int price;
    private double timeTo60;
    private String color;
    private boolean convertible;
    private int numOfCylinders;
    private Image image;
    
        
    /**
     * Constructor
     * @param b Brand
     * @param p Price
     * @param t Time to 60
     */
    Car (String b, int p, double t){
        this.brand = b;
        this.price = p;
        this.timeTo60 = t; 
        this.model ="";
        this.color = "";
        this.convertible = false;
        this.numOfCylinders = 0;
        this.image = null;
    }
        
    /**
     * Set Brand
     * @param b Brand
     */
    public void setBrand(String b){
        this.brand = b;
    }
    
    /**
     * Get Brand
     * @return Brand
     */
    public String getBrand(){
        return this.brand;
    }
    
    /**
     * Set Model
     * @param m Model
     */
    public void setModel(String m){
        this.model = m;
    }
    
    /**
     * Get Model
     * @return Model
     */
    public String getModel(){
        return this.model;
    }
    
    /**
     * Set Price
     * @param p Price
     */
    public void setPrice(int p){
        this.price = p;
    }

     /**
     * Get Price
     * @return Price
     */
    public int getPrice(){
        return this.price;
    }
    
     /**
     * Set Time to 60
     * @param t time to 60
     */
    public void setTimeTo60(double t){
        this.timeTo60 = t;
    }

    /**
     * Get Time to 60
     * @return Time to 60
     */
    public double getTimeTo60(){
        return this.timeTo60;
    }
    
    /** Set Color
     * @param c Color
     */
    public void setColor(String c){
        this.color = c;
    }
    
    /**
     * Set Convertible
     * @param conv Convertible (Yes or No)
     */
    public void setConvertible(boolean conv){
        this.convertible = conv;
    }
    
    /**
     * Set Number Of Cylinders
     * @param cyl Number of Cylinders
     */
    public void setNumOfCylinders(int cyl){
        this.numOfCylinders = cyl;
    }
    
    /**
     * Set Image
     * @param im Image 
     */
    public void setImage(Image im){
        this.image = im;
    }

    /**
     * Get Color
     * @return Color
     */
    public String getColor(){
        return this.color;
    }
    
    /**
     * Get Convertible
     * @return Convertible (Yes or No)
     */
    public boolean getConvertible(){
        return this.convertible;
    }
    
    /**
     * Get Number Of Cylinders
     * @return Number Of Cylinders
     */
    public int getNumOfCylinders(){
        return this.numOfCylinders;
    }

     /**
     * Get Image
     * @return Image
     */
    public Image getImage(){
        return this.image;
    }
}
