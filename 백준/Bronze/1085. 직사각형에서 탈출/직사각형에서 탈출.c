#include <stdio.h>

int main()
{
    int x, y, w, h, s1, s2;
    scanf("%d %d %d %d", &x, &y, &w, &h);
    s1 = w / 2;
    s2 = h / 2;
    if (x - s1 > 0)
    {
        s1 = w - x;
    }
    else
    {
        s1 = x;
    }
    if (y - s2 > 0)
    {
        s2 = h - y;
    }
    else
    {
        s2 = y;
    }
    if (s1 > s2)
    {
        printf("%d", s2);
    }
    else
    {
        printf("%d", s1);
    }
}