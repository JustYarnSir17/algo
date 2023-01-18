#include <stdio.h>

int main()
{
    int n, m, i, j, re = 0, sum = 0, min = 10000;
    scanf("%d %d", &m, &n);
    for (i = m; i <= n; i++)
    {
        re = 0;
        for (j = 1; j <= i; j++)
        {
            if (i < 2)
            {
                re = 1;
                break;
            }
            if ((i / j) != 0 && (i % j) == 0)
            {
                re++;
            }
        }
        if (re == 2)
        {
            sum += i;
            if (min > i)
            {
                min = i;
            }
        }
    }
    if (sum == 0)
    {
        printf("-1");
    }
    else
        printf("%d\n%d", sum, min);
}