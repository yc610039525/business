package org.business.component.pojo;

import java.util.Stack;

/**
 * @Description: 二叉树的定义
 * @date 2014-12-8 上午7:51:49
 */

public class BinaryTree {

 // 根节点
 private Node root;

 public Node getRoot() {
  return root;
 }

 /**
  * 插入操作
  * 
  * @param value
  */
 public void insert(int value) {

  Node newNode = new Node(value);

  if (root == null) {
   root = newNode;
   root.setLefNode(null);
   root.setRightNode(null);
  } else {

   Node currentNode = root;
   Node parentNode;

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
     currentNode = currentNode.getLefNode();
     if (currentNode == null) {
      parentNode.setLefNode(newNode);
      return;
     }

    }
   }
  }
 }

 /**
  * 查找
  * @param key
  * @return
  */
 public Node find(int key) {

  Node currentNode = root;

  if (currentNode != null) {

   while (currentNode.getValue() != key) {

    if (currentNode.getValue() > key) {
     currentNode = currentNode.getLefNode();
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
  * @param Node
  */
 public void inOrderMin(Node Node) {
  if (Node != null && Node.isDelete() == false) {
   inOrderMin(Node.getLefNode());
   System.out.println("------" + Node);
   inOrderMin(Node.getRightNode());
  }
 }
 /**
  * 前序遍历
  * @param Node
  */
 public void inOrderBefore(Node Node) {
	  if (Node != null && Node.isDelete() == false) {
	   System.out.println("--" + Node.getValue());
	   inOrderBefore(Node.getLefNode());
	   inOrderBefore(Node.getRightNode());
	  }
	 }
 public void inOrderAfter(Node Node) {
	  if (Node != null && Node.isDelete() == false) {
	   inOrderAfter(Node.getLefNode());
	   inOrderAfter(Node.getRightNode());
	   System.out.println("--" + Node.getValue());
	  }
	 }
 /** 访问节点 */  
 public static void visit(Node p) {  
     System.out.print(p.getValue() + "---/--- ");  
 }  
 /** 非递归实现前序遍历 */  
 protected static void iterativePre(Node p) {  
     Stack<Node> stack = new Stack<Node>();  
     if (p != null) {  
         stack.push(p);  
         while (!stack.empty()) {  
             p = stack.pop();  
             visit(p);  
             if (p.getRightNode() != null)  
                 stack.push(p.getRightNode());  
             if (p.getLefNode() != null)  
                 stack.push(p.getLefNode());  
         }  
     }  
 }  
 /** 非递归实现前序遍历2 */  
 protected static void iterativePre2(Node p) {  
     Stack<Node> stack = new Stack<Node>();  
     Node node = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {//压入所有的左节点，压入前访问它  
             visit(node);  
             stack.push(node);  
             node = node.getLefNode();  
         }  
         if (stack.size() > 0) {//  
             node = stack.pop();  
             node = node.getRightNode();  
         }  
     }  
 }  
 /** 非递归实现后序遍历 */  
 protected static void iterativePost(Node p) {  
	 Node q = p;  
     Stack<Node> stack = new Stack<Node>();  
     while (p != null) {  
         // 左子树入栈  
         for (; p.getLefNode() != null; p = p.getLefNode())  
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
 protected static void iterativePost2(Node p) {  
     Stack<Node> lstack = new Stack<Node>();  
     Stack<Node> rstack = new Stack<Node>();  
     Node node = p, right;  
     do {  
         while (node != null) {  
             right = node.getRightNode();  
             lstack.push(node);  
             rstack.push(right);  
             node = node.getLefNode();  
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
 protected static void iterativePost3(Node p) {  
     Stack<Node> stack = new Stack<Node>();  
     Node node = p, prev = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {  
             stack.push(node);  
             node = node.getLefNode();  
         }  
         if (stack.size() > 0) {  
        	 Node temp = stack.peek().getRightNode();  
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
 protected static void iterativePost4(Node p) {  
     Stack<Node> stack = new Stack<Node>();  
     Stack<Node> temp = new Stack<Node>();  
     Node node = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {  
             temp.push(node);  
             stack.push(node);  
             node = node.getRightNode();  
         }  
         if (stack.size() > 0) {  
             node = stack.pop();  
             node = node.getLefNode();  
         }  
     }  
     while (temp.size() > 0) {  
         node = temp.pop();  
         visit(node);  
     }  
 }  

 /** 非递归实现中序遍历 */  
 protected static void iterativeMin(Node p) {  
     Stack<Node> stack = new Stack<Node>();  
     while (p != null) {  
         while (p != null) {  
             if (p.getRightNode() != null)  
                 stack.push(p.getRightNode());// 当前节点右子入栈  
             stack.push(p);// 当前节点入栈  
             p = p.getLefNode();  
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
 protected static void iterativeMin2(Node p) {  
     Stack<Node> stack = new Stack<Node>();  
     Node node = p;  
     while (node != null || stack.size() > 0) {  
         while (node != null) {  
             stack.push(node);  
             node = node.getLefNode();  
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
	  
//	   查找测试
	  if (tree.find(10) != null) {
	   System.out.println("找到了");
	  } else {
	   System.out.println("没找到");
	  }
	  // 删除测试
	  tree.find(40).setDelete(true);
	
	  if (tree.find(40) != null) {
	   System.out.println("找到了");
	  } else {
	   System.out.println("没找到");
	  }

	 }
}

