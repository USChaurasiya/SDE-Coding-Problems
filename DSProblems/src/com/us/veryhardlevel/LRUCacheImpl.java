package com.us.veryhardlevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------
 *	Implement LRUCache class for a Least Recently Used cache. The class should support:
 *	1: Inserting Key-value pair with the insertKeyValuePair method.
 *	2: Retrieving a key's value with the getValueFromKey method.
 *	3: Retrieving the most recently used key with the getMostRecentKey method.
 *
 *	LRUCache should have maxSize property to set the size of cache, this size represents 
 *	the maximum number of key value pair that the cache can store at once. if the key-value 
 *	pair is inserted in the cache when it has reached maximum capacity, the least recent used 
 *	key-value pair should be evicted from the cache and no longer retrievable.
 *
 *	Inserting a key-value pair with an existing key should simple replace the key's value in 
 *	the cache with new value.
 *
 *
 *
 *Sample Use Case:
 *
 *	LRUCache(3)
 *	insertKeyValuePair("b", 2)
 *	insertKeyValuePair("a", 1)
 *	insertKeyValuePair("c", 3)
 *	getMostRecentKey()   ---> "c"   c is the most recent key
 *	getValueFromKey("a") ---> 1
 *	getMostRecentKey()   ---> "a"   a is the most recent retrieved key
 *	insertKeyValuePair("d", 4)      cache has 3 entries the lease recently used one is evicted
 *	getValueFromKey("b") ---> None  b was evicted in previous operation
 *	insertKeyValuePair("a", 5)    	a already exist in the cache so its value will be replaced
 *	getValueFromKey("a") ---> 5
 *	
 * 
 * ----------------------------------------------------------------------------------------
 */
public class LRUCacheImpl {
	
	public static void main(String[] args) {
		
		LRUCache lruCache = new  LRUCache(3);
	    lruCache.insertKeyValuePair("b", 2);
	    lruCache.insertKeyValuePair("a", 1);
	    lruCache.insertKeyValuePair("c", 3);
	    System.out.println(lruCache.getMostRecentKey());
	    System.out.println(lruCache.getValueFromKey("a").value);
	    System.out.println(lruCache.getMostRecentKey());
	    lruCache.insertKeyValuePair("d", 4);
	    var evictedValue = lruCache.getValueFromKey("b");
	    System.out.println(evictedValue == null || evictedValue.found == false);
	    lruCache.insertKeyValuePair("a", 5);
	    System.out.println(lruCache.getValueFromKey("a").value);
	}

	static class LRUCache {
		int maxSize;
		Map<String, DoublyLinkedListNode> cache = new HashMap<String, DoublyLinkedListNode>();
		int currentSize = 0;
		DoublyLinkedList listOfMostRecent = new DoublyLinkedList();

		public LRUCache(int maxSize) {
			this.maxSize = maxSize > 1 ? maxSize : 1;
		}
		
		// O(1) Time Complexity 
		public void insertKeyValuePair(String key, int value) {
			if (!cache.containsKey(key)) {
				if (currentSize == maxSize) {
					evictLeastRecent();
				} else {
					currentSize++;
				}
				cache.put(key, new DoublyLinkedListNode(key, value));
			} else {
				replaceKey(key, value);
			}
			updateMostRecent(cache.get(key));
		}

		// O(1) Time Complexity
		public LRUResult getValueFromKey(String key) {
			if (!cache.containsKey(key)) {
				return new LRUResult(false, -1);
			}
			updateMostRecent(cache.get(key));
			return new LRUResult(true, cache.get(key).value);
		}

		public String getMostRecentKey() {
			if (listOfMostRecent.head == null) {
				return "";
			}
			return listOfMostRecent.head.key;
		}

		public void evictLeastRecent() {
			String keyToRemove = listOfMostRecent.tail.key;
			listOfMostRecent.removeTail();
			cache.remove(keyToRemove);
		}

		public void updateMostRecent(DoublyLinkedListNode node) {
			listOfMostRecent.setHeadTo(node);
		}

		public void replaceKey(String key, int value) {
			if (!this.cache.containsKey(key)) {
				return;
			}
			cache.get(key).value = value;
		}
	}

	static class LRUResult {
		boolean found;
		int value;

		public LRUResult(boolean found, int value) {
			this.found = found;
			this.value = value;
		}
	}

	static class DoublyLinkedList {
		DoublyLinkedListNode head = null;
		DoublyLinkedListNode tail = null;

		public void setHeadTo(DoublyLinkedListNode node) {
			if (head == node) {
				return;
			} else if (head == null) {
				head = node;
				tail = node;
			} else if (head == tail) {
				tail.prev = node;
				head = node;
				head.next = tail;
			} else {
				if (tail == node) {
					removeTail();
				}
				node.removeBindings();
				head.prev = node;
				node.next = head;
				head = node;
			}
		}

		public void removeTail() {
			if (tail == null)
				return;
			if (tail == head) {
				head = null;
				tail = null;
				return;
			}
			tail = tail.prev;
			tail.next = null;
		}
	}

	static class DoublyLinkedListNode {
		String key;
		int value;
		DoublyLinkedListNode prev = null;
		DoublyLinkedListNode next = null;

		public DoublyLinkedListNode(String key, int value) {
			this.key = key;
			this.value = value;
		}

		public void removeBindings() {
			if (prev != null) {
				prev.next = next;
			}
			if (next != null) {
				next.prev = prev;
			}
			prev = null;
			next = null;
		}
	}
}
