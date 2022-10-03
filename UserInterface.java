package java_basic;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UserInterface extends Frame implements ItemListener{

    private List myList;
    private Label message;

    public UserInterface() {}
    
    
    
    public UserInterface(String[] fruits) {
        super("My frame");
        myList = new List(3, true);
        for (String fruit:fruits) {
            myList.add(fruit);
        }
        this.setLayout(new GridLayout(2, 1));
        this.add(myList);
        message = new Label("Cac loai trai cay duoc chon: ");
        this.add(message);
    }
    
    public void handle() {
        myList.addItemListener(this);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        String[] fruits = new String[]{"banana", "apple", "orange", "strawberry", "kiwi"};
        UserInterface UI = new UserInterface(fruits);
        UI.setSize(500, 150);
        UI.handle();
        UI.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        ArrayList<String> items = new ArrayList<>();
        items.addAll(Arrays.asList(myList.getSelectedItems()));
        Collections.sort(items);
        String fruits = String.join(", ", items);
        message.setText("Cac loai trai cay duoc chon: " + fruits);
    }

}
