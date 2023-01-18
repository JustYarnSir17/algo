#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define Max 500002
int data[Max];
int front, rear;

void init_queue();
int is_full();
int is_empty();
void enqueue(int a);
int dequeue();
int peek();


int main() {
	int n,i,val;
	scanf("%d", &n);
	init_queue();
	for (i = 1; i <= n; i++) {
		enqueue(i);
	}
	while ((front + 1) % Max != (rear) % Max) {
		dequeue();
		if ((front+1)%Max==(rear)%Max)
			break;
		val = dequeue();

		enqueue(val);

	}
	val=peek();
	printf("%d", val);
}

void init_queue() {
	front = rear = 0;
}
int is_full() {
	return (rear + 1) % Max == front;
}
int is_empty() {
	return rear == front;
}
void enqueue(int a) {
	if (is_full())
		return -1;
	rear = (rear + 1) % Max;
	data[rear] = a;
}

int dequeue() {
	if (is_empty())
		return -1;
	front = (front + 1) % Max;
	return data[(front)];
}
int peek() {
	if (is_empty())
		return -1;
	return data[(front+1)%Max];
}