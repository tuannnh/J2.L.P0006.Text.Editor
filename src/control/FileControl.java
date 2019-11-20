/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author tuannnh
 */
public class FileControl {

    JFileChooser fc = new JFileChooser();

    public void control(MainWindow mainWindow) {
        checkSaved(mainWindow);
        createNewFile(mainWindow);
        openFile(mainWindow);
        save(mainWindow);
        saveAs(mainWindow);
        exit(mainWindow);
    }

    private void createNewFile(MainWindow mainWindow) {
        mainWindow.getMenuNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow newWindow = new MainWindow();
                newWindow.setVisible(true);
            }
        });
    }

    private void openFile(MainWindow mainWindow) {
        mainWindow.getMenuOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("Choose a text file to open");
                int choose = fc.showOpenDialog(mainWindow);
                try {
                    if (choose == JFileChooser.APPROVE_OPTION) {
                        File openFile = fc.getSelectedFile();
                        MainWindow openNewWindow = new MainWindow();
                        openNewWindow.setVisible(true);
                        openNewWindow.setTextFile(openFile);
                        FileReader fr = new FileReader(openFile);
                        BufferedReader br = new BufferedReader(fr);
                        String s = "";
                        String content = "";
                        while ((s = br.readLine()) != null) {
                            content += s;
                        }
                        openNewWindow.getTxtText().setText(content);
                        openNewWindow.setTextSaved(content);
                        openNewWindow.setSaved(true);
                        br.close();
                        fr.close();
                    }
                } catch (Exception ex) {
                }

            }
        });
    }
    
    private void save(MainWindow mainWindow){
        mainWindow.getMenuSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCurrentFile(mainWindow);
            }
        });
    }
    
    private void saveAs(MainWindow mainWindow){
         mainWindow.getMenuSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNewFile(mainWindow);
            }
        });
    }

    private void checkSaved(MainWindow mainWindow) {
        mainWindow.getTxtText().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!mainWindow.getTxtText().getText().equals(mainWindow.getTextSaved())) {
                    mainWindow.setSaved(false);
                    mainWindow.getMenuSave().setEnabled(true);
                }
            }
        });
    }
    
    

    private void saveCurrentFile(MainWindow mainWindow) {
        try {
            FileWriter fw = new FileWriter(mainWindow.getTextFile());
            fw.write(mainWindow.getTxtText().getText());
            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainWindow, e);
        }
        mainWindow.getMenuSave().setEnabled(false);
    }

    private void saveNewFile(MainWindow mainWindow) {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Choose a Directory to save your File");
        int result = fc.showSaveDialog(mainWindow);
        try {
            if (result == JFileChooser.APPROVE_OPTION) {
                File destinationFile = new File(fc.getSelectedFile().getAbsolutePath() + "/" + fc.getSelectedFile().getName());
                FileWriter fw = new FileWriter(destinationFile);
                fw.write(mainWindow.getTxtText().getText());
                fw.close();
                mainWindow.getMenuSave().setEnabled(false);

            }
        } catch (Exception e) {
        }
    }

    private boolean askToSave(MainWindow mainWindow) {
        String msg = "Do you want to save changes?";
        int choose = JOptionPane.showConfirmDialog(mainWindow, msg, "There is some changes!", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            if (mainWindow.getTextFile() == null) {
                saveNewFile(mainWindow);
                return true;
            } else {
                saveCurrentFile(mainWindow);
                return true;
            }
        }
        if (choose == JOptionPane.NO_OPTION) {
            return true;
        }
        return false;
    }
    
    private void exit(MainWindow mainWindow){
        mainWindow.getMenuExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkExit(mainWindow);
            }
        });
    }
    
    private void checkClose(MainWindow mainWindow){
        mainWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                checkExit(mainWindow);
            }
            
        });
    }

    private void checkExit(MainWindow mainWindow) {
        if (mainWindow.isSaved()) {
            mainWindow.dispose();
        } else {
            boolean canExit = askToSave(mainWindow);
            if (canExit) {
                mainWindow.dispose();
            }
        }
    }

}
