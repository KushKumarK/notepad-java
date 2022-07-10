package com.notepad;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;



/**
 * Hello world!
 *
 */
public class App implements ActionListener 
{
    JFrame f;
    JMenuBar mb;
    JMenu file, edit, help;
    JMenuItem open, cut, copy, paste, selectAll;
    JTextArea ta;
    JFileChooser fc;

    App(){
        f = new JFrame();
        fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        cut = new JMenuItem("cut");
        cut.addActionListener(this);
        copy = new JMenuItem("copy");
        copy.addActionListener(this);
        paste = new JMenuItem("paste");
        paste.addActionListener(this);
        selectAll = new JMenuItem("select all");
        selectAll.addActionListener(this);
        open = new JMenuItem("open");
        open.addActionListener(this);
        ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setBounds(0,30,500,460);
        mb = new JMenuBar();
        mb.setBounds(0,0,500,30);
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        file.add(open);
        edit.add(cut);
        edit.add(copy); 
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        f.add(mb);
        f.add(ta);
        f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
        f.setTitle("Notepad Editor");

    }
    public static void main( String[] args )
    {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut) {
            ta.cut();
        } else if (e.getSource() == paste){
            ta.paste();
        } else if (e.getSource() == copy){
            ta.copy();
        } else if (e.getSource() == selectAll){
            ta.selectAll();
        } else if (e.getSource() == open){
            fc.showOpenDialog(ta);
        }
    }
}
