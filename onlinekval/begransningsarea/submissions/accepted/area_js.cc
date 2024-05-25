#include <iostream>
#include <algorithm>
 
using namespace std;
 
int board[100][100];
int main(){
    int r, k;
    cin >> r >> k;
    for(int i = 1; i<=r; i++)
        for(int j = 1; j<=k; j++)
            cin >> board[i][j];
    int ans = 0;
    for(int i = 1; i<=r; i++)
        for(int j = 1; j<=k; j++){
            if(!board[i][j]) continue;
            ans += max(0, board[i][j] - board[i][j-1]);
            ans += max(0, board[i][j] - board[i][j+1]);
            ans += max(0, board[i][j] - board[i+1][j]);
            ans += max(0, board[i][j] - board[i-1][j]);
            ans += 2;
        }
    cout << ans << endl;
}
