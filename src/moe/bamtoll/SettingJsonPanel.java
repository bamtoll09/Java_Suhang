package moe.bamtoll;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jaehyun on 2016-06-27.
 */
public class SettingJsonPanel extends JPanel implements ActionListener {

    private JFileChooser jfc = new JFileChooser();

    JLabel pathLabel = new JLabel("경로");
    JTextField pathTextField = new JTextField(12);
    JButton setPathButton = new JButton("···");
    JLabel nameLabel = new JLabel("파일 이름");
    JTextField nameTextField = new JTextField(12);
    JButton saveButton = new JButton("저장");

    public SettingJsonPanel()
    {
        jfc.setFileFilter(new FileNameExtensionFilter("json", "json"));
        jfc.setMultiSelectionEnabled(false);

        setPathButton.addActionListener(this);
        saveButton.addActionListener(this);

        add(pathLabel);
        add(pathTextField);
        add(setPathButton);
        add(nameLabel);
        add(nameTextField);
        add(saveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(((JButton) e.getSource()).getText().toString())
        {
            case "···":
                if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                    // showSaveDialog 저장 창을 열고 확인 버튼을 눌렀는지 확인
                    pathTextField.setText(jfc.getCurrentDirectory().toString() + "\\");
                    nameTextField.setText(jfc.getSelectedFile().getName() + "." + jfc.getFileFilter().getDescription());
                }
                break;

            case "저장":
                break;
        }
    }
}
