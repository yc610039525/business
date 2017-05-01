package org.business.component.pojo;

import java.util.Stack;

/**
 * @version
 * @date
 * @descrption
 * @author Admin
 *
 */
class TreeNode {

 // 左节点
 private TreeNode lefTreeNode;
 // 右节点
 private TreeNode rightNode;
 // 数据
 private int value;

 private boolean isDelete;

 public TreeNode getLefTreeNode() {
  return lefTreeNode;
 }

 public void setLefTreeNode(TreeNode lefTreeNode) {
  this.lefTreeNode = lefTreeNode;
 }

 public TreeNode getRightNode() {
  return rightNode;
 }

 public void setRightNode(TreeNode rightNode) {
  this.rightNode = rightNode;
 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public boolean isDelete() {
  return isDelete;
 }

 public void setDelete(boolean isDelete) {
  this.isDelete = isDelete;
 }

 public TreeNode() {
  super();
 }

 public TreeNode(int value) {
  this(null, null, value, false);
 }

 public TreeNode(TreeNode lefTreeNode, TreeNode rightNode, int value,
   boolean isDelete) {
  super();
  this.lefTreeNode = lefTreeNode;
  this.rightNode = rightNode;
  this.value = value;
  this.isDelete = isDelete;
 }

 @Override
 public String toString() {
  return "TreeNode [ value=" + value + ",lefTreeNode=" + lefTreeNode + ", rightNode="
    + rightNode +", isDelete=" + isDelete
    + "]";
 }

}


/**
 * 
 * @ClassName: com.tree.Tree
 * @Description: 二叉树的定义
 * @author zhaokaiqiang
 * @date 2014-12-8 上午7:51:49
 * 
 */

public class BinaryTree {

 // 根节点
 private TreeNode root;

 public TreeNode getRoot() {
  return root;
 }

 /**
  * 插入操作
  * 
  * @param value
  */
 public void insert(int value) {

  TreeNode newNode = new TreeNode(value);

  if (root == null) {
   root = newNode;
   root.setLefTreeNode(null);
   root.setRightNode(null);
  } else {

   TreeNode currentNode = root;
   TreeNode parentNode;

   while (true) {

    parentNode = currentNode;
    // 往右放
    if (newNode.getValue() > currentNode.getValue()) {
     currentNode = currentNode.getRightNode();
     if (currentNode == null) {
      parentNode.setRightNode(newNode);
      return;
     }
    } else {
     // 往左放
     currentNode = currentNode.getLefTreeNode();
     if (currentNode == null) {
      parentNode.setLefTreeNode(newNode);
      return;
     }

    }
   }
  }
 }

 /**
  * 查找
  * 
  * @param key
  * @return
  */
 public TreeNode find(int key) {

  TreeNode currentNode = root;

  if (currentNode != null) {

   while (currentNode.getValue() != key) {

    if (currentNode.getValue() > key) {
     currentNode = currentNode.getLefTreeNode();
    } else {
     currentNode = currentNode.getRightNode();
    }

    if (currentNode == null) {
     return null;
    }

   }

   if (currentNode.isDelete()) {
    return null;
   } else {
    return currentNode;
   }

  } else {
   return null;
  }

 }

