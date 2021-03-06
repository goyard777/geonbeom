

interface Queue{
	boolean isEmpty();
	boolean isfull();
	char dequeue();
	char peek();
	void clear();
	void enqueue(char item);
//	큐의 입 /출력 /삭제 /push역할
}



public class sunlist  implements Queue{
	
	
			private int front;
			private int rear;
			private int queuesize;
			private char queueArr[];
//		queue 이외 접근 방법은 불가능하게 해야함  오류날수있음..	
				
			public sunlist(int queuesize) {
				front =-1;
				rear=-1;
				this.queuesize=queuesize;
				queueArr = new char[this.queuesize]; 
			}
			
//	empty 확인
			
			@Override
			public boolean isEmpty() {
				if(front==rear) {
					front=-1;
					rear=-1;
				}
				return (front==rear);
			}
			
			@Override
			public boolean isfull() {
				// TODO Auto-generated method stub
				
				return (rear==this.queuesize-1);
			}
			
			
			@Override
			public char dequeue() {
				// TODO Auto-generated method stub
				if(isEmpty()) {
					System.out.println();
					
					return 0;
				}else {
					System.out.println("삭제"+queueArr[front+1]);
					

					front =(front+1)%this.queuesize;
					// ArrayOutOfBoundException이 발생
					// que 마지막 사이즈에 대한 오류 발생으로 인하여 프론트 길이 조절 이 필요함 .	 원형큐			
					return queueArr[front];
				}
				
			}
			
			@Override
			public char peek() {
				// TODO Auto-generated method stub
				if(isEmpty()) {
					System.out.println("이제 없어");
					
					return 0;
				}else {
					System.out.println(queueArr[front+1]);
					return queueArr[front+1];
				}
			}
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				if(isEmpty()) {
					System.out.println("Queue");
				} else {
					front = -1;    // front 포인터 초기화
					rear = -1;    // rear 포인터 초기화
					queueArr = new char[this.queuesize];   
					System.out.println("Queue is clear!");
				}
			}
			
			
			@Override
			public void enqueue(char item) {
				// TODO Auto-generated method stub
				if(isfull()) {
					System.out.println("Queue is full!");
				} else {             
					queueArr[++rear] = item;   //rear 방향 표시  다음 rear 어디로 가야할지 표시
					System.out.println("입력 : " + item);
				}
			}
			
			
			
			public void printQueue() {
				// TODO Auto-generated method stub
				if(isEmpty()) {
					System.out.println();
				} else {
					
					System.out.print("출력: ");
					
					for(int i=front+1; i<=rear; i++) {
						System.out.print(queueArr[i] + " ");
					}
					
					
					System.out.println();
				}
			}
			
			
			public static void main(String args[]) {
				int queueSize = 5;
				sunlist arrQueue = new sunlist(queueSize);
				
				arrQueue.enqueue('A');
				arrQueue.printQueue();
				
				arrQueue.enqueue('B');
				arrQueue.printQueue();
				
				arrQueue.enqueue('C');
				arrQueue.printQueue();
				
				arrQueue.dequeue();
				arrQueue.printQueue();
				
				arrQueue.dequeue();
				arrQueue.printQueue();
				
				arrQueue.dequeue();
				arrQueue.printQueue();
				
				arrQueue.peek();
				arrQueue.printQueue();			
				
				
			}
			
}

//3월 23일 made kimGeonbeom
