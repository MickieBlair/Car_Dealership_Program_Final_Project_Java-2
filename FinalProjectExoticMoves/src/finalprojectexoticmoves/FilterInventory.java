//Mickie Blair
//Final Project - Exotic Moves
//Filter Inventory Class extends Inventory

package finalprojectexoticmoves;

import java.util.ArrayList;

public class FilterInventory extends Inventory {
    private ArrayList <Car> filterResults;
    private ArrayList <String> userSelectedBrands;
    private int maxPrice;
    private ArrayList <String> userSelectedColors;
    private String userSelectedStyle;
    
    /**
     * Constructor
     */
    FilterInventory(){
        super();
        this.filterResults = new ArrayList<>();
        this.userSelectedBrands = new ArrayList<>(); 
        this.maxPrice = 400000;
        this.userSelectedColors = new ArrayList<>();
        this.userSelectedStyle = "All Styles";
    }
    
    /**
     * Add To Brands ArrayList
     * @param b brand
     */
    public void addToBrands(String b){
        this.userSelectedBrands.add(b);
    }
    
    /**
     * Remove From Brands ArrayList
     * @param b brand
     */
    public void removeFromBrands(String b){
        this.userSelectedBrands.remove(b);
    }
    
    /**
     * Get Brands
     * @return Brands ArrayList
     */
    public ArrayList<String> getBrands(){
        return this.userSelectedBrands;
    }
    
    /**
     * Set Max Price
     * @param max Max Price
     */
    public void setMaxPrice (int max){
        this.maxPrice = max;  
    }
    
    /**
     * Get Max Price
     * @return Max Price
     */
    public int getMaxPrice(){
        return this.maxPrice;
    }
    
    /**
     * Add To Colors ArrayList
     * @param c Color
     */
    public void addToColors(String c){
        this.userSelectedColors.add(c);
    }
    
    /**
     * Remove From Colors ArrayList
     * @param c Color
     */
    public void removeFromColors(String c){
        this.userSelectedColors.remove(c);
    }
    
    /**
     * Get Color
     * @return Colors ArrayList
     */
    public ArrayList<String> getColors(){
        return this.userSelectedColors;
    }
    
    /**
     * Set User Selected Style
     * @param s Style
     */
    public void setUserSelectedStyle (String s){
        this.userSelectedStyle = s;
    }
    
    /**
     * Get User Selected Style
     * @return Style
     */
    public String getUserSelectStyle (){
        return this.userSelectedStyle;
    }
     
    /**
     * Compare Car Brand to Brand ArrayList
     * @param index index of Car Inventory
     * @return true/false Brand On List
     */
    public Boolean compareBrands(int index){
        boolean brandOnList = false;
        int brandIndex = 0;

        //compare inventory brand to car brand on list
        while (!brandOnList && brandIndex<this.userSelectedBrands.size())
        {
            if (this.userSelectedBrands.get(brandIndex).equals(getInventory().get(index).getBrand()))
            {
                //if on list set Brand on List to true
                brandOnList = true;
            }

            brandIndex++;
        }

        //return Brand on List
        return brandOnList;
    }
    
    /**
     * Compare Car Color to Color ArrayList
     * @param index index of Car Inventory
     * @return true/false Color On List
     */
    public Boolean compareColors(int index){
        boolean colorOnList = false;
        int colorIndex = 0;

        //compare inventory color to car color on list
        while (!colorOnList && colorIndex<this.userSelectedColors.size())
        {
            if (this.userSelectedColors.get(colorIndex).equals(getInventory().get(index).getColor()))
            {
                //if on list set Color on List to true
                colorOnList = true;
            }

            colorIndex++;
        }

        //return Color on List
        return colorOnList;
    }

    /**
     * Update Filter Results
     */
   public void updateFilterResults(){
        //set filter results to a copy of the inventory ArrayList
        this.filterResults = new ArrayList<>(getInventory());
        
        //loop through filter results, if criteria are not a match
        //remove from filter Results.  If criteria is empty(no selection)
        //skip over section
        for (int index = 0; index < getInventory().size(); index++)
        {
            //for brand
            if(!this.userSelectedBrands.isEmpty())
            {
                if (!compareBrands(index))
                {
                   this.filterResults.remove(getInventory().get(index)); 
                }
            }

            //for price
            if(this.maxPrice!=400000)
            {
                if (this.maxPrice < getInventory().get(index).getPrice())
                {
                    this.filterResults.remove(getInventory().get(index)); 
                }
            }

            //for color
            if(!this.userSelectedColors.isEmpty())
            {
                if (!compareColors(index))
                {
                    this.filterResults.remove(getInventory().get(index)); 
                } 
            }

            //for style
            if(!this.userSelectedStyle.equals("All Styles"))
            {
                if (this.userSelectedStyle.equals("Hard-Top"))
                {
                    if(getInventory().get(index).getConvertible())
                    {
                        this.filterResults.remove(getInventory().get(index)); 
                    }
                }
                
                else
                {
                    if(!getInventory().get(index).getConvertible())
                    {
                        this.filterResults.remove(getInventory().get(index)); 
                    }
                    
                }
            } 
        }
    }
    
   /**
    * Get Filter Results
    * @return Filter Results Array List
    */
    public ArrayList<Car> getFilterResults(){
        return this.filterResults;
    }
    
    /**
     * Clear Filter Results ArrayList
     */
    public void clearFilterResults(){
        this.filterResults.clear();
    }
    
    
    
}
