#include <stdio.h>
#include <stdlib.h>
int main()
{
    int n, i, j, temp;
    int *arr;
    scanf("%d", &n);
    arr = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (i = 0; i < n; i++)
    {
        for (j = i; j < n; j++)
        {
            if (arr[i] > arr[j])
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    for (i = 0; i < n; i++)
    {
        printf("%d\n", arr[i]);
    }
}