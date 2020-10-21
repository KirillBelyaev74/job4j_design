package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hash<K, V> implements Iterable<V> {

    private Node[] hashtable = new Node[3];
    private Node<K, V> next;
    private Node<K, V> previous;
    private int modCount;
    private int size;

    public boolean insert(K key, V value) {
        boolean result = false;
        if (key != null) {
            Node<K, V> node = new Node<>(key, value, null, this.previous);
            int index = this.getIndex(key);
            if (this.size >= this.hashtable.length - 1) {
                this.doubleSize();
                index = this.getIndex(key);
            }
            if (this.hashtable[index] == null) {
                this.hashtable[index] = node;
                this.next = node;
                this.previous = node;
                result = true;
                this.size++;
                this.modCount++;
            } else if (this.hashtable[index].getKey().equals(key)) {
                this.hashtable[index].setValue(value);
                result = true;
                this.modCount++;
            }
        }
        return result;
    }

    public V get(K key) {
        V result = null;
        int index = this.getIndex(key);
        if (this.hashtable[index] != null && this.hashtable[index].getKey().equals(key)) {
            result = (V) this.hashtable[index].getValue();
        }
        this.modCount++;
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = this.getIndex(key);
        if (this.hashtable[index] != null && this.hashtable[index].getKey().equals(key)) {
            this.hashtable[index] = null;
            result = true;
        }
        this.modCount++;
        this.size--;
        return result;
    }

    private void doubleSize() {
        Node[] elements = this.hashtable;
        this.hashtable = new Node[this.hashtable.length * 2];
        for (int index = 0; index != elements.length; index++) {
            if (elements[index] != null) {
                this.hashtable[this.getIndex((K) elements[index].getKey())] = elements[index];
            }
        }
    }

    public int getIndex(K key) {
        int hash = key.hashCode() ^ (key.hashCode() >>> this.hashtable.length);
        return hash & (this.hashtable.length - 1);
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int expectedModCount = modCount;
            int index;

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (hashtable.length != this.index) {
                    if (hashtable[index] != null) {
                        result = true;
                        break;
                    }
                    this.index++;
                }
                return result;
            }

            @Override
            public V next() {
                if (modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) hashtable[index++].getValue();
            }
        };
    }
}
