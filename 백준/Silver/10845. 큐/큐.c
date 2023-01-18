#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define Max 10001
#define Element int

Element data[Max];
int front;
int rear;
void init_queue() {
	front = rear = 0;
}
int is_empty() {
	return front == rear;
}
int is_full() {
	return(rear + 1) % Max == front;
}
int size() {
	return (rear - front + Max) % Max;
}
void enqueue(Element val) {
	if (is_full())
		return-1;
	rear = (rear + 1) % Max;
	data[rear] = val;

}
Element dequeue() {
	if (is_empty())
		return -1;
	front = (front + 1) % Max;
	return data[front];

}
Element peek() {
	if (is_empty())
		return -1;
	return data[(front + 1) % Max];
}
Element back() {
	if (is_empty())
		return -1;
	return data[rear];
}

int  main() {
	int n,i,k,val;
	char arr[6];
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%s", arr);
		if (strcmp(arr, "front")==0) {
			val = peek();
			printf("%d\n", val);
		}
		else if (strcmp(arr, "back") == 0) {
			val = back();
			printf("%d\n", val);
		}
		else if (strcmp(arr, "size") == 0) {
			val = size();
			printf("%d\n", val);
		}
		else if (strcmp(arr, "empty") == 0) {
			if (is_empty())
				printf("1\n");
			else
				printf("0\n");
		}
		else if (strcmp(arr, "pop") == 0) {
			val = dequeue();
			printf("%d\n", val);
		}
		else if (strcmp(arr, "push") == 0) {
			scanf("%d", &val);
			enqueue(val);
		}

	}
	return 0;
}