package past.n_ary_tree;

import past.n_ary_tree.traversal.LevelOrder;
import past.n_ary_tree.traversal.PostOrder;
import past.n_ary_tree.traversal.PreOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Run {

    @Test
    public void order(){
        PreOrder preOrder = new PreOrder();
        PostOrder postOrder = new PostOrder();
        LevelOrder levelOrder = new LevelOrder();

        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();
        Node a5 = new Node();
        Node a6 = new Node();

        a1.val = 1;
        a2.val = 2;
        a3.val = 3;
        a4.val = 4;
        a5.val = 5;
        a6.val = 6;

        List<Node> a3child = new ArrayList<>();
        a3child.add(a5);
        a3child.add(a6);
        a3.children = a3child;

        List<Node> a1child = new ArrayList<>();
        a1child.add(a3);
        a1child.add(a2);
        a1child.add(a4);
        a1.children = a1child;

        List<List<Integer>> vals = levelOrder.levelOrder(a1);

        for (List<Integer> val : vals){
            for (Integer v : val){
                System.out.print(v + " ");
            }
            System.out.println(" ");
        }
    }
}
