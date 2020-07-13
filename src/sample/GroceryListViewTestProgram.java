package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GroceryListViewTestProgram extends Application {
    public void start(Stage primaryStage) {
        ItemList groceryList = new ItemList();
        GroceryListView myPanel = new GroceryListView(groceryList);
        primaryStage.setTitle("View Test");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(myPanel, 285,205));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}