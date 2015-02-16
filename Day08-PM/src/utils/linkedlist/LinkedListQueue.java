package utils.linkedlist;

public class LinkedListQueue {
	
	Node front;	// 첫 번째 노드에 대한 참조값 저장
	Node rear;	// 마지막 노드에 대한 참조값 저장
	
	public boolean empty() {
		return (front == null);
	}
	
	public void insert(Object data) {
		Node newNode = new Node(data);	// 새 노드의 참조값을 newNode 변수에 저장
		if (empty()) {	// front == null 인 경우
			front = newNode;	// front에 새 노드 참조값인 newNode 변수 값을 저장
			rear = newNode;		// rear에 새 노드 참조값인 newNode 변수 값을 저장
		}
		else {
			rear.nextNode = newNode;	// 리스트의 마지막 노드에 newNode를 연결 (rear.nextNode에 newNode 변수 값을 저장)
			rear = newNode;		// 마지막 노드를 가리키는 rear 변수가 newNode 변수 값을 가지도록
		}
	}
	
	public Object remove() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		else {
			Object d = front.data;
			front = front.nextNode;	// front를 두 번째 노드로 이동
			return d;
		}
	}
	
}





















