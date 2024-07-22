#include <iostream>
#include <string>

using namespace std;

int main() {
    string str1, str2;
    getline(cin, str1);
    getline(cin, str2);

    int cnt = 0;
    size_t pos = 0;

    while ((pos = str1.find(str2, pos)) != string::npos) {
        cnt++;
        pos += str2.length(); 
    }

    cout << cnt;
    return 0;
}