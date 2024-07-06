#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	string str1, str2;
	getline(cin, str1);
	getline(cin, str2);
	int idx = 0;
	int len = str2.size();
	for (int i = 0; i < str1.size(); i++) {
		
		if (idx >= len) {
			idx = 0;
		}
		if (str1[i] == ' ') {
			cout << ' ';
			++idx;
			continue;
		}
		char tmp = str1[i] - str2[idx++] + 'a' -1 ;
		if (tmp < 'a') {
			tmp += 'z' - 'a'+1;
			cout << tmp;
		}
		else {
			cout << tmp;
		}
		
	}
	
	return 0;
}