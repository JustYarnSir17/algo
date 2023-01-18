#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
char arr[101][101];
int dir=0;
/*dir 0=남 1=서 2북 3동*/



int main() {
	int n, i,j, row, col,min_r=50,max_r=50,min_c=50,max_c=50;
	int range_r, range_c;
	char* a;
	row = col = 50;

	scanf("%d", &n);
	a = (char*)malloc(sizeof(char) * n);
	scanf("%s", a);
	for (i = 0; i < n; i++) {
		if (a[i] == 'R') {
			dir++;
			if (dir >= 4)
			{
				dir -= 4;
			}
		}
		else if (a[i] == 'L') {
			dir--;
			if (dir < 0) {
				dir += 4;
			}
		}
			else if (a[i] == 'F') {
				if (dir == 0) {
					arr[row][col] = '.';
					row++;
					if (row > max_r)
						max_r = row;
				}
				else if (dir == 1) {
					arr[row][col] = '.';
					col--;
					if (col < min_c)
						min_c = col;
				}
				else if (dir == 2) {
					arr[row][col] = '.';
					row--;
					if (row < min_r)
						min_r = row;
				}
				else if (dir == 3) {
					arr[row][col] = '.';
					col++;
					if (col > max_c)
						max_c = col;
				}

			}

		}
	arr[row][col] = '.';


	for (i = min_r; i <= max_r; i++) {
		for (j = min_c; j <= max_c; j++) {
			if (arr[i][j] != '.') {
				arr[i][j] = '#';
			}
		}
	}
	for (i = min_r; i <= max_r; i++) {
		for (j = min_c; j <= max_c; j++) {
			printf("%c", arr[i][j]);
			}
		printf("\n");
		}
	}