//Mickie Blair
//Final Project - Exotic Moves
//Aston Martin Class

package finalprojectexoticmoves;

import javafx.scene.image.Image;

public class AstonMartin extends Car{
    private String model;
    private String color;
    private boolean convertible;
    private int numOfCylinders;
    private Image image;
    
    /**
     * Constructor
     * @param c Color
     * @param conv Convertible true/false
     * @param cyl Number of Cycles
     * @param im Image
     * @param m Model
     */
    AstonMartin(String c, boolean conv, int cyl, Image im, String m){
        super("Aston Martin", 120000, 3.6);
        this.color = c;
        this.convertible = conv;
        this.numOfCylinders = cyl;
        this.image = im;
        this.model = m;
    }
    
    /**
     * Set Model
     * @param m Model
     */
    @Override
    public void setModel(String m){
        this.model = m;
    }
    
    /**
     * Get Model
     * @return Model
     */
    @Override
    public String getModel(){
        return this.model;
    }
    
     /** Set Color
     * @param c Color
     */
    @Override
    public void setColor(String c){
        this.color = c;
    }
    
    /**
     * Set Convertible
     * @param conv Convertible (Yes or No)
     */
    @Override
    public void setConvertible(boolean conv){
        this.convertible = conv;
    }
    
    /**
     * Set Number Of Cylinders
     * @param cyl Number of Cylinders
     */
    @Override
    public void setNumOfCylinders(int cyl){
        this.numOfCylinders = cyl;
    }
    
    /**
     * Set Image
     * @param im Image 
     */
    @Override
    public void setImage(Image im){
        this.image = im;
    }

    /**
     * Get Color
     * @return Color
     */
    @Override
    public String getColor(){
        return this.color;
    }
    
    /**
     * Get Convertible
     * @return Convertible (Yes or No)
     */
    @Override
    public boolean getConvertible(){
        return this.convertible;
    }
    
    /**
     * Get Number Of Cylinders
     * @return Number Of Cylinders
     */
    @Override
    public int getNumOfCylinders(){
        return this.numOfCylinders;
    }

     /**
     * Get Image
     * @return Image
     */
    @Override
    public Image getImage(){
        return this.image;
    }
}
