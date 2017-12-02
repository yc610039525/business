package org.business.component.pojo;

/**
 * @descrption
 * @author Admin
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

	public TreeNode(TreeNode lefTreeNode, TreeNode rightNode, int value, boolean isDelete) {
		super();
		this.lefTreeNode = lefTreeNode;
		this.rightNode = rightNode;
		this.value = value;
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "TreeNode [ value=" + value + ",lefTreeNode=" + lefTreeNode + ", rightNode=" + rightNode + ", isDelete="
				+ isDelete + "]";
	}
}

/**
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
	 * 
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

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
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
		// 查找测试
	}
}
