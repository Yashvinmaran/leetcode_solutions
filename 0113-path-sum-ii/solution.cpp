class Solution {
public:
    void helper(TreeNode* node, vector<vector<int>> &result, vector<int> &path, int target) {
        if (node == nullptr) return;
        path.push_back(node->val);
        target -= node->val;
        if (node->left == nullptr && node->right == nullptr && target == 0) {
            result.push_back(path);
        }
        helper(node->left, result, path, target);
        helper(node->right, result, path, target);
        path.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> result;
        vector<int> path;
        helper(root, result, path, targetSum);
        return result;
    }
};

