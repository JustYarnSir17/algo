#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    int n, m;
    while (1) {
        scanf("%d %d", &n, &m);
        if (n == 0 && m == 0)break;
        if (n <= m) {
            printf("No\n");
            continue;
        }
        else if(n>m) {
            printf("Yes\n");
            continue;
        }
    }
    return 0;

}