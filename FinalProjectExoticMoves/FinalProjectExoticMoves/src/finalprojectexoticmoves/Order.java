//Mickie Blair
//Final Project - Exotic Moves
//Order Class

package finalprojectexoticmoves;

public class Order {
    
    private Car newCar;
    private Customer customer;
    
    /**
     * Constructor
     * @param purchase Car to purchase
     */
    Order(Car purchase){
        
        newCar = purchase;
        customer = null;
    }
    
    /**
     * Set New Car
     * @param purchase Car to purchase
     */
    public void setNewCar(Car purchase){
        newCar = purchase;
    }
    
    /**
     * Get New Car
     * @return New Car
     */
    public Car getNewCar(){
        return this.newCar;
    }
    
    /**
     * Set Customer
     * @param c Customer
     */
    public void setCustomer(Customer c){
        customer = c;
    }
    
    /**
     * Get Customer
     * @return customer
     */
    public Customer getCustomer(){
        return this.customer;
    }

}
