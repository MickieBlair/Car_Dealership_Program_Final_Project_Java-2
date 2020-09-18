//Mickie Blair
//Final Project - Exotic Moves
//Customer Class

package finalprojectexoticmoves;

public class Customer {
    
    private String firstName;
    private String lastName;
    private String ccNumber;
    private String expDate;
    private String ccvNumber;
    
    /**
     * Constructor - no args
     */
    Customer(){
        this.firstName= "";
        this.lastName = "";
        this.ccNumber = "";
        this.expDate = "";
        this.ccvNumber = "";
    }
    
    /**
     * Set First Name
     * @param fn First Name
     * @throws InvalidInputException 
     */
    public void setFirstName(String fn) throws InvalidInputException
    {
        boolean isValid = true;
        int index = 0;
        
        if (fn.equals(""))
        {
            throw new InvalidInputException("First Name (Required)");
        }
        
        else
        {
            while (isValid && index < fn.length())
            {
                if (!Character.isLetter(fn.charAt(index)))
                {
                    isValid = false;
                    throw new InvalidInputException("Name must be letters only");
                }
                
                index++;
            } 
        } 
        
        this.firstName = fn;
    }
    
    /**
     * Set Last Name
     * @param ln Last Name
     * @throws InvalidInputException 
     */
    public void setLastName(String ln) throws InvalidInputException
    {
        boolean isValid = true;
        int index = 0;
        
        if (ln.equals(""))
        {
            throw new InvalidInputException("Last Name (Required)");
        }
        
        else 
        {
            while (isValid && index < ln.length())
            {
                if (!Character.isLetter(ln.charAt(index)))
                {
                    isValid = false;
                    throw new InvalidInputException("Name must be letters only");
                }
                
                index++;
            } 
        } 
        
        this.lastName = ln;
    }
    
    /**
     * Set Credit Card Number
     * @param cc credit card number
     * @throws InvalidInputException 
     */
    public void setCreditCardNumber(String cc) throws InvalidInputException
    {
        boolean isValid = true;
        int index = 0;
        
        if (cc.equals(""))
        {
            throw new InvalidInputException("Credit Card Number (Required)");
        }
        
        else
        {
            while (isValid && index < cc.length())
            {
                if (!Character.isDigit(cc.charAt(index)))
                {
                    isValid = false;
                    throw new InvalidInputException("Credit Card Number "
                                    + "- Must be digits only");
                }
                
                index++;
            } 
        }
        
        if (cc.length()!= 16)
        {
            throw new InvalidInputException("Credit Card Number "
                                    + "- Must be 16 digits long");
        }
        

        
       this.ccNumber = cc;
        
    }
    
    /**
     * Set CCV Number
     * @param ccv
     * @throws InvalidInputException 
     */
    public void setCCVNumber(String ccv) throws InvalidInputException
    {
        boolean isValid = true;
        int index = 0;
        
        if (ccv.equals(""))
        {
            throw new InvalidInputException("CCV Number (Required)");
        }
        
        else
        {
            while (isValid && index < ccv.length())
            {
                if (!Character.isDigit(ccv.charAt(index)))
                {
                    isValid = false;
                    throw new InvalidInputException("CCV Number "
                                    + "- Must be digits only");
                }
                
                index++;
            } 
        }
        
        if (ccv.length()!= 3)
        {
            throw new InvalidInputException("CCV Number "
                                    + "-Must be 3 digits long");
        }
        
       this.ccvNumber = ccv;
        
    }
    
    /**
     * Set Expiration Date
     * @param mm Month
     * @param yyyy Year
     * @throws InvalidInputException 
     */
    public void setExpDate(String mm, String yyyy) throws InvalidInputException{
        if (mm==null || yyyy==null)
        {
            throw new InvalidInputException("Card Expiration Date(Required)");
        }
                
        else
        {
          this.expDate = mm + "/" + yyyy;
        } 
    }  

    /**
     * Get First Name
     * @return first Name
     */
    public String getFirstName(){
        return this.firstName;
    } 
    
    /**
     * Get Last Name
     * @return last name
     */
    public String getLastName(){
        return this.lastName;
    }
    
    /**
     * Get Credit Card Number
     * @return Credit Card Number
     */
    public String getCCNumber(){
        return this.ccNumber;
    }
    
    /**
     * Get CCV Number
     * @return CCV number
     */
    public String getCCVNumber(){
        return this.ccvNumber;
    }
    
    /**
     * Get Expiration Date
     * @return expiration Date
     */
    public String getExpDate(){
        return this.expDate;
    }  
}
