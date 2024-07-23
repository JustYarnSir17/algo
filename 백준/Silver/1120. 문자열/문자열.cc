#include <iostream>
#include <string>

using namespace std;

int main() {
	string str1, str2;
	cin >> str1 >> str2;
	int len1 = str1.length();
	int len2 = str2.length();
	int len = len2 - len1;
	int cnt = 51;
	for (int i = 0; i <= len; i++) {
		int count = 0;
		for (int j = 0; j < len1; j++) {
			if (str1[j] != str2[i + j]) {

				++count;
			}
		}
		cnt = min(cnt, count);
	}
	cout << cnt;

}