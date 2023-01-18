#define _SECURE_NO_WARNINGS
#include <stdio.h>
#define Max 10002
#define swap(a,b,temp){temp=a;a=b;b=temp;}


void reverse(char arr[]) {
	int len = strlen(arr);
	int i;
	char temp;
	for (i = 0; i < len/2; i++) {
		swap(arr[i], arr[len - 1 - i], temp);

	}

}

int main() {
	char a[Max]={0}, b[Max]={0}, c[Max]={0};
	int add = 0, i,len,sum;

	scanf("%s %s", a, b);
	reverse(a);
	reverse(b);

	len = strlen(a) > strlen(b) ? strlen(a) : strlen(b);
	for (i = 0; i < len; i++) {
		sum = a[i] - '0' + b[i] - '0' + add;
		while (sum < 0)sum += '0';
		if (sum > 9) add = 1;
		else add = 0;
		c[i] = sum % 10 + '0';
	}
	if (add == 1)
		c[len] = '1';
	reverse(c);
	printf("%s", c);




}