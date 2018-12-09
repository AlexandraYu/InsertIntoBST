//here I do the easiest way--always adding the node as the end-node (either left or right child node of a root)
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class InsertNewNodeIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int value) {
        //we start to think if the whole tree is null--we only need to construct this input value to be the new node and root node and return it
        if (root == null) return new TreeNode(value); 
        
        //if just by looking at one "section" of a tree and its left and right child nodes...
        //we compare the value to the root, it'll become root's right child node if the value is bigger than the root's value, otherwise it'll become root's left child node.
        //if (value > root.val) root.right = new TreeNode(val);
        //else root.left = new TreeNode(val); 
        //This is pretty much the answer, if you only see a section of the tree that consists 1 root node its 2 child nodes. However, now we have a tree that's built up by many "sections," but for each section we do the same comparison. In this case now, root.left may become a root for the next section, same for root.right, and you will do the same comparison again 
        //this will continue until root.right is null, or root.left is null, so you know the new node should be connected here! And this part has been taken care of if (root == null) return new TreeNode(val), b/c remember that root.left and root.right can become the new "root" for the next section? So when root == null, that means the previous section's root.left or root.right is null, a.k.a it doesn't have left or right child node. 
        if (value > root.val) root.right = insertIntoBST(root.right, value); 
        else root.left = insertIntoBST(root.left, value); 
        // up until here, the new node has been properly placed in the tree, you just need to return the root node, and this part will also pop the each "function" in the stack until the stack is empty
        return root; 
    }
}
