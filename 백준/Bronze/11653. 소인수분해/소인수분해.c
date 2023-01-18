#include <stdio.h>

void sol(int a)
{
    int i;
    if (a < 2)
    {
        return;
    }
    for (i = 2; i <= a; i++)
    {
        if (a / i != 0 && a % i == 0)
        {
            printf("%d\n", i);
            a = a / i;
            break;
        }
    }
    sol(a);
}

int main()
{
    int n;
    scanf("%d", &n);
    sol(n);
}