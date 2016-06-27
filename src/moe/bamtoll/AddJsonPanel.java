package moe.bamtoll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jaehyun on 2016-06-27.
 */
public class AddJsonPanel extends JPanel implements ActionListener {

    String[] type = {"int", "foat", "String", "boolean"};
    SpinnerListModel typeModel = new SpinnerListModel(type);

    JSpinner spinner = new JSpinner(typeModel);
    JLabel nameLabel = new JLabel("Name");
    JTextField nameTextField = new JTextField(10);
    JLabel valueLabel = new JLabel("Value");
    JTextField valueTextField = new JTextField(10);
    JButton arrayButton = new JButton("[ ]");
    JButton addButton = new JButton("＋");
    JButton deleteButton = new JButton("－");

    public static boolean arrayOn = false;
    boolean isAdded = false;

    public AddJsonPanel() {
        spinner.setPreferredSize(new Dimension(70, 20));

        arrayButton.addActionListener(this);
        addButton.addActionListener(this);

        add(spinner);
        add(nameLabel);
        add(nameTextField);
        add(valueLabel);
        add(valueTextField);
        add(arrayButton);
        add(addButton);
        Run();
    }

    void Run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isAdded)
                {
                    remove(addButton);
                    add(deleteButton);
                    isAdded = false;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText().toString())
        {
            case "＋":
                isAdded = true;
                break;

            case "－":
                remove(this);
                break;

            case "[ ]":

                break;
        }
    }
}
