#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define Max 101
char data[Max];
int top;

void init() {
	top = -1;
}

int is_full() {
	return top == Max - 1;
}

int is_empty() {
	return top == -1;
}

void push(char a) {
	if (is_full())
		return -1;
	data[++top] = a;
}

char pop() {
	if (is_empty())
		return -1;
	return data[top--];
}

char peek() {
	if (is_empty())
		return -1;
	return data[top];
}

int main() {
	char arr[101];
	int i,count=0;
	
	while (1) {
		gets(arr);
		if (strcmp(arr, ".") == 0)
			return 0;
		init();
		for (i = 0; i < strlen(arr); i++) {
			if (arr[i] == '(') {
				push(arr[i]);
			}
			else if (arr[i] == '[')
				push(arr[i]);
			else if (arr[i] == ')') {
				if (peek() == '(') {
					pop();
				}
				else
					push(arr[i]);
			}
			else if (arr[i] == ']')
				if (peek() == '[')
					pop();
				else
					push(arr[i]);

		}
		if (top == -1)printf("yes\n");
		else printf("no\n");
	}
}
