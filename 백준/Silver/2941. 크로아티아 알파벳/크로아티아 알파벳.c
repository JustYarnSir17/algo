#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define Max 200

int main() {
	char arr[Max];
	int count=0,i;

	fgets(arr, 200, stdin);
	arr[strlen(arr) - 1] = 0;

	for (i = 0; i < strlen(arr); i++) {
		if (arr[i] == 'c') {
			if (arr[i + 1] == '=')
			{
				count++;
				i = i + 1;
				
			}
			else if (arr[i + 1] == '-') {
				count++;
				i = i + 1;
			}
			else
			{
				count++;
				
			}
		}
		else if (arr[i] == 'd') {
			if (arr[i + 1] == 'z' && arr[i + 2] == '=') {
				count++;
				i = i + 2;
				
			}
			else if (arr[i + 1] == '-') {
				count++;
				i = i + 1;
				
			}
			else
			{
				count++;
				
			}
		}
		else if (arr[i] == 'l' && arr[i + 1] == 'j') {
			count++;
			i = i + 1;
	
		}
		else if (arr[i] == 'n' && arr[i + 1] == 'j') {
			count++;
			i = i + 1;
		
		}
		else if (arr[i] == 's' || arr[i] == 'z') {
			if (arr[i + 1] == '=') {
				count++;
				i = i + 1;
			
			}
			else
			{
				count++;
			
			}
		}
		else
			count++;
	}
	printf("%d", count);

	
}
