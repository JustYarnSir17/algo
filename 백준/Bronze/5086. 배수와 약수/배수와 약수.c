#include <stdio.h>

int main()
{
    int i, j, k;

    while (1)
    {

        scanf("%d %d", &i, &j);
        if (i == 0 && j == 0)
            break;

        if (i > j)
        {
            k = i % j;
            if (k == 0)
                printf("multiple\n");
        }
        else
        {
            k = j % i;
            if (k == 0)
                printf("factor\n");
        }
        if (k != 0)
            printf("neither\n");
    }
    return 0;
}