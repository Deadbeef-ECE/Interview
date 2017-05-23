class Solution {
public:
    int level = 0;
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;
        if(root == NULL)    return ret;
        inorder(root, 1, ret);
        return ret;
    }
    
    void inorder(TreeNode* root, int curLevel, vector<int>& ret){
        if(root == NULL)    return;
        if(curLevel > level){
            level = curLevel;
            ret.push_back(root->val);
        }
        inorder(root->right, curLevel + 1, ret);
        inorder(root->left, curLevel + 1, ret);
    }
};


class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;
        queue<TreeNode*> q;
        if(root != NULL)    
            q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode* cur = q.front();
                if(i == size - 1)   ret.push_back(cur->val);
                if(cur->left != NULL)
                    q.push(cur->left);
                if(cur->right != NULL)
                    q.push(cur->right);
                q.pop();
            }
        }
        return ret;
    }
};