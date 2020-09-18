//Mickie Blair
//Final Project - Exotic Moves
//Exotic Moves GUI

package finalprojectexoticmoves;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FinalProjectExoticMovies extends Application {
    //objects
    Customer customer;
    FilterInventory filters;
    Order order;
    
    //controls(Only controls needing to be accessed outside declared scope)
    CheckBox aston;
    CheckBox ferrari;
    CheckBox lambo;
    CheckBox maserati;
    CheckBox mcLaren; 
    CheckBox allBrands;
    Slider priceSlider;
    CheckBox black;
    CheckBox blue;
    CheckBox green;
    CheckBox orange;
    CheckBox red;
    CheckBox white;
    CheckBox yellow;
    CheckBox allColors;
    ToggleGroup styleToggle;
    Label resultsLabel;
    Label numberLabel ;
    TextField firstName;
    TextField lastName;
    TextField ccNumber;
    TextField ccvNum;
    ComboBox <String> month;
    ComboBox <String> year;
    Label expDateError;
        
    //containers(Only containers needing to be accessed outside declared scope)
    BorderPane all;
    HBox logoBannerBox;
    VBox resultsBox;
    HBox resultsNumberLabels;
    ScrollPane carDisplayScroll;
    VBox filterCriteria;
    VBox carDetails;
    HBox filterByHeader;
    VBox noMatches;
    VBox customerInformation;
    VBox customerReceipt;
    
    @Override
    public void start(Stage primaryStage) {
        
        //create new filterInventory
        filters = new FilterInventory();
        
        //createLogoBannerBox
        LogoBannerBox();
        
        //create and display car
        displayCars(filters.getInventory());
        
        //create and display Filter Box
        filterInventory();
        
        //container for all
        all = new BorderPane();
        all.setId("all");
        
        //set borderPane
        all.setTop(logoBannerBox);
        all.setCenter(resultsBox);
        all.setLeft(filterCriteria);
        
        Scene scene = new Scene(all, 1343, 843);
        
        //set stylesheet
        scene.getStylesheets().add("style.css");
        
        primaryStage.setTitle("Exotic Moves");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * Customer Receipt
     */
    public void customerReceipt(){
        //VBox for Customer receipt
        customerReceipt = new VBox();
        
        //Customer receipt VBox Contents
        HBox receiptHeader = new HBox();
        receiptHeader.setId("customerLabelBox");
        
        Label receiptLabel = new Label("Customer Receipt");
        receiptLabel.setPadding(new Insets(0,0,0, 10));
        
        receiptHeader.getChildren().addAll(receiptLabel);
               
        HBox confirmLabelBox = new HBox();
        
        Label confirmationLabel = new Label();
        confirmationLabel.setId("confirmation");
        
        confirmationLabel.setText(String.format("%s %s, Congratulations on "
                + "your new car!", order.getCustomer().getFirstName(),
                order.getCustomer().getLastName()));
        
        confirmationLabel.setPadding(new Insets(20,0,20, 0));
        
        confirmLabelBox.getChildren().addAll(confirmationLabel);
        
        confirmLabelBox.setAlignment(Pos.CENTER);
        
        HBox purchaseDetailsBox = new HBox ();
        
        Label purchaseDetails = new Label ("Purchase Details");
        purchaseDetails.setPadding(new Insets(0,0,0, 30));
        purchaseDetails.setId("receiptDetailsLabel");
        purchaseDetails.setPrefWidth(700);
        
        purchaseDetailsBox.getChildren().addAll(purchaseDetails);

        Label saleDateLabel = new Label ("Sale Date:");
        saleDateLabel.setPrefWidth(160);
        saleDateLabel.setId("boldLabel");
        saleDateLabel.setPadding(new Insets(15,0,10, 30));
        
        //get current date
        LocalDate date = LocalDate.now();
        
        //Format Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        Label dateInFormat = new Label();
        dateInFormat.setText(date.format(formatter));
        dateInFormat.setId("info");
        dateInFormat.setPadding(new Insets(15,0,10,0));
        
        HBox dateBox = new HBox();
        dateBox.getChildren().addAll(saleDateLabel, dateInFormat);
        
        Label newCarLabel = new Label ();
        newCarLabel.setText(order.getNewCar().getBrand());
        newCarLabel.setId("newCarLabel");
        newCarLabel.setPrefWidth(550);
        newCarLabel.setPadding(new Insets(10,0,0, 30));
        
        Label newModelLabel = new Label();
        newModelLabel.setText(order.getNewCar().getModel());
        newModelLabel.setId("newModelLabel");
        newModelLabel.setPadding(new Insets(0,0,20, 30));
        
        VBox carModelBox = new VBox();
        carModelBox.getChildren().addAll(newCarLabel, newModelLabel);
              
        Label total = new Label();
        total.setText(String.format("$%,8d", order.getNewCar().getPrice()));
        total.setId("newPriceLabel");
        total.setPadding(new Insets(10,0,0,0));

        HBox carAndTotal = new HBox();
        carAndTotal.getChildren().addAll(carModelBox, total);

        Label totalLabel = new Label("Total (incl. tax of $0.00):");
        totalLabel.setId("boldLabel");
        totalLabel.setPrefWidth(535);
        totalLabel.setAlignment(Pos.CENTER_RIGHT);
        totalLabel.setPadding(new Insets(7, 35, 0 ,10));
        
        Label total2 = new Label();
        total2.setText(String.format("$%,8d", order.getNewCar().getPrice()));
        total2.setId("newPriceLabel2");
        total2.setPadding(new Insets(0,0,15,0));
        
        HBox finalTotal = new HBox();
        finalTotal.getChildren().addAll(totalLabel, total2);

        Label methodLabel = new Label("Payment Method");
        methodLabel.setId("receiptDetailsLabel");
        methodLabel.setPrefWidth(350);
        methodLabel.setPadding(new Insets(0,0,0, 30));
        
        Label amountLabel = new Label ("Amount");
        amountLabel.setId("receiptDetailsLabel");
        amountLabel.setPrefWidth(350);
        amountLabel.setPadding(new Insets(0, 0, 0 ,200));
        
        HBox methodAndAmount = new HBox ();
        methodAndAmount.getChildren().addAll(methodLabel, amountLabel);
        
        VBox creditBox = new VBox();
        Label creditLabel = new Label("Credit Card");
        creditLabel.setPadding(new Insets(10,0,0, 30));
        creditLabel.setId("newModelLabel");
        creditLabel.setPrefWidth(550);
        
        Label ccLabel = new Label(order.getCustomer().getCCNumber());
        ccLabel.setId("newModelLabel");
                creditBox.getChildren().addAll(creditLabel, ccLabel);
        ccLabel.setPadding(new Insets(0,0,40, 30));
        
        HBox amountHBox = new HBox();
        
        Label total3 = new Label();
        total3.setText(String.format("$%,8d", order.getNewCar().getPrice()));
        total3.setId("newModelLabel");
        total3.setPadding(new Insets(10,0,0,0));
        
        amountHBox.getChildren().addAll(creditBox, total3);
        
        HBox buttonsBox = new HBox();
        buttonsBox.setMaxWidth(700);
        buttonsBox.setMinWidth(700);
        buttonsBox.setAlignment(Pos.CENTER);
        
        Button backtoInventory = new Button ("< Back to Results");
        
        backtoInventory.setPrefWidth(200);
        
        //set action for back to inventory button
        backtoInventory.setOnAction(event -> 
        {
           all.setLeft(filterCriteria);
           all.setCenter(resultsBox);
           
        });
        
        Button submit = new Button ("Back to Home >");
        
        submit.setPrefWidth(200);
        
        //set action for submit button
        submit.setOnAction(event -> 
        {
            //clear results arrayList
            filters.clearFilterResults();
            
            //create and display car
            displayCars(filters.getInventory());
        
            //create and display Filter Box
            filterInventory();
 
            all.setLeft(filterCriteria);
            all.setCenter(resultsBox);  
        });
        
        buttonsBox.getChildren().addAll(backtoInventory, submit );
        
        buttonsBox.setSpacing(235);
        
        VBox detailsAll = new VBox();
        detailsAll.getChildren().addAll( purchaseDetails, 
                                    dateBox, carAndTotal, finalTotal,
                                    methodAndAmount, amountHBox, buttonsBox);
        
        detailsAll.setPadding(new Insets(0,0,0,300));
         
        customerReceipt.getChildren().addAll(receiptHeader,confirmLabelBox, detailsAll);

        customerReceipt.setId("customerInformation");     
    }
    
    /**
     * Customer Information
     */
    public void customerInformation(){
        //Customer Info VBox
        customerInformation = new VBox();
        
        //Contents of Customer Info VBox
        HBox customerHeader = new HBox();
        
        Label customerLabel = new Label("Customer Information");
        customerLabel.setPadding(new Insets(0,0,0, 10));
        
        customerHeader.getChildren().addAll(customerLabel);
        customerHeader.setId("customerLabelBox");
        
        firstName = new TextField();
        firstName.setPromptText("Enter First Name");
        firstName.setFocusTraversable(false);
        firstName.setPrefWidth(500);
        
        lastName = new TextField();
        lastName.setPromptText("Enter Last Name");
        lastName.setFocusTraversable(false);
        lastName.setPrefWidth(500);
        
        HBox namesBox = new HBox();
        namesBox.getChildren().addAll(firstName,lastName );
        
        namesBox.setSpacing(15);
        
        ccNumber = new TextField();
        ccNumber.setPromptText("Enter Credit Card Number");
        ccNumber.setFocusTraversable(false);
        ccNumber.setMaxWidth(1015);
 
        VBox expDateBox = new VBox();
        
        Label expDateLabel = new Label ("Expiration Date");
        expDateLabel.setId("expDate");
        
        HBox expDateErrorBox = new HBox();
        expDateError = new Label ("");
        expDateError.setId("errorDate");
        expDateErrorBox.setAlignment(Pos.CENTER);
        expDateErrorBox.getChildren().addAll(expDateError);
        
        month = new ComboBox<>();
        month.getItems().addAll("1", "2", "3", "4", "5", "6",
                                "7", "8", "9", "10", "11", "12");
        month.setPromptText("Month");
        month.setVisibleRowCount(3);
        month.setPrefWidth(200);
        month.setFocusTraversable(false);
        
        month.setId("combo");

        //month set on mouse Pressed to return to Black font after changed
        //to red from error
        month.setOnMousePressed(event -> 
        {
            month.setId("combo");
            month.setPromptText("Month");
            expDateError.setText("");
        });
        
        
        year = new ComboBox<>();
        year.getItems().addAll("2019", "2020", "2021", "2022", "2023", "2024",
                                "2025", "2026", "0227", "2028", "2029");
        year.setPromptText("Year");
        year.setVisibleRowCount(3);
        year.setPrefWidth(200);
        year.setFocusTraversable(false);
        
        year.setId("combo");

        //yet set on mouse Pressed to return to Black font after changed
        //to red from error
        year.setOnMousePressed(event -> 
        {
            year.setId("combo");
            year.setPromptText("Year");
            expDateError.setText("");
        });               
        
        HBox dateExp = new HBox();
        dateExp.getChildren().addAll(month, year );
        dateExp.setSpacing(15);
                
        expDateBox.getChildren().addAll(expDateLabel, dateExp,
                                expDateErrorBox);
                
        VBox ccvBox = new VBox();
        Label ccvLabel = new Label ("CCV");
        ccvLabel.setId("ccv");
        
        ccvNum = new TextField();
        ccvNum.setPrefWidth(500);
        ccvNum.setFocusTraversable(false);
                
        Label ccvError = new Label ("");
        ccvError.setId("errorCCV");
        
        ccvBox.getChildren().addAll(ccvLabel, ccvNum,
                                ccvError);
        
        HBox expDateCCV = new HBox();
        
        expDateCCV.getChildren().addAll(expDateBox, ccvBox );
        expDateCCV.setSpacing(100);
        
        HBox buttonsBox = new HBox();
        
        Button backtoInventory = new Button ("< Back to Results");
        
        backtoInventory.setPrefWidth(200);
        
        //set action for back to inventory button
        backtoInventory.setOnAction(event -> 
        {
           all.setLeft(filterCriteria);
           all.setCenter(resultsBox);
           
        });
        
        Button submit = new Button ("Submit");
        
        submit.setPrefWidth(200);
        
        //set action for submit button, SubmitOrder Handler
        submit.setOnAction(new SubmitOrderHandler());
        
        buttonsBox.getChildren().addAll(backtoInventory, submit );
        
        buttonsBox.setSpacing(615);
       
        VBox custInfo = new VBox();
        
        custInfo.getChildren().addAll(namesBox, ccNumber, expDateCCV, buttonsBox);
        
        custInfo.setPadding(new Insets(100,0,50,150));
        custInfo.setSpacing(40);
        
        customerInformation.getChildren().addAll(customerHeader,custInfo);

        customerInformation.setId("customerInformation");           
    }
    
    /**
     * SubmitOrderHandler
     */
    public class SubmitOrderHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle (ActionEvent event)
        {
            boolean isValid = true;
            
            //new Customer
            customer = new Customer();
            
            //try/catch to valid input and throw invalid input exceptions
            //sets is valid to false
            try
            {
                customer.setFirstName(firstName.getText());
            }

            catch (InvalidInputException e)
            {
                firstName.setText("");
                firstName.setPromptText(e.getMessage());
                firstName.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }
            
            try
            {
                customer.setLastName(lastName.getText());
            }

            catch (InvalidInputException e)
            {
                lastName.setText("");
                lastName.setPromptText(e.getMessage());
                lastName.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }
            
            try
            {
                customer.setCreditCardNumber(ccNumber.getText());
            }

            catch (InvalidInputException e)
            {
                ccNumber.setText("");
                ccNumber.setPromptText(e.getMessage());
                ccNumber.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }

            try
            {
                customer.setCCVNumber(ccvNum.getText());
            }

            catch (InvalidInputException e)
            {
                ccvNum.setText("");
                ccvNum.setPromptText(e.getMessage());
                ccvNum.setStyle("-fx-prompt-text-fill: red;");
                isValid = false;
            }
            
            try
            {
                customer.setExpDate(month.getValue(), year.getValue());
            }

            catch (InvalidInputException e)
            {
                expDateError.setText(e.getMessage());
                month.setValue(null);
                year.setValue(null);
                
                month.setId("comboError");
                year.setId("comboError");
                isValid = false;
            }
                       
            //if all is valid
            if (isValid)
            {
                // set order customer
                order.setCustomer(customer);
                
                //create customer receipt
                customerReceipt();
                
                //set center to receipt
                all.setCenter(customerReceipt); 
            }
        }
    }
    
    /**
     * Update Results
     */    
    public void updateResults(){
        all.setCenter(null);
        
        filters.updateFilterResults();
        
        displayCars(filters.getFilterResults());
        
        //if filter results is empty, change box to no matches box
        if (filters.getFilterResults().isEmpty())
        {
            noMatches();
        }
        else // set label with number of cars that match and show results
        {
            numberLabel.setText(String.format("%d matching car(s)",
                filters.getFilterResults().size()));
            
            all.setCenter(resultsBox); 
        }
    }
    
    /**
     * No Matches Box
     */
    public void noMatches(){
        //container for no matches
        noMatches = new VBox();
        
        //create contents
        Label noMatchesLabel = new Label("Results:  "); 
        noMatchesLabel.setId("filterLabel");
        noMatchesLabel.setPadding(new Insets(0, 0, 0, 10));
        
        Label noNumLabel = new Label();
        noNumLabel.setId("filterLabel");
        noNumLabel.setText(String.format("%d cars",
                filters.getFilterResults().size()));
        
        HBox noMatchBothLabels = new HBox();
        noMatchBothLabels.setMaxSize(875, 50);
        noMatchBothLabels.setMinSize(875, 50);
        noMatchBothLabels.setAlignment(Pos.CENTER_LEFT);
        
        noMatchBothLabels.getChildren().addAll(noMatchesLabel, noNumLabel );
        noMatchBothLabels.setId("labelBoxHeader");
        
        GridPane noCars = new GridPane();
        noCars.setId("carGrid");
        
        VBox noCarsDisplay = new VBox();
        
        Label sorryLabel = new Label();
        sorryLabel.setText("No matches in our Inventory");
        sorryLabel.setId("noMatchLabel");
        
        noCarsDisplay.getChildren().addAll(sorryLabel);
        
        noCars.add(noCarsDisplay, 0, 0);
        
        ScrollPane noCarsPane = new ScrollPane(noCars);
        noCarsPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        noCarsPane.setMaxSize(875, 635);
        noCarsPane.setMinSize(875, 635);
        noCarsPane.setId("scrollCars");
        
        noMatches.getChildren().addAll(noMatchBothLabels, noCarsPane );
        noMatches.setId("resultsBox");
        
        //set the center to the no matches box
        all.setCenter(noMatches); 
    }
    
    /**
     * Filter Inventory
     */
    public void filterInventory(){
        //filter Criteria VBox
        filterCriteria = new VBox();
        
        //create Contents
        Label filterByLabel = new Label("Filters"); 
        filterByLabel.setId("filterLabel");
        
        Button resetFilters = new Button ("Reset Filters");
        resetFilters.setId("reset");
        resetFilters.setAlignment(Pos.BASELINE_CENTER);
        
        HBox filtersReset = new HBox();
        filtersReset.getChildren().addAll(filterByLabel, resetFilters);
        filtersReset.setSpacing(220);
        filtersReset.setId("labelBoxHeader");
        filtersReset.setMaxSize(450, 50);
        filtersReset.setMinSize(450, 50);
        filtersReset.setAlignment(Pos.CENTER_LEFT);
        filtersReset.setPadding(new Insets(0,0,0,10));
        
        //brand filter
        VBox brandFilterBox = new VBox();
        
        Label brandFilterLabel = new Label ("Filter By Brand");
        brandFilterLabel.setId("minorLabel");
        
        VBox brandLabelBox = new VBox();
        brandLabelBox.getChildren().addAll(brandFilterLabel);
        brandLabelBox.setId("minorLabelBox");
        brandLabelBox.setPadding(new Insets(10));
        brandLabelBox.setMaxSize(450, 40);
        brandLabelBox.setMinSize(450, 40);
        brandLabelBox.setAlignment(Pos.CENTER_LEFT);
                        
        HBox labelsHBox = new HBox();
        labelsHBox.setId("choices");
        labelsHBox.setMaxWidth(450);
        labelsHBox.setMinWidth(450);
        
        VBox leftBox = new VBox();
        VBox rightBox = new VBox();
        
        aston = new CheckBox("Aston Martin");
        aston.setId("aston");
               
        ferrari = new CheckBox ("Ferrari");
        ferrari.setId("ferrari");
        
        lambo = new CheckBox ("Lamborghini");
        lambo.setId("lambo");
        
        maserati = new CheckBox ("Maserati");
        maserati.setId("maserati");
        
        mcLaren = new CheckBox ("McLaren");
        mcLaren.setId("mcLaren");
        
        allBrands = new CheckBox ("All Brands");
        allBrands.setId("allBrands");
        
        leftBox.getChildren().addAll(aston, ferrari, lambo);
        leftBox.setPadding(new Insets(0,110,20, 0));
        
        rightBox.getChildren().addAll(maserati, mcLaren, allBrands);
        labelsHBox.getChildren().addAll(leftBox, rightBox);
               
        brandFilterBox.getChildren().addAll(brandLabelBox, labelsHBox);
         
        //set actions for brand checkboxes
        BrandCheckBoxActions();
        
        //price filter
        VBox priceFilterBox = new VBox();
        
        Label priceFilterLabel = new Label ("Filter By Max Price");
        priceFilterLabel.setId("minorLabel");
        
        VBox priceLabelBox = new VBox();
        priceLabelBox.getChildren().addAll(priceFilterLabel);
        priceLabelBox.setId("minorLabelBox");
        priceLabelBox.setPadding(new Insets(10));
        priceLabelBox.setMaxSize(450, 40);
        priceLabelBox.setMinSize(450, 40);
        priceLabelBox.setAlignment(Pos.CENTER_LEFT);
        
        VBox priceSliderBox = new VBox();
        
        priceSlider = new Slider(100000, 400000, 400000);
        priceSlider.setShowTickMarks(true);
        priceSlider.setMajorTickUnit(100000);
        priceSlider.setShowTickLabels(true);
        
        //set Actions for price slider
        PriceSliderActions();
                
        priceSliderBox.getChildren().addAll(priceSlider);
        priceSlider.setSnapToTicks(true);        
                
        priceSliderBox.setPadding (new Insets(0,30,0,20));
        priceSliderBox.setMaxWidth(450);
        priceSliderBox.setMinWidth(450);
        priceSliderBox.setAlignment(Pos.CENTER);
        priceSliderBox.setId("choices");

        priceFilterBox.getChildren().addAll(priceLabelBox, priceSliderBox);

        //color filter
        VBox colorFilterBox = new VBox();
        
        Label colorFilterLabel = new Label ("Filter By Color");
        colorFilterLabel.setId("minorLabel");
        
        VBox colorMinorLabelBox = new VBox();
        colorMinorLabelBox.getChildren().addAll(colorFilterLabel);
        colorMinorLabelBox.setId("minorLabelBox");
        colorMinorLabelBox.setPadding(new Insets(10));
        colorMinorLabelBox.setMaxSize(450, 40);
        colorMinorLabelBox.setMinSize(450, 40);
        colorMinorLabelBox.setAlignment(Pos.CENTER_LEFT);
        
        HBox colorLabelBox = new HBox();
        VBox left = new VBox();
        VBox center = new VBox();
        VBox right = new VBox();
        
        black = new CheckBox("Black");
        black.setId("black");
        
        blue = new CheckBox ("Blue");
        blue.setId("blue");
        
        green = new CheckBox ("Green");
        green.setId("green");
        
        orange = new CheckBox ("Orange");
        orange.setId("orange");
        
        red = new CheckBox ("Red");
        red.setId("red");
        
        white = new CheckBox ("White");
        white.setId("white");
        
        yellow = new CheckBox ("Yellow");
        yellow.setId("yellow");
        
        allColors = new CheckBox ("All Colors");
        yellow.setId("allColors");
        
        //set actions for color checkboxes
        ColorCheckBoxActions();

        left.getChildren().addAll(black, blue, green);
        left.setPadding(new Insets(0,30,20,0));
        left.setAlignment(Pos.CENTER_LEFT);
        center.getChildren().addAll(orange, red, allColors);
        center.setPadding(new Insets(0,15,0,0));
        right.getChildren().addAll(white, yellow);
        
        colorLabelBox.getChildren().addAll(left, center, right);
        colorLabelBox.setId("choices");
        colorLabelBox.setAlignment(Pos.CENTER);
        colorLabelBox.setMaxWidth(450);
        colorLabelBox.setMinWidth(450);

        colorFilterBox.getChildren().addAll(colorMinorLabelBox, colorLabelBox);
                      
        //convertible filter
        VBox styleFilterBox = new VBox();
        
        Label convertibleFilterLabel = new Label ("Filter By Style");
        convertibleFilterLabel.setId("minorLabel");
        
        VBox styleMinorLabelBox = new VBox();
        styleMinorLabelBox.getChildren().addAll(convertibleFilterLabel);
        styleMinorLabelBox.setId("minorLabelBox");
        styleMinorLabelBox.setPadding(new Insets(10));
        styleMinorLabelBox.setMaxSize(450, 40);
        styleMinorLabelBox.setMinSize(450, 40);
        styleMinorLabelBox.setAlignment(Pos.CENTER_LEFT);
        
        RadioButton allStyles = new RadioButton("All Styles");
        RadioButton hardTop = new RadioButton("Hard-Top");
        RadioButton convertible = new RadioButton ("Convertible");
        
        styleToggle = new ToggleGroup();
        hardTop.setToggleGroup(styleToggle);
        convertible.setToggleGroup(styleToggle);
        allStyles.setToggleGroup(styleToggle);
        allStyles.setSelected(true);
        
        //set actions for Toggle group
        styleToggle.selectedToggleProperty().addListener(new StyleListener());
        
        GridPane styleGridPane = new GridPane();
        styleGridPane.setId("choicesLast");
        styleGridPane.setAlignment(Pos.CENTER);
        styleGridPane.setMaxWidth(450);
        styleGridPane.setMinWidth(450);
        styleGridPane.setPadding(new Insets(10,0,10,0));

        styleGridPane.add(allStyles, 0, 0);
        
        styleGridPane.add(hardTop, 1, 0);
        
        styleGridPane.add(convertible, 2, 0);
       
        styleFilterBox.getChildren().addAll(styleMinorLabelBox, styleGridPane);
        
        //reset filters button Action
        resetFilters.setOnAction(event->{
            
                aston.setSelected(false);
                ferrari.setSelected(false);
                lambo.setSelected(false);
                maserati.setSelected(false);
                mcLaren.setSelected(false);
                allBrands.setSelected(false);
                black.setSelected(false);
                blue.setSelected(false);
                green.setSelected(false);
                orange.setSelected(false);
                red.setSelected(false);
                white.setSelected(false);
                yellow.setSelected(false);
                allColors.setSelected(false);
                priceSlider.setValue(400000);
                allStyles.setSelected(true);
                
                //clear results arrayList
                filters.clearFilterResults();
                
                updateResults();
        });

        filterCriteria.setId("criteria");
        
        filterCriteria.getChildren().addAll(filtersReset, brandFilterBox, 
                priceFilterBox, colorFilterBox, styleFilterBox);

        filterCriteria.setMaxSize(470,705);
        filterCriteria.setMinSize(470,705);
    }
    
    /**
     * Color CheckBox Actions
     */
    public void ColorCheckBoxActions(){
        //listeners for Color check box changes
        black.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(black.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(black.getText());
             }
             
             updateResults();  
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        blue.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(blue.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(blue.getText());
             }
             
             updateResults();
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        green.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(green.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(green.getText());
             }
             
             updateResults();
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        orange.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(orange.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(orange.getText());
             }
             
             updateResults();
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        red.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(red.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(red.getText());
             }
             
             updateResults();
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        white.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(white.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(white.getText());
             }
             
             updateResults();
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        yellow.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                          
             if (newValue)
             {
                 filters.addToColors(yellow.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromColors(yellow.getText());
             }
             
             updateResults();
             
             if (black.isSelected() && blue.isSelected() && green.isSelected() 
                && orange.isSelected() && red.isSelected()&& white.isSelected() 
                && yellow.isSelected())
               {
                 allColors.setSelected(true);
               }
             else
             {
                 allColors.setSelected(false);
             }
         }
        });
        
        allColors.setOnAction(event->{
            if(allColors.isSelected())
            {
                black.setSelected(true);
                blue.setSelected(true);
                green.setSelected(true);
                orange.setSelected(true);
                red.setSelected(true);
                white.setSelected(true);
                yellow.setSelected(true);
                
            }
            
            else
            {
                black.setSelected(false);
                blue.setSelected(false);
                green.setSelected(false);
                orange.setSelected(false);
                red.setSelected(false);
                white.setSelected(false);
                yellow.setSelected(false);
                
            }
        
        });
        
    }
    
    /**
     * Price Slider Actions
     */
    public void PriceSliderActions(){
        //listeners for Price Slider changes
         priceSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    
                    filters.setMaxPrice ((int)(double)new_val);
                    
                    updateResults();
                    
            }
        });
        
    }
    
    /**
     * Set Brand CheckBox Actions
     */
    public void BrandCheckBoxActions(){
        //listeners for Brand check box changes
        aston.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
       
             if (newValue)
             {
                 filters.addToBrands(aston.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromBrands(aston.getText());
             }
                
             updateResults();
             
             if (aston.isSelected() && ferrari.isSelected() && lambo.isSelected() 
                && maserati.isSelected() && mcLaren.isSelected())
             {
                allBrands.setSelected(true);
             }
             else
             {
                 allBrands.setSelected(false);
             }
             
         }
        });
        
        ferrari.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {

             if (newValue)
             {
                 filters.addToBrands(ferrari.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromBrands(ferrari.getText());
             }
                          
             updateResults();
             
             if (aston.isSelected() && ferrari.isSelected() && lambo.isSelected() 
                && maserati.isSelected() && mcLaren.isSelected())
               {
                 allBrands.setSelected(true);
               }
             else
             {
                 allBrands.setSelected(false);
             }
         }
        });
        
        lambo.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                         
             if (newValue)
             {
                 filters.addToBrands(lambo.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromBrands(lambo.getText());
             }
             
             updateResults();
             
             if (aston.isSelected() && ferrari.isSelected() && lambo.isSelected() 
                && maserati.isSelected() && mcLaren.isSelected())
               {
                 allBrands.setSelected(true);
               }
             else
             {
                 allBrands.setSelected(false);
             }
         }
        });
               
        maserati.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
                         
             if (newValue)
             {
                 filters.addToBrands(maserati.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromBrands(maserati.getText());
             }
             
             updateResults();
             
             if (aston.isSelected() && ferrari.isSelected() && lambo.isSelected() 
                && maserati.isSelected() && mcLaren.isSelected())
               {
                 allBrands.setSelected(true);
               }
             else
             {
                 allBrands.setSelected(false);
             }
         }
        });
        
        mcLaren.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
         public void changed(ObservableValue<? extends Boolean> observable, 
                 Boolean oldValue, Boolean newValue) {
             
             if (newValue)
             {
                 filters.addToBrands(mcLaren.getText());
             }
             
             if (!newValue)
             {
                 filters.removeFromBrands(mcLaren.getText());
             }
             
            updateResults();
            
            if (aston.isSelected() && ferrari.isSelected() && lambo.isSelected() 
                && maserati.isSelected() && mcLaren.isSelected())
               {
                 allBrands.setSelected(true);
               }
            else
             {
                 allBrands.setSelected(false);
             }
         }
        });
        
        allBrands.setOnAction(event->{
            if(allBrands.isSelected())
            {
                aston.setSelected(true);
                ferrari.setSelected(true);
                lambo.setSelected(true);
                maserati.setSelected(true);
                mcLaren.setSelected(true); 
            }
            
            else
            {
                aston.setSelected(false);
                ferrari.setSelected(false);
                lambo.setSelected(false);
                maserati.setSelected(false);
                mcLaren.setSelected(false);
            }
        
        });
    }
    
    /**
     * Style Listener (Convertible True/False/Both)
     */
    public class StyleListener implements ChangeListener<Toggle>{
        @Override
        public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
                       
            RadioButton selected = (RadioButton)styleToggle.getSelectedToggle();
            
            filters.setUserSelectedStyle(selected.getText());
            
            updateResults();
        }
    }
    
    
    /**
     * Display Cars 
     * @param carList List of Cars 
     */
    public void displayCars(ArrayList <Car> carList){
        int MAX_COLUMN = 4;
        int column = 0;
        int row = 0;
        int index = 0;
        int columnCount = 0;
        
        //results box
        resultsBox = new VBox();
        
        //create Header
        resultsLabel = new Label("Results:  "); 
        resultsLabel.setId("filterLabel");
        resultsLabel.setPadding(new Insets(0, 0, 0, 10));
        
        numberLabel = new Label();
        numberLabel.setId("filterLabel");
        numberLabel.setText(String.format("%d cars in inventory",
                filters.getInventory().size()));
        
        resultsNumberLabels = new HBox();
        
        resultsNumberLabels.getChildren().addAll(resultsLabel, numberLabel );
        resultsNumberLabels.setId("labelBoxHeader");
        resultsNumberLabels.setMaxSize(875, 50);
        resultsNumberLabels.setMinSize(875, 50);
        resultsNumberLabels.setAlignment(Pos.CENTER_LEFT);
        
        
        GridPane cars = new GridPane();
        cars.setId("carGrid");
        cars.setHgap(10);
        cars.setVgap(10);
        
        while (index <carList.size())
        {
            cars.add(carBox(carList,index),column, row);
            index++;
            columnCount++;
            column++;
            if (columnCount == MAX_COLUMN)
            {
                row++;
                column =0;
                columnCount = 0;
            }
        }

        carDisplayScroll = new ScrollPane(cars);
        carDisplayScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        carDisplayScroll.setMaxSize(875, 635);
        carDisplayScroll.setMinSize(875, 635);
        carDisplayScroll.setId("scrollCars");
         
        resultsBox.getChildren().addAll(resultsNumberLabels, carDisplayScroll);
        resultsBox.setId("resultsBox");
        resultsBox.setMaxWidth(885);
        resultsBox.setMinWidth(885);
    }
    
    /**
     * Create Individual Car Box
     * @param carList List of Cars
     * @param i Index of Car
     * @return VBOX of car
     */
    public StackPane carBox(ArrayList <Car> carList, int i){
        StackPane borderBox = new StackPane();
        borderBox.setId("stackBorder");
        borderBox.setPrefSize(200, 50);
        
        VBox carVBox = new VBox();
        carVBox.setId("carBox");
                      
        ImageView carImage = new ImageView(carList.get(i).getImage());
        carImage.setFitWidth(200);
        carImage.setPreserveRatio(true);
        carImage.setId("carImage");
            
        Label brand = new Label();
        brand.setText(carList.get(i).getBrand());
        brand.setId("brand");
        
        Label model = new Label();
        model.setText(carList.get(i).getModel());
        model.setId("model");
        
        Label price = new Label();
        price.setText(String.format
                        ("$%,8d",carList.get(i).getPrice()));
        price.setId("price");
        
        
        carVBox.getChildren().addAll(carImage, brand, model, price);
        
        carVBox.setSpacing(10);
        carVBox.setAlignment(Pos.CENTER);
        
        //set Action for clicking on the VBox of the car
        carVBox.setOnMouseClicked(event -> 
        {
           viewDetails(carList, i);
           all.setCenter(carDetails);  
        });
        
        borderBox.getChildren().addAll(carVBox);

        //return car VBox in StackPane for border
        return borderBox;
    }
    
    /**
     * View Details
     * @param carList List of Cars
     * @param i index of car
     */
    public void viewDetails(ArrayList <Car> carList, int i){
        carDetails = new VBox();
        carDetails.setId("detailsBox");
        
        //image
        ImageView carImage = new ImageView
                            (carList.get(i).getImage());
        carImage.setFitWidth(680);
        carImage.setPreserveRatio(true);
        carImage.setId("largeCarImage");
        
        HBox imageBox = new HBox();
        imageBox.getChildren().addAll(carImage);
        
        //brand
        Label brand = new Label();
        brand.setText(carList.get(i).getBrand());
        brand.setId("detailsBrand");
        brand.setAlignment(Pos.CENTER_LEFT);
        brand.setPrefWidth(340);
        
        //price
        Label price = new Label();
        price.setText(String.format
                        ("$%,8d",carList.get(i).getPrice()));
        
        
        price.setId("detailsPrice");
        price.setAlignment(Pos.CENTER_RIGHT);
        price.setPrefWidth(340);
        
        
        HBox brandPrice = new HBox();
        brandPrice.getChildren().addAll(brand, price);

        //model
        HBox modelBox = new HBox();
        
        Label model = new Label ();
        model.setText(carList.get(i).getModel());
        model.setId("detailsModel");
        
        modelBox.getChildren().addAll(model);
        
        //brand price model box
        VBox brandPriceModel = new VBox();
        brandPriceModel.getChildren().addAll(brandPrice, modelBox);
        
        //color
        HBox exteriorColor = new HBox();
        
        Label colorLabel = new Label("Exterior Color:");
        colorLabel.setPrefWidth(235);
        Label color = new Label();
        color.setText(carList.get(i).getColor());
        color.setPrefWidth(95);
        
        exteriorColor.getChildren().addAll(colorLabel, color);
        
        //style
        HBox styleBox = new HBox();
        
        Label styleLabel = new Label ("Style:");
        styleLabel.setPrefWidth(195);
        Label style = new Label();
        style.setPrefWidth(130);
        
        if (carList.get(i).getConvertible())
        {
            style.setText("Convertible");
        }
        else
        {
            style.setText("Hard-Top");
        }
        
        styleBox.getChildren().addAll(styleLabel, style);
        
        //engine
        HBox engineBox = new HBox();
        
        Label engineLabel = new Label("Engine:");
        engineLabel.setPrefWidth(195);
        Label engine = new Label();
        engine.setPrefWidth(130);
        engine.setText(String.format
                        ("%s%d","V",carList.get(i).getNumOfCylinders()));
        
        
        engineBox.getChildren().addAll(engineLabel, engine);
        
        //timeto60
        HBox performanceBox = new HBox();
        
        Label performanceLabel = new Label("0-60 Performance:");
        performanceLabel.setPrefWidth(235);
        Label timeTo60 = new Label();
        timeTo60.setPrefWidth(95);
        timeTo60.setText(String.format
                        ("%.1f seconds",carList.get(i).getTimeTo60()));
        
        
        performanceBox.getChildren().addAll(performanceLabel, timeTo60);
        
        //all details
        VBox vehicleDetails = new VBox();
        
        HBox detailsLabelBox = new HBox();
        detailsLabelBox.setId("detailsLabelBox");
        detailsLabelBox.setMaxWidth(680);
        detailsLabelBox.setMinWidth(680);
        
        Label detailsLabel = new Label("Vehicle Details");
        detailsLabel.setId("detailsLabel");
       
        
        detailsLabelBox.getChildren().addAll(detailsLabel);
        
        HBox line1Details = new HBox();
        line1Details.getChildren().addAll(exteriorColor, styleBox);
        
        HBox line2Details = new HBox();
        line2Details.getChildren().addAll( performanceBox, engineBox);
        
        exteriorColor.setId("detailItem");
        styleBox.setId("detailItemLast");
        engineBox.setId("detailItemLast");
        performanceBox.setId("detailItem");

        vehicleDetails.getChildren().addAll(detailsLabelBox, line1Details, line2Details);
        
        Button buy = new Button ("Purchase Car");
        buy.setId("button");
        buy.setPrefWidth(200);
        
        //set action for purchase car button
        buy.setOnAction(event -> 
        {
            //create order
            order = new Order(carList.get(i));
           
            //customer information
            customerInformation();
            
            all.setCenter(customerInformation);
            all.setLeft(null); 
        });

        Button backToCars = new Button("< Back to Results");
        backToCars.setId("button");
        backToCars.setPrefWidth(200);
        
        //set Action for back to results
        backToCars.setOnAction(event -> 
        {
           all.setCenter(resultsBox);
           
        });
        
        HBox buttonBox = new HBox();
        
        buttonBox.getChildren().addAll(backToCars, buy);
        
        buttonBox.setSpacing(280);
        
        carDetails.getChildren().addAll(imageBox, brandPriceModel,
                                        vehicleDetails, buttonBox);
        
        carDetails.setPadding(new Insets(15, 0, 15, 100));
        carDetails.setSpacing(10);  
    }
    
    /**
     * Create a logo Banner Box
     */
    public void LogoBannerBox(){
        //logoBanner Box
        logoBannerBox = new HBox();
        
        //Contents of logoBanner Box
        Image carLogo = new Image("/carLogo2.png");
        ImageView carLogoView = new ImageView(carLogo);
        carLogoView.setPreserveRatio(true);
        carLogoView.setFitWidth(350);
        carLogoView.setId("logoPic"); 

        VBox logoImageBox = new VBox();
        logoImageBox.getChildren().addAll(carLogoView);
        logoImageBox.setAlignment(Pos.CENTER_RIGHT);
        logoImageBox.setMinHeight(150);
        logoImageBox.setPadding(new Insets(0, 0, 0 , 10));

        Image nameLogo = new Image("/name.png");
        ImageView nameLogoView = new ImageView(nameLogo);
        nameLogoView.setPreserveRatio(true);
        nameLogoView.setFitWidth(950);
        nameLogoView.setId("logoName"); 

        VBox logoNameBox = new VBox();
        logoNameBox.getChildren().addAll(nameLogoView);
        logoNameBox.setAlignment(Pos.CENTER);
        logoNameBox.setPadding(new Insets(0, 0, 0 , 15));

        logoBannerBox.getChildren().addAll(logoNameBox, logoImageBox);   
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
