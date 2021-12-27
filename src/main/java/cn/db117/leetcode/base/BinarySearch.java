package cn.db117.leetcode.base;

/**
 * 二分搜索
 *
 * @author db117
 * @date 2020/9/20/020 14:26
 **/
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        System.out.println(search.bsLeftMax(new int[]{
                        1, 2, 3, 4, 5, 9, 9, 9, 9, 9, 11, 15
                },
                11));
        System.out.println(search.bsLeftMax(new int[]{
                        9, 9, 9, 9, 9
                },
                8));
    }

    /**
     * 精准查询,查询不到返回-1
     */
    public int bs(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 偶数取左边
            int mid = left + ((right - left) >> 1);

            int num = nums[mid];
            if (num == target) {
                // 找到返回
                return mid;
            } else if (num < target) {
                // 移动左边界
                left = mid + 1;
            } else {
                // 移动右边界
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 找到最左边的索引,找不到返回-1
     */
    public int bsLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num < target) {
                // 移动左边界
                left = mid + 1;
            } else if (num > target) {
                // 移动右边界
                right = mid - 1;
            } else {
                // 锁定左边
                right = mid - 1;
            }
        }
        // 检查越界,是否找到
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int bsLeft1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 左边中位数
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                // 移动左边界
                // 上面选择左边中位数,所有加一
                left = mid + 1;
            } else {
                // 大于等于则保持右边界
                // 等于则继续往左边查找
                right = mid;
            }
        }

        // 需要判断是否找到
        return nums[right] == target ? right : -1;
    }

    /**
     * 查找最右边的索引,找不到返回-1
     */
    public int bsRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num < target) {
                // 移动左边界
                left = mid + 1;
            } else if (num > target) {
                // 移动右边界
                right = mid - 1;
            } else {
                // 锁定右边,移动左边界
                left = mid + 1;
            }
        }
        // 检查越界,是否找到
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public int bsRight1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 选右边中位数
            int mid = left + ((right - left + 1) >> 1);
            if (nums[mid] <= target) {
                // 小于移动左边界
                // 上面选择的是右边中位数,所以这里不加一
                // 等于则继续往右边寻找
                left = mid;
            } else {
                // 移动右边界
                right = mid - 1;
            }
        }

        // 需要判断是否找到
        return nums[right] == target ? right : -1;
    }

    /**
     * 找小于目标的最大值
     */
    public int bsLeftMax(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 选右边中位数
            int mid = left + ((right - left + 1) >> 1);
            if (nums[mid] < target) {
                // 当前值可能是目标值,继续往右边找
                left = mid;
            } else {
                // 当前值不可能是目标值,想左边找
                right = mid - 1;
            }
        }
        // 防止所有数据都大于目标值
        return nums[right] < target ? right : -1;
    }


    /**
     * 找大于目标的最小值
     */
    public int bsRightMin(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 选右边中位数
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                // 当前值不可能是目标,继续往右边找
                left = mid + 1;
            } else {
                // 当前值可能是目标,继续往左边找
                right = mid;
            }
        }
        // 防止所有数据都小于目标值
        return nums[right] > target ? right : -1;
    }
}