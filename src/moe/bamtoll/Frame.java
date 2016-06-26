package moe.bamtoll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jaehyun on 2016-06-26.
 */
public class Frame extends JFrame implements ActionListener {

    JPanel panel = new JPanel(new FlowLayout());
    JScrollPane scrollPane = new JScrollPane(panel);
    SettingJsonPanel settingJsonPanel = new SettingJsonPanel();
    ArrayList<AddJsonPanel> jsonPanels = new ArrayList<>();

    int width = 500;
    int height = 700;
    int panelHeight = 100;
    int boundX = 0;
    int boundY = 0;
    int index = 0;

    public Frame()
    {
        settingJsonPanel.setBounds(boundX, boundY, width, 100);
        boundY += 100;
        panel.setSize(new Dimension(width, panelHeight));
        panelHeight += 100;
        panel.add(settingJsonPanel);
        scrollPane.setSize(new Dimension(width, height));
        add(panel);
        Add();
        setTitle("XML / JSON Writer");
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void Add() {
        jsonPanels.add(new AddJsonPanel());
        jsonPanels.get(index).setBounds(boundX, boundY, width, 100);
        jsonPanels.get(index).addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add();
                System.out.println("pressed");
            }
        });
        panel.add(jsonPanels.get(index));
        boundY += 100;
        panel.setSize(width, panelHeight);
        panelHeight += 100;
        index++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        switch (b.getText().toString()) {
            /*case "add":
                Add();
                break;
            case "check":
                System.out.println(spinner.getValue());
                break;*/
        }
    }
}
