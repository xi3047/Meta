package bdfs;

import java.util.ArrayList;
import java.util.List;

public class L78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(res, path, nums, index + 1);
        path.remove(path.size() - 1);

        dfs(res, path, nums, index + 1);
    }
}
