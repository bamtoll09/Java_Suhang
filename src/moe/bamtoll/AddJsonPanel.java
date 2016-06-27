package moe.bamtoll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jaehyun on 2016-06-27.
 */
public class AddJsonPanel extends JPanel {

    String[] type = {"int", "float", "String", "boolean"};
    SpinnerListModel typeModel = new SpinnerListModel(type);

    JSpinner spinner = new JSpinner(typeModel);
    JLabel nameLabel = new JLabel("Name");
    JTextField nameTextField = new JTextField(10);
    JLabel valueLabel = new JLabel("Value");
    JTextField valueTextField = new JTextField(10);
    JButton deleteButton = new JButton("－");
    JButton addButton = new JButton("＋");

    //public static boolean arrayOn = false;
    //boolean isAdded = false;

    public AddJsonPanel() {
        spinner.setPreferredSize(new Dimension(70, 20));

        add(spinner);
        add(nameLabel);
        add(nameTextField);
        add(valueLabel);
        add(valueTextField);
        add(deleteButton);
        add(addButton);
    }

}
