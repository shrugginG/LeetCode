# 算法思想

## 排序



### 选择排序



### 插入排序



### 希尔排序



### 归并排序



### 快速排序



### 堆排序



## 双指针

双指针的基本思想就是对一个可以通过对一个有序的序列进行同时前后指针的遍历进行查找符合条件的元素。

涉及题目：

1. [1] TwoSum

2. [15] ThreeSum

3. [633] Sum of Square Numbers (Easy)

   这一题的关键在于右指针要从sqrt(target)起始，这样的话时间复杂度就是O(sqrt(target))

4. [345] Reverse Vowels of a String

   这一题可以使用哈希表进行查找，用空间复杂度来换取时间复杂度的降低。

   ```
   Character[] vowelChars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
   List<Character> chars = Arrays.asList(vowelChars);
   Set<Character> vowels = new HashSet<>(chars);
   ```

5. [680] Valid Palindrome II (Easy)

   这一题要注意可以删除一个字符，在第一次遇到左右指针所指字符不相等时，左指针向后移动或者右指针向前移动是要分两种情况讨论的。

6. [88] Merge Sorted Array (Easy)

7. [141] Linked List Cycle (Easy)

   使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。

   注意如果我们使用while(fast != slow)作为判断条件时，就需要将slow指针设为head而将fast指针设为head.next，这样的话才能满足初始的判断条件。

   若想使用slow=fast=head的初试指针也可以改为 do while结构。

8. [524] Longest Word in Dictionary through Deleting (Medium)



## 二分查找

```
Input : [1,2,3,4,5]
key : 3
return the index : 2
```

```
public int binarySearch(int[] nums, int key) {
    int l = 0, h = nums.length - 1;
    while (l <= h) {
        int m = l + (h - l) / 2;
        if (nums[m] == key) {
            return m;
        } else if (nums[m] > key) {
            h = m - 1;
        } else {
            l = m + 1;
        }
    }
    return -1;
}
```

**时间复杂度**

二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。

**m 计算**

有两种计算中值 m 的方式：

- m = (l + h) / 2
- m = l + (h - l) / 2

l + h 可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围。但是 l 和 h 都为正数，因此 h - l 不会出现加法溢出问题。所以，最好使用第二种计算法方法。

**未成功查找的返回值**

循环退出时如果仍然没有查找到 key，那么表示查找失败。可以有两种返回值：

- -1：以一个错误码表示没有查找到 key
- l：将 key 插入到 nums 中的正确位置

## 

###  哈希表

为什么我们要规定初始时慢指针在位置 `head`，快指针在位置 `head.next`，而不是两个指针都在位置 `head`（即与「乌龟」和「兔子」中的叙述相同）？

- 观察下面的代码，我们使用的是 `while` 循环，循环条件先于循环体。由于循环条件一定是判断快慢指针是否重合，如果我们将两个指针初始都置于 `head`，那么 `while` 循环就不会执行。因此，我们可以假想一个在 `head` 之前的虚拟节点，慢指针从虚拟节点移动一步到达 `head`，快指针从虚拟节点移动两步到达 `head.next`，这样我们就可以使用 `while` 循环了。
- 当然，我们也可以使用 `do-while` 循环。此时，我们就可以把快慢指针的初始值都置为 `head`。
