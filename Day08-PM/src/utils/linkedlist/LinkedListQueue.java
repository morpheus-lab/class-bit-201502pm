package utils.linkedlist;

public class LinkedListQueue {
	
	Node front;	// ù ��° ��忡 ���� ������ ����
	Node rear;	// ������ ��忡 ���� ������ ����
	
	public boolean empty() {
		return (front == null);
	}
	
	public void insert(Object data) {
		Node newNode = new Node(data);	// �� ����� �������� newNode ������ ����
		if (empty()) {	// front == null �� ���
			front = newNode;	// front�� �� ��� �������� newNode ���� ���� ����
			rear = newNode;		// rear�� �� ��� �������� newNode ���� ���� ����
		}
		else {
			rear.nextNode = newNode;	// ����Ʈ�� ������ ��忡 newNode�� ���� (rear.nextNode�� newNode ���� ���� ����)
			rear = newNode;		// ������ ��带 ����Ű�� rear ������ newNode ���� ���� ��������
		}
	}
	
	public Object remove() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		else {
			Object d = front.data;
			front = front.nextNode;	// front�� �� ��° ���� �̵�
			return d;
		}
	}
	
}





















