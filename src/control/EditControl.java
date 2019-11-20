/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.FindWindow;
import gui.FontWindow;
import gui.MainWindow;
import gui.ReplaceWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

/**
 *
 * @author tuannnh
 */
public class EditControl {

    

    public void control(MainWindow mainWindow) {
        UndoManager  mng = new UndoManager();
        mainWindow.getTxtText().getDocument().addUndoableEditListener(mng);

        checkEditable(mainWindow, mng);
        selectAll(mainWindow);

        undo(mainWindow,mng);
        redo(mainWindow,mng);
        useClipboard(mainWindow);
        find(mainWindow);
        replace(mainWindow);
        changeFont(mainWindow);
    }

    private void checkEditable(MainWindow mainWindow, UndoManager mng) {
        //New window, can not copy, paste, find, replace
        mainWindow.getMenuCopy().setEnabled(false);
        mainWindow.getMenuCut().setEnabled(false);

        mainWindow.getMenuUndo().setEnabled(false);
        mainWindow.getMenuRedo().setEnabled(false);

        mainWindow.getMenuFind().setEnabled(false);
        mainWindow.getMenuReplace().setEnabled(false);

        //Check changed content of txtArea
        mainWindow.getTxtText().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String text = mainWindow.getTxtText().getText();
                //Have content
                if (text.length() != 0) {
                    mainWindow.getMenuFind().setEnabled(true);
                    mainWindow.getMenuReplace().setEnabled(true);
                }
                //Have selected text to copy, cut
                if (mainWindow.getTxtText().getSelectedText() != null) {
                    mainWindow.getMenuCopy().setEnabled(true);
                    mainWindow.getMenuCut().setEnabled(true);
                }
                if (mng.canUndo()) {
                    mainWindow.getMenuUndo().setEnabled(true);
                } else {
                    mainWindow.getMenuUndo().setEnabled(false);
                }
                if (mng.canRedo()) {
                    mainWindow.getMenuRedo().setEnabled(true);
                } else {
                    mainWindow.getMenuRedo().setEnabled(false);
                }
            }
        });
    }

    private void selectAll(MainWindow mainWindow) {
        mainWindow.getMenuSelectAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.getTxtText().selectAll();
            }
        });
    }

    private void undo(MainWindow mainWindow, UndoManager mng) {
        mainWindow.getMenuUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mng.undo();
            }
        });
    }

    private void redo(MainWindow mainWindow, UndoManager mng) {
        mainWindow.getMenuRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mng.redo();
            }
        });
    }

    private void useClipboard(MainWindow mainWindow) {
        Action copy = new DefaultEditorKit.CopyAction();
        Action cut = new DefaultEditorKit.CutAction();
        Action paste = new DefaultEditorKit.PasteAction();

        mainWindow.getMenuCopy().addActionListener(copy);
        mainWindow.getMenuCut().addActionListener(cut);
        mainWindow.getMenuPaste().addActionListener(paste);
    }

    private void find(MainWindow mainWindow) {
        mainWindow.getMenuFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindWindow findWindow = new FindWindow(mainWindow, true);
                ReplaceWindow replaceWindow = new ReplaceWindow(mainWindow, true);
                FindReplaceControl findReplace = new FindReplaceControl();
                findReplace.checkEmptyKeyword(findWindow, replaceWindow);
                findReplace.find(mainWindow, findWindow, replaceWindow);
                findReplace.cancel(findWindow, replaceWindow);
                findWindow.setVisible(true);
                replaceWindow.setVisible(false);
            }
        });
    }

    private void replace(MainWindow mainWindow) {
        mainWindow.getMenuReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindWindow findWindow = new FindWindow(mainWindow, true);
                ReplaceWindow replaceWindow = new ReplaceWindow(mainWindow, true);
                FindReplaceControl findReplace = new FindReplaceControl();
                findReplace.checkEmptyKeyword(findWindow, replaceWindow);
                findReplace.find(mainWindow, findWindow, replaceWindow);
                findReplace.replace(mainWindow, replaceWindow);
                findReplace.cancel(findWindow, replaceWindow);
                replaceWindow.setVisible(true);
                findWindow.setVisible(false);
            }
        });
    }
    
    private void changeFont(MainWindow mainWindow){
        mainWindow.getMenuChangeFont().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FontWindow fontWindow = new FontWindow();
                fontWindow.setVisible(true);
                
                ChangeFontControl changeFont = new ChangeFontControl();
                changeFont.loadLocalFont(fontWindow);
                changeFont.loadCurrentFont(mainWindow, fontWindow);
                changeFont.changeFont(fontWindow);
                changeFont.changeStyle(fontWindow);
                changeFont.changeSize(fontWindow);
                changeFont.clickButton(mainWindow, fontWindow);
            }
        });
    }
}
