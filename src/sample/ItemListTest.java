import sample.ItemList;

public class ItemListTest{
    public static void main(String[] args) {
        // Make a new list
        ItemList groceryList = new ItemList();
        System.out.println("List has " + groceryList.getSize() + " items");
        System.out.println("List has these items: " + groceryList.getItems());
        // Add a few items
        System.out.println("\nAdding Apples, Oranges and Bananas ...");
        groceryList.add("Apples");
        groceryList.add("Oranges");
        groceryList.add("Bananas");
        System.out.println("List has " + groceryList.getSize() + " items");
        System.out.println("Here are the items in the list:");
        for (int i=0; i<groceryList.getSize(); i++)
            System.out.println(groceryList.getItems()[i]);
        // Remove an item
        System.out.println("\nRemoving Apples ...");
        groceryList.remove(0);
        System.out.println("List has " + groceryList.getSize() + " items");
        System.out.println("Here are the items in the list:");
        for (int i=0; i<groceryList.getSize(); i++)
            System.out.println(groceryList.getItems()[i]);
        // Try to remove too many items
        System.out.println("\nTrying to remove too many items ...");
        groceryList.remove(0);
        groceryList.remove(0);
        groceryList.remove(0);
        groceryList.remove(0);
        System.out.println("List has " + groceryList.getSize() + " items");
        System.out.println("Here are the items in the list:");
        for (int i=0; i<groceryList.getSize(); i++)
            System.out.println(groceryList.getItems()[i]);
        // Try to add too many items
        System.out.println("\nTrying to add too many items ...");
        for (int i=0; i<200; i++)
            groceryList.add("Item# " + i);
        System.out.println("List has " + groceryList.getSize() + " items");
        System.out.println("Here are the items in the list:");
        for (int i=0; i<groceryList.getSize(); i++)
            System.out.println(groceryList.getItems()[i]);
    }
}

