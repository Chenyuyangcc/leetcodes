import com.sun.org.apache.bcel.internal.generic.POP;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.ir.BreakableNode;
import jdk.nashorn.internal.ir.ForNode;

import javax.xml.stream.events.EndDocument;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.annotation.Target;
import java.security.Key;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.Set;

/**
 * ClassName:Q1
 * Package:  PACKAGE_NAME
 * user: 28407
 * Description:
 *
 * @Create:2024/3/12-18:24
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]>minHeap=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (minHeap.size()<k)
                minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                if (entry.getValue()>minHeap.peek()[1]){
                    minHeap.poll();
                    minHeap.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = Objects.requireNonNull(minHeap.poll())[0];
        }
        return ans;
    }
}

//class Solution {
//    class Myqueue{
//        LinkedList<Integer>queue=new LinkedList<>();
//        void pop(int val){
//            if(!queue.isEmpty()&&queue.peek()==val)
//                queue.poll();
//        }
//        void push(int val){
//            while (!queue.isEmpty()&&queue.peekLast()<val)
//                queue.pollLast();
//            queue.offer(val);
//        }
//        int front() {
//            return queue.peek();
//        }
//
//    }
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        Myqueue myqueue =new Myqueue();
//        List<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            myqueue.push(nums[i]);
//        }
//        arrayList.add(myqueue.front());
//        for (int i = k; i < nums.length ; i++) {
//            myqueue.pop(nums[i-k]);
//            myqueue.push(nums[i]);
//            arrayList.add(myqueue.front());
//
//        }
//        int[] array = new int[arrayList.size()];
//
//        // 将ArrayList中的元素复制到int[]数组中
//        for (int i = 0; i < arrayList.size(); i++) {
//            array[i] = arrayList.get(i);
//        }
//        return array;
//    }
//}
//class Solution {
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < tokens.length; i++) {
//            String token = tokens[i];
//            if (isOperator(token)) {
//                // 如果是运算符，则从栈中弹出两个操作数进行运算
//                int operand2 = stack.pop();
//                int operand1 = stack.pop();
//                int result = evaluate(operand1, operand2, token);
//                stack.push(result);
//            } else {
//                // 如果是操作数，则将其转换为整数并压入栈中
//                stack.push(Integer.parseInt(token));
//            }
//        }
//
//        // 栈顶元素即为表达式的计算结果
//        return stack.pop();
//    }
//
//    // 判断是否为运算符
//    private boolean isOperator(String token) {
//        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
//    }
//
//    // 执行运算
//    private int evaluate(int operand1, int operand2, String operator) {
//        switch(operator) {
//            case "+":
//                return operand1 + operand2;
//            case "-":
//                return operand1 - operand2;
//            case "*":
//                return operand1 * operand2;
//            case "/":
//                return operand1 / operand2;
//            default:
//                throw new IllegalArgumentException("Invalid operator: " + operator);
//        }
//    }
//}

//class Solution {
//    public String removeDuplicates(String s) {
//        Stack<Character>characterStack=new Stack<>();
//        char[]chars=s.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            if (characterStack.isEmpty()||chars[i]!=characterStack.peek())
//                characterStack.push(chars[i]);
//            else
//                characterStack.pop();
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!characterStack.isEmpty()) {
//            sb.insert(0, characterStack.pop()); // 将栈顶元素插入到字符串的开头
//        }
//        return sb.toString();
//    }
//}

//class Solution {
//    public boolean isValid(String s) {
//        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        if (s.length() / 2 != 0)
//            return false;
//        for (char aChar : chars) {
//            if (aChar == '(')
//                stack.push(')');
//            else if (aChar == '[')
//                stack.push(']');
//            else if (aChar == '{')
//                stack.push('}');
//            else if (stack.isEmpty() || stack.peek() != aChar)
//                return false;
//            else
//                stack.pop();
//        }
//        return stack.isEmpty();
//    }
//}
//class MyStack {
//        Queue<Integer> queue;
//    public MyStack() {
//        queue =new LinkedList<>();
//    }
//
//    public void push(int x) {
//        queue.offer(x);
//    }
//
//    public int pop() {
//        int size = queue.size();
//        size--;
//        while (size--!=0){
//            queue.offer(queue.poll());
//        }
//        return queue.poll();
//    }
//
//    public int top() {
//        return ((LinkedList<Integer>) queue).getLast();
//    }
//
//    public boolean empty() {
//        return queue.isEmpty();
//    }
//}
//class MyQueue {
//    Stack<Integer> stackIn;
//    Stack<Integer> stackOut;
//
//    public MyQueue() {
//        stackIn = new Stack<>();
//        stackOut = new Stack<>();
//    }
//
//    public void push(int x) {
//        stackIn.push(x);
//    }
//
//    public int pop() {
//        if (!stackOut.isEmpty()) {
//            while (!stackIn.isEmpty()) {
//                stackOut.push(stackIn.peek());
//                stackIn.pop();
//            }
//        }
//        int res;
//        res = stackOut.peek();
//        stackOut.pop();
//        return res;
//    }
//
//    public int peek() {
//        int res = this.pop();
//        stackOut.push(res);
//        return res;
//    }
//
//    public boolean empty() {
//        return stackIn.isEmpty() && stackOut.isEmpty();
//    }
//}

//class Solution {
//    public boolean repeatedSubstringPattern(String s) {
//        String doubles = s + s;
//        String newDoubles = doubles.substring(1, doubles.length() - 1);
//        return newDoubles.contains(s);
//    }
//}
//class Solution {
//    public void reverseString(char[] s, int begin, int end) {
//        while (begin < end) {
//            char temp;
//            temp = s[begin];
//            s[begin] = s[end];
//            s[end] = temp;
//            begin++;
//            end--;
//        }
//    }
//    public String reverseWords(String s) {
//        s = s.trim();
//        // 使用正则表达式拆分字符串，将其分割成单词数组
//        String[] words = s.split("\\s+");
//        // 逆序排列单词数组
//        StringBuilder reversed = new StringBuilder();
//        for (int i = words.length - 1; i >= 0; i--) {
//            reversed.append(words[i]);
//            if (i > 0) {
//                reversed.append(" ");
//            }
//        }
//        return reversed.toString();
//    }
//}
//    int len = s.length();
//    char[] chars = s.toCharArray();
//        for (int i = 0; i < len; i += 2 * k) {
////            给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
////            如果剩余字符少于 k 个，则将剩余字符全部反转。
////            如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//        if (i + 2 * k - 1 <= len - 1) {
//        reverseString(chars, i, i + k - 1);
//        continue;
//        }
//        if (len - i < k) {
//        reverseString(chars, i, len - 1);
//        } else {
//        reverseString(chars, i, i + k - 1);
//        }
//        }
//        return new String(chars);
//        } public String reverseStr(String s, int k) {

//class Solution {
//    public void reverseString(char[] s) {
//        int len =s.length;
//        int l=0;
//        int r=len-1;
//        while (l<r){
//            char temp ;
//            temp=s[l];
//            s[l]=s[r];
//            s[r]=temp;
//            l++;
//            r--;
//        }
//    }
//}
//class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-3; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            for (int j = i + 1; j < nums.length-2; j++) {
//                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
//                int left = j + 1;
//                int right = nums.length - 1;
//                while (left < right) {
//                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
//                    if (sum == target) {
//                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                        left++;
//                        right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        right--;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}
//class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > target && nums[i] > 0)
//                break;
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] > target && nums[j] > 0)
//                    break;
//                if (j > i + 1 && nums[j] == nums[j - 1])
//                    continue;
//                int left = j + 1;
//                int right = nums.length - 1;
//                int sum = nums[i] + nums[j];
//                while (left < right) {
//                    sum = sum + nums[left] + nums[right];
//                    if (sum > target) {
//                        right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        right--;
//                        left++;
//                    }
//                    sum = nums[i] + nums[j];
//                }
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > target && nums[i] > 0)
//                break;
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0)
//                    break;
//                if (j > i + 1 && nums[j] == nums[j - 1])
//                    continue;
//                int left = j + 1;
//                int right = nums.length - 1;
//                while (left < right) {
//                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
//                    if (sum > target) {
//                        right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while (left < right && nums[right] == nums[--right]);
//                        while (left < right && nums[left] == nums[++left]);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > target && (nums[i] >= 0||target>=0))
//                break;
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] > target && (nums[i] + nums[j] >= 0||target>=0))
//                    break;
//                if (j > i + 1 && nums[j] == nums[j - 1])
//                    continue;
//                int left = j + 1;
//                int right = nums.length - 1;
//                while (left < right) {
//                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
//                        right--;
//                    }
//                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
//                        left++;
//                    }
//                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
//                        List<Integer> tempList = new ArrayList<>();
//                        tempList.add(nums[i]);
//                        tempList.add(nums[j]);
//                        tempList.add(nums[left]);
//                        tempList.add(nums[right]);
//                        result.add(tempList);
//                        while (left < right && nums[right] == nums[right - 1])
//                            right--;
//                        while (left < right && nums[left] == nums[left + 1])
//                            left++;
//                        right--;
//                        left++;
//                    }
//                }
//
//            }
//
//        }
//        return result;
//    }
//}
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0)
//                break;
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                if (nums[i] + nums[left] + nums[right] > 0) {
//                    right--;
//                }
//                if (nums[i] + nums[left] + nums[right] < 0) {
//                    left++;
//                }
//                if (nums[i] + nums[left] + nums[right] == 0) {
//                    List<Integer> tempList = new ArrayList<>();
//                    tempList.add(nums[i]);
//                    tempList.add(nums[left]);
//                    tempList.add(nums[right]);
//                    result.add(tempList);
//                    while (left < right && nums[right] == nums[right - 1])
//                        right--;
//                    while (left < right && nums[left] == nums[left + 1])
//                        left++;
//                    right--;
//                    left++;
//                }
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        int count = 0;
//        Map<Integer, Integer> hashmap = new HashMap<>();
//        for (int num1 : nums1)
//            for (int num2 : nums2)
//               // int sum = num1 + num2;
//                hashmap.put(num1+num2, hashmap.getOrDefault(num1+num2, 0) + 1);
//        for (int j : nums3)
//            for (int k : nums4)
//                if (hashmap.containsKey(-(j + k)))
//                    count += hashmap.get(-(j + k));
//        return count;
//    }
//}

//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int s = target - nums[i];
//            if (hashMap.containsKey(s)) {
//                int[] res = {hashMap.get(nums[i]), i};
//                return res;
//            }
//            hashMap.put(nums[i], i);
//        }
//        return null;
//    }
//}

//class Solution {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> result = new HashSet<>();
//        int[] hash = new int[1001];
//        for (int num : nums1) {
//            hash[num] = 1;
//        }
//        for (int num : nums2) {
//            if (hash[num] == 1)
//                result.add(num);
//        }
//        int[] arr = new int[result.size()];
//        int j = 0;
//        for (int i : result) {
//            arr[j++] = i;
//        }
//        return arr;
//    }
//}

//class Solution {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> result = new HashSet<>();
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums1)
//            set.add(num);
//        for (int num : nums2) {
//            if (set.contains(num))
//                result.add(num);
//        }
//        int[] array = new int[result.size()];
//        int index = 0;
//        for (int num : result) {
//            array[index++] = num;
//        }
//        return array;
//    }
//}
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        int[] hash = new int[26];
//        for (int i = 0; i < s.length(); i++)
//            hash[s.charAt(i) - 'a']++;
//        for (int i = 0; i < t.length(); i++)
//            hash[t.charAt(i) - 'a']--;
//        for (int i = 0; i < 25; i++)
//            if (hash[i] != 0) return false;
//        return true;
//    }
//}
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lenA = 0;
//        int lenB = 0;
//        ListNode curA = headA;
//        ListNode curB = headB;
//        while (curA != null) {
//            lenA++;
//            curA = curA.next;
//        }
//        while (curB != null) {
//            lenB++;
//            curB = curB.next;
//        }
//        if (lenA == 0 || lenB == 0) return null;
//        curA = headA;
//        curB = headB;
//        if (lenA > lenB) for (int i = 0; i < lenA - lenB; i++)
//            curA = curA.next;
//        if (lenA < lenB) for (int i = 0; i < lenB - lenA; i++)
//            curB = curB.next;
//        while (curA != null) if (curA == curB) return curA;
//        else {
//            curA = curA.next;
//            curB = curB.next;
//        }
//        return null;
//    }
//}
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == slow) {
//                ListNode index1 = fast;
//                ListNode index2 = head;
//                while (index1 != index2) {
//                    index1 = index1.next;
//                    index2 = index2.next;
//                }
//                return index1;
//            }
//        }
//        return null;
//    }
//}
//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummyHead = new ListNode(0,head);
//        ListNode cur = dummyHead;
//        while (cur.next!=null&&cur.next.next!=null){
//            ListNode temp1 = cur.next;
//            ListNode temp2 = cur.next.next.next;
//            cur.next = temp1.next;
//            cur.next.next = temp1;
//            temp1.next = temp2;
//            cur = cur.next.next;
//        }
//        return dummyHead.next;
//    }
//}


//    实现 MyLinkedList 类：
//    class MyLinkedList {
//    int size;//定义链表大小
//    ListNode dummyHead;//虚拟头结点
//    //    MyLinkedList() 初始化 MyLinkedList 对象。
//    public MyLinkedList() {
//        //初始化链表为空
//        size = 0;
//        dummyHead = new ListNode(0);
//    }
//    //    int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
//    public int get(int index) {
//        if (index > size - 1)
//            return -1;
//        ListNode cur = dummyHead;
//            while (index-- > 0)
//                cur = cur.next;
//       return cur.next.val;
//    }
////    void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
//    public void addAtHead(int val) {
//        ListNode head = new ListNode(val);
//        head.next = dummyHead.next;
//        dummyHead.next = head;
//        size++;
//    }
////    void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
//    public void addAtTail(int val) {
//        ListNode tail = new ListNode(val,null);
//        ListNode cur = dummyHead;
//        int tempSize = size;
//        while (tempSize-- > 0)
//            cur = cur.next;
//        cur.next = tail;
//        size++;
//    }
////    void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
////    如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将不会插入到链表中。
//    public void addAtIndex(int index, int val) {
//        if (index == size)
//            addAtTail(val);
//        else if (index < size) {
//            ListNode add = new ListNode(val);
//            ListNode cur = dummyHead;
//            while (index-- >0)
//                cur = cur.next;
//            add.next=cur.next;
//            cur.next=add;
//            size++;
//        }
//    }
////    void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
//    public void deleteAtIndex(int index) {
//        if ( index < size){
//            ListNode cur = dummyHead;
//            while (index-->0)
//                cur = cur.next;
//            cur.next = cur.next.next;
//            size--;
//        }
//    }
//}


//class Solution {
//    public int[][] generateMatrix(int n) {
//        int [][]array =new int[n][n];
//        int circle = n/2;
//        int number = 1;
//        int start =0;
//        int x,y;
//        int offset = 0;
//        if (n%2!=0)
//            array[n/2][n/2]=n*n;
//        while (circle > 0){
//            x = start;
//            y = start;
//            for (;x < n - offset - 1;x++)
//                array[y][x] = number++;
//            for (;y < n - offset - 1;y++)
//                array[y][x] = number++;
//            for (;x > start;x--)
//                array[y][x] = number++;
//            for (;y > start;y--)
//                array[y][x] = number++;
//            start++;
//            offset++;
//            circle--;
//        }
//        return array;
//    }
//}
//class Solution {
//    public int minSubArrayLen(int target, int[] nums) {
//        int result = Integer.MAX_VALUE;
//        int start = 0;
//        int sum = 0;
//        for (int end = 0;end < nums.length;end++){
//            sum += nums[end];
//            while (sum >= target){
//                result = Math.min(result,end - start + 1);
//                sum -= nums[start++];
//            }
//        }
//        return result == Integer.MAX_VALUE ? 0 : result;
//    }
//}
//class Solution {
//    public int minSubArrayLen(int target, int[] nums) {
//        int len = nums.length;
//        int res = len;
//        int sum = Arrays.stream(nums).sum();
//        if (sum < target)
//            return 0;
//        for (int i = 0; i < len; i++) {
//            int temp = 0;
//            for (int j = i; j < len; j++) {
//                 temp += nums[j];
//                 if(temp >= target){
//                     int cur = j - i + 1;
//                     res = Math.min(cur,res);
//                     break;
//                 }
//            }
//        }
//        return res;
//    }
//}


//class Solution {
//    public int[] sortedSquares(int[] nums) {
//        int len = nums.length;
//        int left = 0;
//        int right = len - 1;
//        int index = len - 1;
//        int []res = new int[len];
//        while (left <= right){
//            if (nums[left] * nums[left] <= nums[right] * nums[right])
//                res[index--] = nums[right] * nums[right--];
//            else
//                res[index--] = nums[left] * nums[left++];
//        }
//        return res;
//    }
//}
//class Solution {
//    public int[] sortedSquares(int[] nums) {
//        int len = nums.length;
//        int []array = new int[len];
//        for (int i = 0; i < len; i++)
//            array[i] = nums[i] * nums[i];
//        Arrays.sort(array);
//        return array;
//    }
//}
//暴力解法
//class Solution {
//    public int removeElement(int[] nums, int val) {
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            if (nums[i] == val) {
//                for (int j = i + 1; j < length; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                i--;
//                length--;
//            }
//        }
//        return length;
//    }
//}


//class Solution {
//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length-1;
//        while (left <= right){
//            int middle = (left + right)/2;
//            if (nums[middle] == target)
//                return middle;
//            else if (nums[middle] > target) {
//                right = middle - 1;
//            }
//            else
//                left = middle + 1;
//            nums.
//        }
//       return left;
//    }
//}
//    public ListNode trainningPlan(ListNode head) {
//        ListNode cur = head;
//        ListNode pre = null;
//        while (cur != null){
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//    }
//    public ListNode trainningPlan(ListNode head) {
//        if (head == null)
//            return null;
//        //把链表中的元素全部存储到数组中去
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (head != null) {
//            arrayList.add(head.val);
//            head = head.next;
//        }
//        //将该数组逆序
//        Collections.reverse(arrayList);
//        //创建一个新链表
//        int length = arrayList.size();
//        ListNode newHead = new ListNode(arrayList.get(0));
//        ListNode cur = newHead;
//        for (int i = 1; i < length; i++) {
//            cur.next = new ListNode(arrayList.get(i));
//            cur = cur.next;
//        }
//        return newHead;
//
//    }
//class Solution {
//    public ListNode deleteNode(ListNode head, int val) {
//        if (head.val == val)
//            head = head.next;
//        else {
//            ListNode cur = head.next;
//            ListNode pre = head;
//            while (cur != null) {
//                if (cur.val == val)
//                {
//                    pre.next = cur.next;
//                    break;
//                }
//                else {
//                    pre = cur;
//                    cur = cur.next;
//                }
//            }
//        }
//        return head;
//    }
//}
//class Solution{
//    public static LinkedList<Integer> listToStack(ListNode head) {
//        LinkedList<Integer> stack = new LinkedList<>();
//        while (head != null) {
//            stack.push(head.val);
//            head = head.next;
//        }
//        return stack;
//    }
//    public int[] reverseBookList(ListNode head) {
//        LinkedList<Integer> stack = listToStack(head);
//        int[] array = new int[stack.size()];
//       int index = 0;
//        while (!stack.isEmpty()){
//        array[index++] = stack.pop();
//       }
//        return array;
//    }
//
//}


//class Solution{
//    ArrayList<Integer> tmp = new ArrayList<>();//创建tmp用于存储 整型链表结点的值
//    public int[] reverseBookList(ListNode head) {
//        recur(head);
//        //创建数组输出结果
//    int []array = new int[tmp.size()];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = tmp.get(i);
//        }
//    return array;
//    }
//    //递归让链表结点值反序输入tmp中
//void recur(ListNode head){
//        if (head == null)
//            return;
//        recur(head.next);
//        tmp.add(head.val);
//
//}
//}

//class solution {
//
//    public static int[] listToArray(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//
//        int[] array = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
//
//        return array;
//    }
//
//    public int[] reverseBookList(ListNode head) {
//        ListNode prev = null;
//
//        while (head != null) {
//            ListNode nextTemp = head.next;
//            head.next = prev;
//            prev = head;
//            head = nextTemp;
//        }
//
//        return listToArray(prev);
//    }
//
//}

