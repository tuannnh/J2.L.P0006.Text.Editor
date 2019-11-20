/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.FontWindow;
import gui.MainWindow;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tuannnh
 */
public class ChangeFontControl {

    public void loadLocalFont(FontWindow fontWindow) {
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        ComboBoxModel fontModel = new DefaultComboBoxModel(fonts);
        fontWindow.getCbboxFont().setModel(fontModel);

        String styles[] = {"Regular", "Bold", "Italic", "Bold Italic"};
        ComboBoxModel styleModel = new DefaultComboBoxModel(styles);
        fontWindow.getCbboxStyle().setModel(styleModel);

        Integer sizes[] = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 36, 40, 72};
        ComboBoxModel sizeModel = new DefaultComboBoxModel(sizes);
        fontWindow.getCbboxSize().setModel(sizeModel);
    }

    public void loadCurrentFont(MainWindow mainWindow, FontWindow fontWindow) {
        String currentFont = mainWindow.getTxtText().getFont().getFamily();
        int currentStyle = mainWindow.getTxtText().getFont().getStyle();
        int currentSize = mainWindow.getTxtText().getFont().getSize();
        fontWindow.getCbboxFont().setSelectedItem(currentFont);
        fontWindow.getCbboxStyle().setSelectedIndex(currentStyle);
        fontWindow.getCbboxSize().setSelectedItem(currentSize);
        fontWindow.getLblPreview().setFont(new java.awt.Font(currentFont, currentStyle, currentSize));
    }

    public void changeFont(FontWindow fontWindow) {
        fontWindow.getCbboxFont().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String fontChosen = (String) fontWindow.getCbboxFont().getSelectedItem();
                int currentStyle = fontWindow.getCbboxStyle().getSelectedIndex();
                int currentSize = (int) fontWindow.getCbboxSize().getSelectedItem();
                fontWindow.getLblPreview().setFont(new java.awt.Font(fontChosen, currentStyle, currentSize) {
                });
            }
        });

    }

    public void changeStyle(FontWindow fontWindow) {
        fontWindow.getCbboxStyle().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String fontChosen = (String) fontWindow.getCbboxFont().getSelectedItem();
                int currentStyle = fontWindow.getCbboxStyle().getSelectedIndex();
                int currentSize = (int) fontWindow.getCbboxSize().getSelectedItem();
                fontWindow.getLblPreview().setFont(new java.awt.Font(fontChosen, currentStyle, currentSize) {
                });
            }
        });
    }

    public void changeSize(FontWindow fontWindow) {
        fontWindow.getCbboxSize().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String fontChosen = (String) fontWindow.getCbboxFont().getSelectedItem();
                int currentStyle = fontWindow.getCbboxStyle().getSelectedIndex();
                int currentSize = (int) fontWindow.getCbboxSize().getSelectedItem();
                fontWindow.getLblPreview().setFont(new java.awt.Font(fontChosen, currentStyle, currentSize) {
                });
            }
        });
    }

    public void clickButton(MainWindow mainWindow, FontWindow fontWindow) {
        fontWindow.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontChosen = (String) fontWindow.getCbboxFont().getSelectedItem();
                int currentStyle = fontWindow.getCbboxStyle().getSelectedIndex();
                int currentSize = (int) fontWindow.getCbboxSize().getSelectedItem();
                mainWindow.getTxtText().setFont(new Font(fontChosen, currentStyle, currentSize));
                fontWindow.dispose();
            }
        });

        fontWindow.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontWindow.dispose();
            }
        });
    }
}
