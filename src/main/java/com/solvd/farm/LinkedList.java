package com.solvd.farm;

import com.solvd.farm.crop.Crop;
import com.solvd.farm.exception.NullValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LinkedList<T> {
    private static final Logger logger = LogManager.getLogger(LinkedList.class);

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

    public void insertatend(T data) {
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
            logger.info("can't delete a Linked list is empty");
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
            logger.info("Node is not present");
        }
    }

    public void printLinkedList() {
        if (head == null) {
            logger.info("can't delete a Linked list is empty");
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                logger.info(currentNode.data + "->");
            }
            logger.info("null");
        }
    }

    public boolean search(Object data) {
        Node<T> node = head;
        while (node != null) {
            if (node.data == data) {
                logger.info("searched item" + node.data);
                return true;
            }
            node = node.next;
        }
        return false;
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
