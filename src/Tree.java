import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.io.IOException;
import java.util.ArrayList;

public class Tree extends JPanel implements TreeSelectionListener{
    private static boolean useSystemLookAndFell = false;
    private JTree tree;
    private JEditorPane htmlPane;
    ArrayList<People> arr;

    public Tree() throws IOException{

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Data");
        init();
        createNodes(top);

        tree = new JTree(top);
        // su khac nhau giua single_tree, contigous_tree, ...
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // what is this? i don't know
        tree.addTreeSelectionListener(this);

        JScrollPane treeView = new JScrollPane(tree);

    }

    private void init() throws IOException {
        String fileName = "D:\\Russia\\lab7\\input.txt";
        csvFormat tmp = new csvFormat();
        this.arr = tmp.readCsvFile(fileName);
    }

    public void createNodes(DefaultMutableTreeNode top){
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode people = null;
        category = new DefaultMutableTreeNode("People");
        top.add(category);

        for(int i=0;i<this.arr.size()-1;i++){
            people = new DefaultMutableTreeNode(arr.get(i));
            category.add(people);
        }
    }

    // required when use interface TreeSelectionLister
    public void valueChanged(TreeSelectionEvent e){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null){
            return;
        }

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()){
            People people = (People) nodeInfo;
            //displayURL(people.getName());
        }
    }
}
