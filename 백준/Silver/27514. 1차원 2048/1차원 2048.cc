#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// 숫자가 2의 몇 번째 제곱인지 확인하는 함수
int getPower(long num) {
    int power = 0;
    while (num > 1) {
        num /= 2;
        power++;
    }
    return power;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<long> arr(63, 0); // 0부터 62까지 인덱스 사용 가능
    int answer = 0;

    // 입력된 숫자의 제곱수를 카운트
    for (int i = 0; i < n; i++) {
        long tmp;
        cin >> tmp;
        if (tmp > 0) {
            int num = getPower(tmp); // 숫자가 몇 번째 2의 제곱인지 계산
            arr[num]++;
        }
    }

    // 2개 이상일 때, 상위 제곱수로 올리기
    for (int i = 0; i <= 61; i++) {
        if (arr[i] >= 2) {
            int count = arr[i] / 2;
            arr[i] -= count * 2; // 두 개씩 짝을 이루어 합침
            arr[i + 1] += count; // 상위로 넘김
        }
    }

    // 가장 큰 제곱수를 찾기
    for (int i = 62; i >= 0; i--) {
        if (arr[i] > 0) {
            answer = i;
            break;
        }
    }

    long long num = 1LL << answer; // 2^answer 계산
    cout << num << endl;

    return 0;
}