 /**
  * 中序遍历
  * 
  * @param treeNode
  */
 public void inOrderMin(TreeNode treeNode) {
  if (treeNode != null && treeNode.isDelete() == false) {
   inOrderMin(treeNode.getLefTreeNode());
   System.out.println("------" + treeNode);
   inOrderMin(treeNode.getRightNode());
  }
 }
 /**
  * 前序遍历
  * @param treeNode
  */
 public void inOrderBefore(TreeNode treeNode) {
	  if (treeNode != null && treeNode.isDelete() == false) {
	   System.out.println("--" + treeNode.getValue());
	   inOrderBefore(treeNode.getLefTreeNode());
	   inOrderBefore(treeNode.getRightNode());
	  }
	 }
 public void inOrderAfter(TreeNode treeNode) {
	  if (treeNode != null && treeNode.isDelete() == false) {
	   inOrderAfter(treeNode.getLefTreeNode());
	   inOrderAfter(treeNode.getRightNode());
	   System.out.println("--" + treeNode.getValue());
	  }
	 }
 /** 访问节点 */  
 public static void visit(TreeNode p) {  
     System.out.print(p.getValue() + "---/--- ");  
 }  
 /** 非递归实现前序遍历 */  
 protected static void iterativePre(TreeNode p) {  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     if (p != null) {  
         stack.push(p);  
         while (!stack.empty()) {  
             p = stack.pop();  
             visit(p);  
             if (p.getRightNode() != null)  
                 stack.push(p.getRightNode());  
             if (p.getLefTreeNode() != null)  
                 stack.push(p.getLefTreeNode());  
         }  
     }  
 }  
 /** 非递归实现前序遍历2 */  
 protected static void iterativePre2(TreeNode p) {  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     TreeNode node = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {//压入所有的左节点，压入前访问它  
             visit(node);  
             stack.push(node);  
             node = node.getLefTreeNode();  
         }  
         if (stack.size() > 0) {//  
             node = stack.pop();  
             node = node.getRightNode();  
         }  
     }  
 }  
 /** 非递归实现后序遍历 */  
 protected static void iterativePost(TreeNode p) {  
	 TreeNode q = p;  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     while (p != null) {  
         // 左子树入栈  
         for (; p.getLefTreeNode() != null; p = p.getLefTreeNode())  
             stack.push(p);  
         // 当前节点无右子或右子已经输出  
         while (p != null && (p.getRightNode() == null || p.getRightNode() == q)) {  
             visit(p);  
             q = p;// 记录上一个已输出节点  
             if (stack.empty())  
                 return;  
             p = stack.pop();  
         }  
         // 处理右子  
         stack.push(p);  
         p = p.getRightNode();  
     }  
 }  
 /** 非递归实现后序遍历 双栈法 */  
 protected static void iterativePost2(TreeNode p) {  
     Stack<TreeNode> lstack = new Stack<TreeNode>();  
     Stack<TreeNode> rstack = new Stack<TreeNode>();  
     TreeNode node = p, right;  
     do {  
         while (node != null) {  
             right = node.getRightNode();  
             lstack.push(node);  
             rstack.push(right);  
             node = node.getLefTreeNode();  
         }  
         node = lstack.pop();  
         right = rstack.pop();  
         if (right == null) {  
             visit(node);  
         } else {  
             lstack.push(node);  
             rstack.push(null);  
         }  
         node = right;  
     } while (lstack.size() > 0 || rstack.size() > 0);  
 }  
 /** 非递归实现后序遍历 单栈法*/  
 protected static void iterativePost3(TreeNode p) {  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     TreeNode node = p, prev = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {  
             stack.push(node);  
             node = node.getLefTreeNode();  
         }  
         if (stack.size() > 0) {  
        	 TreeNode temp = stack.peek().getRightNode();  
             if (temp == null || temp == prev) {  
                 node = stack.pop();  
                 visit(node);  
                 prev = node;  
                 node = null;  
             } else {  
                 node = temp;  
             }  
         }  

     }  
 }  

 /** 非递归实现后序遍历4 双栈法*/  
 protected static void iterativePost4(TreeNode p) {  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     Stack<TreeNode> temp = new Stack<TreeNode>();  
     TreeNode node = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {  
             temp.push(node);  
             stack.push(node);  
             node = node.getRightNode();  
         }  
         if (stack.size() > 0) {  
             node = stack.pop();  
             node = node.getLefTreeNode();  
         }  
     }  
     while (temp.size() > 0) {  
         node = temp.pop();  
         visit(node);  
     }  
 }  

 /** 非递归实现中序遍历 */  
 protected static void iterativeMin(TreeNode p) {  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     while (p != null) {  
         while (p != null) {  
             if (p.getRightNode() != null)  
                 stack.push(p.getRightNode());// 当前节点右子入栈  
             stack.push(p);// 当前节点入栈  
             p = p.getLefTreeNode();  
         }  
         p = stack.pop();  
         while (!stack.empty() && p.getRightNode() == null) {  
             visit(p);  
             p = stack.pop();  
         }  
         visit(p);  
         if (!stack.empty())  
             p = stack.pop();  
         else  
             p = null;  
     }  
 }  

 /** 非递归实现中序遍历2 */  
 protected static void iterativeMin2(TreeNode p) {  
     Stack<TreeNode> stack = new Stack<TreeNode>();  
     TreeNode node = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {  
             stack.push(node);  
             node = node.getLefTreeNode();  
         }  
         if (stack.size() > 0) {  
             node = stack.pop();  
             visit(node);  
             node = node.getRightNode();  
         }  
     }  
 }  

 public static void main(String[] args) {

	  BinaryTree tree = new BinaryTree();
	  // 添加数据测试
	  tree.insert(20);
	  tree.insert(49);
	  tree.insert(123);
	  tree.insert(10);
	  tree.insert(40);
	  tree.insert(3);
	  tree.insert(13);
	  tree.insert(1);

	  System.out.println("root=" + tree.getRoot().getValue());
	  // 排序测试
	  tree.inOrderMin(tree.getRoot());
	  tree.iterativeMin(tree.getRoot());
	  
	  // 查找测试
	//  if (tree.find(10) != null) {
	//   System.out.println("找到了");
	//  } else {
	//   System.out.println("没找到");
	//  }
	//  // 删除测试
	//  tree.find(40).setDelete(true);
	//
	//  if (tree.find(40) != null) {
	//   System.out.println("找到了");
	//  } else {
	//   System.out.println("没找到");
	//  }

	 }
}

