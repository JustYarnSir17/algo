#include <stdio.h>

int main()
{
    int n, *arr, i, j, count = 0, re = 0;
    scanf("%d", &n);
    arr = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (i = 0; i < n; i++)
    {
        re = 0;

        for (j = 1; j <= arr[i]; j++)
        {
            if (arr[i] == 1)
            {
                re = 1;
                break;
            }
            if ((arr[i] / j) != 0 && (arr[i] % j) == 0)
            {

                re++;
            }
        }
        if (re == 2)
        {
            count++;
        }
    }
    printf("%d", count);
}