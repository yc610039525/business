package org.business.component.pojo;

public class Node {
	// 左节点
	 private Node lefNode;
	 // 右节点
	 private Node rightNode;
	 // 数据
	 private int value;

	 private boolean isDelete;

	 public Node getLefNode() {
	  return lefNode;
	 }

	 public void setLefNode(Node lefNode) {
	  this.lefNode = lefNode;
	 }

	 public Node getRightNode() {
	  return rightNode;
	 }

	 public void setRightNode(Node rightNode) {
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

	 public Node() {
	  super();
	 }

	 public Node(int value) {
	  this(null, null, value, false);
	 }

	 public Node(Node lefNode, Node rightNode, int value,
	   boolean isDelete) {
	  this.lefNode = lefNode;
	  this.rightNode = rightNode;
	  this.value = value;
	  this.isDelete = isDelete;
	 }

	 @Override
	 public String toString() {
	  return "Node [ value=" + value + ",lefNode=" + lefNode + ", rightNode="
	    + rightNode +", isDelete=" + isDelete
	    + "]";
	 }
}
