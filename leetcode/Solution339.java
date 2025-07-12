class Solution339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int level) {
        int res = 0;
        for(NestedInteger value : List<NestedInteger> nestedList) {
            if(value.isInteger()) {
                res += level * value.getInteger();
            } else {
                res += dfs(value.getList(), level + 1);
            }
        }
        return res;
    }
}
