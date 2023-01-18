#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define Max 10001
int data[Max];
int top=-1;

int is_empty() {
	return (top==-1);
}

int is_full() {
	return(top == Max - 1);
}

int pop() {
	if (is_empty()) {
		return -1;
	}
	else
		return data[top--];
}

void push(int e) {
	if (is_full())
		perror("bad");
	else
		data[++top] = e;
}

void size() {
	printf("%d\n", top);
}

void peek() {
	if (is_empty())
		printf("-1\n");
	else 
		printf("%d\n", data[top]);
}

int main() {
	int n,i,p,val;
	char arr[10];
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%s", arr);
		if (strcmp(arr, "top")==0) {
			peek();
		}
		else if (strcmp(arr, "size") == 0) {
			printf("%d\n", top + 1);
		}
		else if (strcmp(arr, "empty") == 0) {
			if (is_empty())
				printf("1\n");
			else
				printf("0\n");
		}
		else if (strcmp(arr, "pop") == 0) {
			p = pop();
			printf("%d\n", p);
		}
		else if(strcmp(arr,"push")==0) {
			scanf("%d", &val);
			push(val);
		}
	}
}

