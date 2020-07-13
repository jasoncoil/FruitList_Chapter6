package sample;
import javafx.application.Application;
import javafx.collections.transformation.SortedList;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;




//This acts as the controller for the application, which ties in the view and the model
public class GroceryListApp extends Application {
    private ItemList model; // model to which this view is attached
    private GroceryListView view; // view that shows the state of the model

    public void start(Stage primaryStage) {
        // Create the model and view
        model = new ItemList(); // Start with an empty list
        view = new GroceryListView(model);

        // Add the event handlers
        //Starting with Add Button Event
        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { handleAddButtonPress(); }
        });
        //Add Button Event Will Occur when Enter is Pressed as well
        view.getNewItemField().setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                if (ke.getCode() == KeyCode.ENTER)
                    handleAddButtonPress();
            }
        });

        //Remove Button Action Event
        view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) { handleRemoveButtonPress(); }
        });
        //Update view when user selects an item (therefore enabling the remove button again)
        view.getList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                handleListSelection();
            }
        });
        //Handling Event of typing in the typefield (enabling the addbutton)
        view.getNewItemField().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) { handleTextEntry(); }
        });




        //Setting the stage
        primaryStage.setTitle("My Grocery List");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(view, 285,205));
        primaryStage.show();
    }

    // Handle the add button event
    private void handleAddButtonPress() {
        String text = view.getNewItemField().getText().trim();
        if(text.length() > 0)
            view.getNewItemField().setText(""); //Delete string from ItemField once addButton is pressed
            model.add(text);
            view.update();
    }
    //Remove Button Event Handler
    private void handleRemoveButtonPress() {
        int index = view.getList().getSelectionModel().getSelectedIndex();
        if (index >= 0)
            model.remove(index);
            view.update();
    }
    //Selecting ItemField Handler
    private void handleListSelection(){
        view.update();
    }
    //TextField Typing Event Handlers
    private void handleTextEntry() {
        view.update();
    }


    public static void main(String[] args) { launch(args); }
}
