package moe.bamtoll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jaehyun on 2016-06-26.
 */
public class Frame extends JFrame implements ActionListener, FrameInterface {

    JPanel panel = new JPanel(null);
    JPanel contentPane = new JPanel(null);
    JScrollPane scrollPane = new JScrollPane(panel);
    SettingJsonPanel settingJsonPanel = new SettingJsonPanel();
    public static ArrayList<AddJsonPanel> jsonPanels = new ArrayList<>();

    int width = 500;
    int height = 700;
    int panelHeight = 40;
    int boundX = 0;
    int boundY = 0;
    int index = 0;

    public Frame()
    {
        settingJsonPanel.setBounds(boundX, boundY, width, 40);
        boundY += 40;
        panel.setPreferredSize(new Dimension(width, panelHeight));
        panelHeight += 40;
        //panel.setBackground(Color.BLACK);
        panel.add(settingJsonPanel);
        scrollPane.setBounds(0, 0, width, height);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.setPreferredSize(new Dimension(width, height));
        contentPane.add(scrollPane);
        setContentPane(contentPane);
        setIconImage(new ImageIcon("assets/icon/JSON_logo.gif").getImage());

        //for (int i=0; i<10; i++)
            Add(index);
        pack();
        setTitle("JSON Writer");
        setSize(new Dimension(width + 15, height+ 40));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setResizable(false);
    }

    public void Add(int _index) {
        jsonPanels.add(new AddJsonPanel());
        jsonPanels.get(_index).setBounds(boundX, boundY, width, 40);

        if (jsonPanels.size() > 1) {
            jsonPanels.get(_index).deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Delete(_index);
                }
            });
        }
        jsonPanels.get(_index).addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add(index);
                System.out.println("pressed1");
            }
        });
        panel.add(jsonPanels.get(_index));
        panel.setPreferredSize(new Dimension(width, panelHeight));
        panelHeight += 40;
        boundY += 40;
        index++;
        if (_index > 0) {
            for (ActionListener al : jsonPanels.get(_index - 1).addButton.getActionListeners()) {
                jsonPanels.get(_index - 1).addButton.removeActionListener(al);
            }
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void Delete(int _index) {
        panel.remove(jsonPanels.get(_index));
        panelHeight -= 40;
        panel.setPreferredSize(new Dimension(width, panelHeight));
        jsonPanels.remove(_index);
        System.out.println(String.valueOf(_index));

        boundY = 40;
        for (int i=0; i<jsonPanels.size(); i++) {
            if (jsonPanels.size() == 1)
                jsonPanels.get(i).addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Add(index);
                    }
                });
            jsonPanels.get(i).setBounds(boundX, boundY, width, 40);
            boundY += 40;
        }
        for (int i=_index; i<jsonPanels.size(); i++) {
            for (ActionListener al : jsonPanels.get(i).deleteButton.getActionListeners()) {
                jsonPanels.get(i).deleteButton.removeActionListener(al);
            }

            int finalI = i;
            jsonPanels.get(i).deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Delete(finalI);
                }
            });
        }

        index--;

        SwingUtilities.updateComponentTreeUI(this);
        invalidate();
        validate();
        repaint();
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
