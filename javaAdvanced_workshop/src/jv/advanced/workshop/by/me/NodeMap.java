package jv.advanced.workshop.by.me;

public class NodeMap {
	private static final int INITIAL_SIZE = 4;
	private NodeList buckets[];
	
	public NodeMap() {
		this.buckets = new NodeList[INITIAL_SIZE];
	}
	public void put(String key, String value) {
		int bucketIndex = getKeyIndex(key);
		if(this.buckets[bucketIndex] == null) {
			this.buckets[bucketIndex] = new NodeList();
		}
		NodeList currentBucket = this.buckets[bucketIndex];
		Node nodeToPut = new Node(key, value);
		currentBucket.add(nodeToPut);
	}
	
	public int getKeyIndex(String key) {
		return Math.abs(key.hashCode())% this.buckets.length;
	}
	
}
