#include <stdio.h>
#include <string.h>
#define MAX 50

int main()
{
    char a[MAX + 3], b[] = "??!";
    scanf("%s", a);
    strcat(a, b);
    printf("%s", a);
}