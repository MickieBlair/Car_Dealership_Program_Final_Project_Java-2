//Mickie Blair
//Final Project - Exotic Moves
//Inventory Class

package finalprojectexoticmoves;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Inventory {
    
    private ArrayList <Car> inventory;
       
    /**
     * Constructor
     */
    Inventory(){
       this.inventory = new ArrayList<>();
       
       //populate Inventory
       populateInventory();
       
    }
        
    /**
     * Get Inventory
     * @return Inventory ArrayList
     */
    public ArrayList<Car> getInventory(){
        return this.inventory;
    }
       
    /**
     * Populate Inventory ArrayList
     */
    private void populateInventory(){
        //Black Aston Martin Convertible
        Image blkAstonConvertibleImage = new Image("/BlkAstonConvertible.jpg");
        AstonMartin blkAstonConvertible = new AstonMartin("Black", true, 12,
                                          blkAstonConvertibleImage, "Vanquish Volante");
        this.inventory.add(blkAstonConvertible);  
        
        //Blue Aston Martin
        Image bluAstonImage = new Image("/BluAston.jpg");
        AstonMartin bluAston = new AstonMartin("Blue", false, 8,
                                          bluAstonImage, "DB11");
        this.inventory.add(bluAston);
        
        //green Aston Martin
        Image greenAstonImage = new Image("/GreenAston.jpg");
        AstonMartin greenAston = new AstonMartin("Green", false, 8,
                                          greenAstonImage, "Vantage");
        this.inventory.add(greenAston);
        
        //Red Aston Martin Convertible
        Image redAstonConvertibleImage = new Image("/RedAstonConvertible.jpg");
        AstonMartin redAstonConvertible = new AstonMartin("Red", true, 12,
                                          redAstonConvertibleImage,"Vantage");
        this.inventory.add(redAstonConvertible); 
        
        //Black Ferrari Convertible
        Image blkFerrariConvertibleImage = new Image("/BlkFerrariConvertible.jpg");
        Ferrari blkFerrariConvertible = new Ferrari("Black", true, 12,
                                          blkFerrariConvertibleImage,"F360 Spider F-1");
        this.inventory.add(blkFerrariConvertible);
        
        //Blue Ferrari Convertible
        Image bluFerrariConvertibleImage = new Image("/BluFerrariConvertible.jpg");
        Ferrari bluFerrariConvertible = new Ferrari("Blue", true, 8,
                                          bluFerrariConvertibleImage,"Spider");
        this.inventory.add(bluFerrariConvertible);
        
        //Red Ferrari
        Image redFerrariImage = new Image("/RedFerrari.jpg");
        Ferrari redFerrari = new Ferrari("Red", false, 12,
                                          redFerrariImage,"488GT");
        this.inventory.add(redFerrari);
        
        //White Ferrari Convertible
        Image whiteFerrConvertibleImage = new Image("/WhiteFerrConvertible.jpg");
        Ferrari whiteFerrariConvertible = new Ferrari("White", true, 8,
                                          whiteFerrConvertibleImage,"488GT");
        this.inventory.add(whiteFerrariConvertible);
        
        //White Ferrari
        Image whiteFerrariImage = new Image("/WhiteFerrari.jpg");
        Ferrari whiteFerrari = new Ferrari("White", false, 10,
                                          whiteFerrariImage,"GTC4Lusso");
        this.inventory.add(whiteFerrari);
        
        //Yellow Ferrari
        Image yellowFerrariImage = new Image("/YellowFerrari.jpg");
        Ferrari yellowFerrari = new Ferrari("Yellow", false, 8,
                                          yellowFerrariImage,"488 GTB");
        this.inventory.add(yellowFerrari);
        
        //Black Lamborghini
        Image blkLamborghiniImage = new Image("/BlkLambo.jpg");
        Lamborghini blkLambo = new Lamborghini("Black", false, 10,
                                          blkLamborghiniImage,"Aventador");
        this.inventory.add(blkLambo);
        
        //Black Lamborghini Convertible
        Image blkLamboConvertibleImage = new Image("/BlkLamboConvertible.jpg");
        Lamborghini blkLamboConvertible = new Lamborghini("Black", true, 10,
                                          blkLamboConvertibleImage,"Aventador");
        this.inventory.add(blkLamboConvertible);
        
        //Blue Lamborghini Convertible
        Image bluLamboConvertibleImage = new Image("/BluLamboConvertible.jpg");
        Lamborghini bluLamboConvertible = new Lamborghini("Blue", true, 10,
                                          bluLamboConvertibleImage,"Aventador");
        this.inventory.add(bluLamboConvertible);
        
        //Green Lamborghini
        Image greenLamborghiniImage = new Image("/GreenLambo.jpg");
        Lamborghini greenLambo = new Lamborghini("Green", false, 10,
                                          greenLamborghiniImage,"Aventador");
        this.inventory.add(greenLambo);
        
        //White Lamborghini
        Image whiteLamborghiniImage = new Image("/WhiteLambo.jpg");
        Lamborghini whiteLambo = new Lamborghini("White", false, 10,
                                          whiteLamborghiniImage,"Aventador");
        this.inventory.add(whiteLambo);
        
        //Yellow Lamborghini
        Image yellowLamborghiniImage = new Image("/YellowLambo.jpg");
        Lamborghini yellowLambo = new Lamborghini("Yellow", false, 10,
                                          yellowLamborghiniImage,"Aventador");
        this.inventory.add(yellowLambo);   
        
        //Black Maserati
        Image blkMaseratiImage = new Image("/BlkMaserati.jpg");
        Maserati blkMaserati = new Maserati("Black", false, 6,
                                          blkMaseratiImage,"Ghibli");
        this.inventory.add(blkMaserati);  
        
        //Blue Maserati
        Image bluMaseratiImage = new Image("/BluMaserati.jpg");
        Maserati bluMaserati = new Maserati("Blue", false, 6,
                                          bluMaseratiImage,"GranTurismo");
        this.inventory.add(bluMaserati);
        
        //Red Maserati
        Image redMaseratiImage = new Image("/RedMaserati.jpg");
        Maserati redMaserati = new Maserati("Red", false, 8,
                                          redMaseratiImage,"GranTurismo");
        this.inventory.add(redMaserati);
        
        //White Maserati Convertible
        Image whiteMaseratiConvertibleImage = new Image("/WhiteMaserConvertible.jpg");
        Maserati whiteMaserati = new Maserati("White", true, 8,
                                          whiteMaseratiConvertibleImage,"GranTurismo");
        this.inventory.add(whiteMaserati);

        //Black McLaren
        Image blkMcLarenImage = new Image("/BlkMcLaren.jpg");
        McLaren blkMcLaren = new McLaren("Black", false, 8,
                                          blkMcLarenImage,"570GT");
        this.inventory.add(blkMcLaren);
        
        //Blue McLaren
        Image bluMcLarenImage = new Image("/BluMcLaren.jpg");
        McLaren bluMcLaren = new McLaren("Blue", false, 8,
                                          bluMcLarenImage,"P1");
        this.inventory.add(bluMcLaren);
        
        //Green McLaren
        Image greenMcLarenImage = new Image("/GreenMcLaren.jpg");
        McLaren greenMcLaren = new McLaren("Green", false, 8,
                                          greenMcLarenImage,"675LT");
        this.inventory.add(greenMcLaren);
        
        //Orange McLaren Convertible
        Image oranMcLarConvertibleImage = new Image("/OranMcLarConvertible.jpg");
        McLaren oranMcLarConvertible = new McLaren("Orange", true, 8,
                                          oranMcLarConvertibleImage,"Spider");
        this.inventory.add(oranMcLarConvertible);
        
        //Red McLaren
        Image redMcLarenImage = new Image("/RedMcLaren.jpg");
        McLaren redMcLaren = new McLaren("Red", false, 8,
                                          redMcLarenImage,"570S");
        this.inventory.add(redMcLaren);
        
        //Yellow McLaren
        Image yellowMcLarenImage = new Image("/YellowMcLaren.jpg");
        McLaren yellowMcLaren = new McLaren("Yellow", false, 8,
                                          yellowMcLarenImage,"P1");
        this.inventory.add(yellowMcLaren);
    }
} 
