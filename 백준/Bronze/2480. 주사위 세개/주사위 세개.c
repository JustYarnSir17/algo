#include <stdio.h>

int main()
{
    int a, b, c, count = 0, result, i, j;

    scanf("%d %d %d", &a, &b, &c);
    if (a == b)
    {
        j = a;
        if (b == c)
        {
            count = 2;
        }
        else
            count = 1;
    }
    else if (b == c)
    {
        j = b;
        if (a == b)
        {
            count = 2;
        }
        else
            count = 1;
    }
    else if (a == c)
    {
        j = a;
        if (a == b)
        {
            count = 2;
        }
        else
            count = 1;
    }
    else
        count = 0;
    i = a;
    if (b > i || c > i)
    {
        if (b > c)
            i = b;
        else
            i = c;
    }
    switch (count)
    {
    case 0:
        result = i * 100;
        break;
    case 1:
        result = 1000 + (j * 100);
        break;
    case 2:
        result = 10000 + j * 1000;
        break;
    }
    printf("%d", result);
    return 0;
}