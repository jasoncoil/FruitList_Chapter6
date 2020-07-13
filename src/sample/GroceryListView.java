package sample;

import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;



public class GroceryListView extends Pane {
    //Adding model to the View, and creating a listview array to manipulate more easily in the view
    private ItemList model;

    // The user interface components needed by the controller
    private ListView<String> groceryList;
    private Button addButton;
    private Button removeButton;
    private TextField newItemField;

    // public methods to allow access to window components
    public ListView<String> getList() { return groceryList; }
    public Button getAddButton() { return addButton; }
    public Button getRemoveButton() { return removeButton; }
    public TextField getNewItemField() { return newItemField; }
    public GroceryListView(ItemList m) {
        model = m;

        // Create and position the "new item" TextField
        newItemField = new TextField();
        newItemField.relocate(10, 10);
        newItemField.setPrefSize(150, 25);

        // Create and position the "Add" Button
        addButton = new Button("Add");
        addButton.relocate(175, 10);
        addButton.setPrefSize(100, 25);

        // Create and position the "Remove" Button
        removeButton = new Button("Remove");
        removeButton.relocate(175, 45);
        removeButton.setPrefSize(100, 25);

        // Create and position the grocery ListView with some groceries in it
        groceryList = new ListView<String>();
        String[] groceries = {"Apples", "Oranges", "Bananas", "Toilet Paper", "Ketchup",
                "Cereal", "Milk", "Cookies", "Cheese", "Frozen Pizza"};
        groceryList.setItems(FXCollections.observableArrayList(groceries));
        groceryList.relocate(10, 45);
        groceryList.setPrefSize(150, 150);
        // Add all the components to the window
        getChildren().addAll(newItemField, addButton, removeButton, groceryList);

        //Call Update to make sure viewport is up to date
        update();

    }
    //Create our update method which will update the view when changes are made via buttons, etc
    public void update() {
        //create and return array with exact size it currently has
        String[] exactList = new String[model.getSize()];
        for (int i = 0; i < model.getSize(); i++) {
            exactList[i] = model.getItems()[i];
        }
        int selectedIndex = groceryList.getSelectionModel().getSelectedIndex();
        groceryList.setItems(FXCollections.observableArrayList(exactList));
        groceryList.getSelectionModel().select(selectedIndex);


        addButton.setDisable(newItemField.getText().trim().length() <= 0); //If nothing is typed, disable the add button
        removeButton.setDisable(groceryList.getSelectionModel().getSelectedIndex() < 0); //If nothing is selected, disable the remove button
    }

}