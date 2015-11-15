class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ret;
        vector<int> status(n);
        solve(0, n, status, ret);
        return ret;
    }
    
    void solve(int row, int n, vector<int> &status, vector<vector<string>> &ret){
        if(row == n){
            vector<string> sol(n, string(n, '.'));
            for(int i = 0; i < n; i++)
                sol[i][status[i]] = 'Q';
            ret.push_back(sol);
            return;
        }
        
        for(int j = 0; j < n; j++){
            status[row] = j;
            if(valid(row, status))
                solve(row + 1, n, status, ret);
        }
    }
    
    bool valid(int row, vector<int> &status){
        for(int i = 0; i < row; i++){
            if(status[i] == status[row] || abs(i - row) == abs(status[i] - status[row]))
                return false;
        }
        return true;
    }
};