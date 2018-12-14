import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class graphInterface extends JPanel {

    private JLabel name;
    private JLabel viewTree;
    private JLabel buttons;
    private JFrame window;


    public graphInterface(){
        //super(new GridLayout(1,0));
        prepareGUI();
        //init();
        //showContent();


    }

    private void showContent(){
        //create buttons
        JPanel btn = new JPanel();
        btn.setBackground(Color.BLUE);
        btn.setSize(200,500);
        GroupLayout layout = new GroupLayout(btn);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JButton btn1 = new JButton("add");
        JButton btn2 = new JButton("remove");
        JButton btn3 = new JButton("info");

        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(btn1).addComponent(btn2).addComponent(btn3));
        layout.setHorizontalGroup(layout.createParallelGroup().addComponent(btn1).addComponent(btn2).addComponent(btn3));

        btn.setLayout(layout);
        buttons.add(btn);


        //createTree
/*
        try{
            viewTree.add(new Tree());
        } catch (IOException e){ System.out.println("File not found");};
*/
        //*********************************
        window.setVisible(true);
    }

    private void prepareGUI(){
        window = new JFrame("Lab7");
        window.setSize(900,500);
        window.setLayout(new GridLayout(1,3));

        name = new JLabel("Tran Trung Duc", JLabel.CENTER);
        viewTree = new JLabel("",JLabel.CENTER);
        buttons = new JLabel();buttons.setLayout(new FlowLayout());

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        window.add(name);
        window.add(viewTree);
        window.add(buttons);
        window.setVisible(false);
    }

    public static void main(String[] args){
        graphInterface duc = new graphInterface();
        duc.showContent();
    }
}
