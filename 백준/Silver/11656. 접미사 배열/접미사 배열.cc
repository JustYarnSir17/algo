#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;



int main() {

    string str;
    cin >> str;

    vector<string> dic(str.length());


    for (int i = 0; i < str.length(); i++) {
        dic[i] = str.substr(i);
    }
    sort(dic.begin(), dic.end());

    for (int i = 0; i < dic.size(); i++) {
        cout << dic[i] << endl;
    }

    return 0;
}