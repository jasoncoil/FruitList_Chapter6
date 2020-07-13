package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GroceryListViewTestProgram2 extends Application {
    public void start(Stage primaryStage) {
        ItemList groceryList = new ItemList();
        groceryList.add("Apples");
        groceryList.add("Toilet Paper");
        groceryList.add("Ketchup");
        GroceryListView myPanel = new GroceryListView(groceryList);
        primaryStage.setTitle("View Test 2");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(myPanel, 285,205));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}