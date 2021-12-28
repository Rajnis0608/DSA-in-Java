package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Map<K,V> {
    ArrayList<Mapnode<K,V>> bucketArray;
    int size;
    int numBuckets;

    public Map() {
        numBuckets = 5;
        bucketArray = new ArrayList<>();
        for (int i=0;i<numBuckets;i++){
            bucketArray.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hashcode = key.hashCode();
        return hashcode % numBuckets;
    }

    private void rehash() {
        System.out.println("ReHashing: buckets:" + numBuckets + " size:" + size);
        ArrayList<Mapnode<K,V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        numBuckets *= 2;
        for (int i=0;i<numBuckets;i++){
            bucketArray.add(null);
        }
        size = 0;
        for (int i=0;i<temp.size();i++){
            Mapnode<K,V> head = temp.get(i);
            while (head!=null){
                insert(head.key,head.value);
                head = head.next;
            }
        }
    }

    public double loadFactor(){
        return (1.0*size)/numBuckets;
    }

    public int size() {
        return size;
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        Mapnode<K,V> head = bucketArray.get(bucketIndex);
        Mapnode<K,V> prev = null;
        while(head!=null){
            if(head.key.equals(key)){
                size--;
                if(prev == null){
                    bucketArray.set(bucketIndex,head.next);
                } else {
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        Mapnode<K,V> head = bucketArray.get(bucketIndex);
        while (head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
     }

    public void insert(K key,V value){
        int bucketIndex = getBucketIndex(key);
        Mapnode<K,V>head = bucketArray.get(bucketIndex);
        while (head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucketArray.get(bucketIndex);
        Mapnode<K,V> newNode = new Mapnode<>(key,value);
        newNode.next = head;
        bucketArray.set(bucketIndex,newNode);
        size++;
        double loadFactor = (1.0*size)/numBuckets;
        if(loadFactor > 0.7){
            rehash();
        }
    }
}
