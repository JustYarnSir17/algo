#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
int main() {
    char arr[100];
    int len,i;
    scanf("%s", arr);
    len = strlen(arr);
    for (i = 0; i < len; i++) {
        if (arr[i] <= 90) {
            arr[i] += 32;


        }
        else {
            arr[i] -= 32;
        }
    }
    printf("%s", arr);

}