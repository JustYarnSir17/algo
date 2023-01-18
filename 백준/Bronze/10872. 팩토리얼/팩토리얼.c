#include <stdio.h>

int fac(int n)
{
    int i;
    if (n > 0)
    {
        i = n * fac(n - 1);
        return i;
    }
    else if (n == 0)
    {
        return 1;
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    printf("%d", fac(n));
}