#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
int count = 0;

int recursion(const char* s, int l, int r) {
    count++;
    if (l >= r) {
        printf("%d %d\n", 1, count);
        count = 0;
    }
    else if (s[l] != s[r]) { printf("%d %d\n", 0, count); 
    count = 0;
    }
    else return recursion(s, l + 1, r - 1);
}

int isPalindrome(const char* s) {
    return recursion(s, 0, strlen(s) - 1);
    
}

int main() {
    int n,i;
    char arr[1001];
    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        scanf("%s", arr);
        isPalindrome(arr);
    }

}