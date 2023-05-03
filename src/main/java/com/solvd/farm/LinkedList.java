package com.solvd.farm;
import com.solvd.farm.crop.Crop;
import com.solvd.farm.exception.NullValueException;
public class LinkedList<T> {
    private Node head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public LinkedList() {
        head = null;
        size = 0;
    }
    public void insertAtEnD(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        size++;
    }
    public void insertAtBegin(T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }
    public void delete(T data) {
        if (head == null) {
            System.out.println("can't delete a Linked list is empty");
            return;
        } else {
            if (head.data == data) {
                head = head.next;
                return;
            }
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.data.equals(data)) {
                    currentNode.next = currentNode.next.next;
                    return;
                }
            }
            System.out.println("Node is not present");
        }
    }
    public void printLinkedList() {
        if (head == null) {
            System.out.println("can't delete a Linked list is empty");
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                System.out.println(currentNode.data + "->");
            }
            System.out.println("null");
        }
    }
    public void search(T data) {
        Node<T> node = head;
        while (node.next != null) {
            if (node.data == data) {
                System.out.println("searched item" + node.data);
                return;
            }
            node = node.next;
        }
        System.out.println("Item not found");
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T get(int index) throws NullValueException {
        Node<T> currentNode = head;
        if (index < 0 && index > size) {
            throw new NullValueException("Invalid Index");
        }
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }
}
