#include <stdio.h>

int fibo(int n)
{
    int i;
    if (n == 1)
    {
        return 1;
    }
    else if (n == 0)
    {
        return 0;
    }
    else if (n >= 2)
    {
        i = fibo(n - 1) + fibo(n - 2);
        return i;
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    printf("%d", fibo(n));
}