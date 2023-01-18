#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define Max 100001
int top;
int data[Max];

void init_stack();
int is_full();
int is_empty();
void push(int a);
void pop();



int main() {
	int k,i,value,sum=0;
	scanf("%d", &k);
	for (i = 0; i < k; i++) {
		scanf("%d", &value);
		if (value == 0) {
			pop();
		}
		else
			push(value);
	}
	for (i = 0; i < top+1; i++) {
		sum += data[i];
	}
	printf("%d", sum);

}


void init_stack() {
	top = -1;
}
int is_full() {
	return (top == Max - 1);

}
int is_empty() {
	return (top == -1);
}
void push(int a) {
	if (is_full()) {
		return -1;
	}
	else {
		data[++top] = a;
	}
}
void pop() {
	if (is_empty()) {
		return -1;
	}
	else {
		data[top--]=0;
	}
}
