package sample;




public class ItemList {
    public final int MAXIMUM_SIZE = 100;

    private String[]  items;
    private int size;


    //constructor with zero inputs
    public ItemList(){
        items = new String[MAXIMUM_SIZE];
        size = 0;
    }

    //Get methods for ItemList
    public int getSize() {return size;}
    public String[] getItems() {return items;}

    //Creating a method of adding items to the list
    public void add(String item){
        //if statement to determine if list is too full
        if(size < MAXIMUM_SIZE){
            items[size++] = item;
        }
    }


    //Creating a method of removing items from the lsit
    public void remove(int index){
        //checking index given to see if it is in bounds
        if(index >= 0 && index < size){
            for(int i=index; i<size-1;i++){
                items[i] = items[i+1];
            }
            size--; //reduce list size by one
        }
    }

}
