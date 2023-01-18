#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define Max 10001
int data[Max];
int front, rear;


void init() {
	front = rear = 0;
}

int is_full() {
	return front % Max == rear + 1 % Max;

}

int is_empty() {
	return rear == front;
}

void push_f(int val) {
	if (is_full())
		return -1;
	data[front] = val;
	front = (front - 1+Max) % Max;
}

void push_b(int val) {
	if (is_full())
		return -1;
	rear = (rear + 1) % Max;
	data[rear] = val;
}

int pop_f() {
	if (is_empty())
		return -1;
	front = (front + 1 )% Max;
	return data[front];

}

int pop_b() {
	int val;
	if (is_empty())
		return -1;
	val = data[rear];
	rear = (rear - 1+Max) % Max;
	return val;
}

int size() {
	return (rear - front + Max) % Max;
}

int f() {
	if (is_empty())
		return -1;
	return data[(front + 1)%Max];
}

int b() {
	if (is_empty())
		return -1;
	return data[(rear) % Max];
}

int main() {
	int n,i,val;
	char arr[11];
	scanf("%d", &n);
	init();
	for (i = 0; i < n; i++) {
		scanf("%s", arr);
		if (strcmp(arr, "push_back") == 0) {
			scanf("%d", &val);
			push_b(val);
		}
		else if (strcmp(arr, "push_front") == 0) {
			scanf("%d", &val);
			push_f(val);
		}
		else if (strcmp(arr, "front") == 0) {
			printf("%d\n", f());
		}
		else if (strcmp(arr, "back") == 0) {
			printf("%d\n", b());

		}
		else if (strcmp(arr, "size") == 0) {
			printf("%d\n", size());
		}
		else if (strcmp(arr, "empty") == 0) {
			printf("%d\n", is_empty());
		}
		else if (strcmp(arr, "pop_front") == 0) {
			printf("%d\n", pop_f());
		}
		else if (strcmp(arr, "pop_back") == 0) {
			printf("%d\n", pop_b());
		}
	}
}