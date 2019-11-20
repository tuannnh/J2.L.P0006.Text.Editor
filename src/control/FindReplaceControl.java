/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.FindWindow;
import gui.MainWindow;
import gui.ReplaceWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author tuannnh
 */
public class FindReplaceControl {

    public void checkEmptyKeyword(FindWindow findWindow, ReplaceWindow replaceWindow) {

        findWindow.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String keyword = findWindow.getTxtFind().getText().trim();
                if (keyword.isEmpty()) {
                    findWindow.getBtnFind().setEnabled(false);
                } else {
                    findWindow.getBtnFind().setEnabled(true);
                }
            }
        });

        replaceWindow.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String keyword = replaceWindow.getTxtFind().getText().trim();
                if (keyword.isEmpty()) {
                    replaceWindow.getBtnFind().setEnabled(false);
                    replaceWindow.getBtnReplace().setEnabled(false);
                    replaceWindow.getBtnReplaceAll().setEnabled(false);
                } else {
                    replaceWindow.getBtnFind().setEnabled(true);
                    replaceWindow.getBtnReplace().setEnabled(true);
                    replaceWindow.getBtnReplaceAll().setEnabled(true);
                }
            }
        });
    }

    public void find(MainWindow mainWindow, FindWindow findWindow, ReplaceWindow replaceWindow) {

        Action findAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = findWindow.getTxtFind().getText();
                boolean founded;
                if (mainWindow.getTxtText().getText().contains(keyword)) {
                    founded = true;
                } else {
                    founded = false;
                }
                int currentIndex;
                int keywordIndex = -1;

                currentIndex = mainWindow.getTxtText().getSelectionEnd();
                keywordIndex = mainWindow.getTxtText().getText().indexOf(keyword, currentIndex);
                if (keywordIndex > -1) {
                    mainWindow.getTxtText().setSelectionStart(keywordIndex);
                    mainWindow.getTxtText().setSelectionEnd(keywordIndex + keyword.length());
                    founded = true;
                } else {
                    if (founded) {
                        mainWindow.getTxtText().setCaretPosition(0);
                        currentIndex = mainWindow.getTxtText().getSelectionStart();
                        keywordIndex = mainWindow.getTxtText().getText().indexOf(keyword, currentIndex);
                        mainWindow.getTxtText().setSelectionStart(keywordIndex);
                        mainWindow.getTxtText().setSelectionEnd(keywordIndex + keyword.length());
                    }

                }

            }
        ;
        };

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Action findToReplaceAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword;
                keyword = replaceWindow.getTxtFind().getText();
                int currentIndex;
                int foundedIndex = -1;
                boolean founded;
                if (mainWindow.getTxtText().getText().contains(findWindow.getTxtFind().getText())
                        || mainWindow.getTxtText().getText().contains(replaceWindow.getTxtFind().getText())) {
                    founded = true;
                } else {
                    founded = false;
                }
                currentIndex = mainWindow.getTxtText().getSelectionEnd();
                foundedIndex = mainWindow.getTxtText().getText().indexOf(keyword, currentIndex);
                if (foundedIndex > -1) {
                    mainWindow.getTxtText().setSelectionStart(foundedIndex);
                    mainWindow.getTxtText().setSelectionEnd(foundedIndex + keyword.length());
                } else {
                    if (founded) {
                        mainWindow.getTxtText().setCaretPosition(0);
                        currentIndex = mainWindow.getTxtText().getSelectionEnd();
                        foundedIndex = mainWindow.getTxtText().getText().indexOf(keyword, currentIndex);
                        mainWindow.getTxtText().setSelectionStart(foundedIndex);
                        mainWindow.getTxtText().setSelectionEnd(foundedIndex + keyword.length());
                    } else {
                        JOptionPane.showMessageDialog(null, "Keyword not found!");
                    }
                }

            }
        };

        findWindow.getBtnFind()
                .addActionListener(findAction);
        replaceWindow.getBtnFind()
                .addActionListener(findToReplaceAction);
    }

    public void replace(MainWindow mainWindow, ReplaceWindow replaceWindow) {

        replaceWindow.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean founded;
                if (mainWindow.getTxtText().getText().contains(replaceWindow.getTxtFind().getText())) {
                    founded = true;
                } else {
                    founded = false;
                }
                if (!founded) {
                    JOptionPane.showMessageDialog(null, "Nothing to replace");
                } else {
                    String currentText = mainWindow.getTxtText().getText();
                    int savePoint = mainWindow.getTxtText().getSelectionEnd();
                    //Get text before and after selected text
                    String before = currentText.substring(0, mainWindow.getTxtText().getSelectionStart());
                    String after = currentText.substring(mainWindow.getTxtText().getSelectionEnd());
                    currentText = before + replaceWindow.getTxtReplace().getText().trim() + after;
                    mainWindow.getTxtText().setText(currentText);
                    mainWindow.getTxtText().setCaretPosition(savePoint);
                    replaceWindow.getBtnFind().doClick();

                }
            }
        });

        replaceWindow.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean founded;
                if (mainWindow.getTxtText().getText().contains(replaceWindow.getTxtFind().getText())) {
                    founded = true;
                } else {
                    founded = false;
                }
                if (!founded) {
                    JOptionPane.showMessageDialog(null, "Nothing to replace");
                } else {
                    String currentText = mainWindow.getTxtText().getText();
                    currentText = currentText.replaceAll(replaceWindow.getTxtFind().getText().trim(), replaceWindow.getTxtReplace().getText().trim());
                    mainWindow.getTxtText().setText(currentText);
                }
            }
        });
    }

    public void cancel(FindWindow findWindow, ReplaceWindow replaceWindow) {
        Action cancelAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findWindow.setVisible(false);
                replaceWindow.setVisible(false);
            }
        };
        findWindow.getBtnCancel().addActionListener(cancelAction);
        replaceWindow.getBtnCancel().addActionListener(cancelAction);

    }

}
