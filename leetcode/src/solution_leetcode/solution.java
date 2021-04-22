package solution_leetcode;
/*
 * @id: 1480. 一维数组的动态和
 * @time:2020-8-17
 * @method:累加就好
 *
 */

import java.util.*;


public class solution {
    public int[] runningSum(int[] nums) {
//      静态数组太耗空间了
//      int[] result = new int [1000];
/*        int vsize = nums.length;
        Vector<Integer> vresult = new Vector<Integer>();
        for(int j=0,sum=0; j<vsize ; j++){
            sum=nums[j]+sum;
            vresult.add(sum);
        }

//      貌似不能用 不懂
//        int[] result = vresult.toArray(new Integer[vresult.size()]);

        int[] result = new int[vsize];

        for(int k=0 ; k<vsize ; k++){
            result[k]=vresult.get(k);
        }

        vresult = null;

        return result;*/

        // 其实不用vector也能试的出来nums大小啊。。。

/*        int vsize = nums.length;
        int[] result = new int [vsize];

        for(int j=0,sum=0; j<vsize ; j++){
            sum=nums[j]+sum;
            result[j]=sum;

        }
        return result;*/


        int vsize = nums.length;
//        int[] result = new int [vsize];

        for (int j = 1; j < vsize; j++) {
            nums[j] = nums[j] + nums[j - 1];
//            result[j]=sum;

        }
        return nums;
    }


    /*
     * @id: 1431. 拥有最多糖果的孩子
     * @time:2020-8-17
     * @method:求最大值的方法还不如自己桶排序来得快。。。
     *
     */

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//      反而还没有下面这个快：）
//      int max = Arrays.stream(candies).max().getAsInt();
        int max = 0;
        for (int i : candies) {
            if (i > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<Boolean>(candies.length);
        for (int i : candies) {
            result.add((i + extraCandies - max) >= 0);
        }

        return result;
    }

    /*
     * @id: 1512. 好数对的数目
     * @time:2020-8-18
     * @method:记下重复数就好 而且不是你拿一个数 去数组里 茫茫人海的找 而是让数组剩下的数过来你这里认亲：）
     *
     */
    public int numIdenticalPairs(int[] nums) {
        int[] nums_info = new int[100];
        int sum = 0;
        for (int i : nums) nums_info[i]++;

        for (int i : nums_info) sum += i * (i - 1) / 2;
        return sum;
    }


    /*
     * @id:1470. 重新排列数组
     * 2020-8-18
     * 其实应该是用linkedList更快的
     * 奈何还有不移动数组元素也做得出来的方法：）
     * */
    // method 1 LinkedList
    public int[] shuffle1(int[] nums, int n) {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list1.add(nums[i]);
        }

        for (int i = n; i < 2 * n; i++) {
            list2.add(nums[i]);
        }

        for (int i = 1; i < n; i++) {
            list1.add(2 * i, list2.get(i - 1));
        }

        return list1.stream().mapToInt(Integer::valueOf).toArray();
    }
    //method 2 数组超级套路
    /*public int[] shuffle(int[] nums, int n) {
        short[] result = new short[n*2];
        for (int i=0, j=0; i < n; i++) {
            nums[j++] = nums[i];
            nums[j++] = nums[n+i];
        }
        return result;
    }
    */


    /*
     * @id:1486. 数组异或操作
     * 2020-8-18
     * 0和任何数异或 并不改变这个数 1和任何数异或等价于取反
     * a = a^0 !b = b^1 b = b^1^1;
     * */

    public int xorOperation(int n, int start) {
        short[] info = new short[10];

        short temp = (short) start;
        for (int i = 0; i < n; i++) {
            start = (short) ((temp + 2 * i) ^ start);

        }
        return start;
    }


    /*
     * 1313. 解压缩编码列表
     * 第一次搞定大小
     * 第二次搞定数组
     * 这种规模貌似原生数组最快：）
     * */
    public int[] decompressRLElist(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        int[] nums_ = new int[sum];
        for (int i = 0, sumI = 0; i < nums.length; i += 2) {

            for (int j = 0; j < nums[i]; j += 1) {
                nums_[sumI] = nums[i + 1];
                sumI++;
            }
        }
        return nums;

    }


    /*
        1488. 避免洪水泛滥

     *
     */


    public int[] avoidFlood(int[] rains) {
        int num_last = -2;
        // int[][] info = new int[100][100];//记录重复元素位置
//        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//        int[] info_id = new int[100];

        Map<Integer, ArrayList<Integer>> info = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (num_last == rains[i]) {
                    int[] a = new int[0];
                    return a;
                }


                num_last = rains[i];
//                rains[i]=-1;
            } else {
                num_last = -1; //重新计数
            }

            if (info.get(rains[i]) != null) { //有之前记录 则copy数组且合并
                info.get(rains[i]).add(i);
//                    temp_.add(i);
//                    temp_[temp_.length]=i;
//                    info.put(rains[i],temp_);
            } else {
                ArrayList temp = new ArrayList();
                temp.add(i);
                info.put(rains[i], temp);
            }

        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : info.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        Map<Integer, Integer> danger = new HashMap<Integer, Integer>();
        int i_last = 1;
        for (int i = 0; i < rains.length; i++) {
            ArrayList b = new ArrayList();
            if (rains[i] != 0) {
                int temp = info.getOrDefault(rains[i], b).size();
                if (temp > 1) { // 次数在两次以上的才值得抽水
                    danger.put(rains[i], temp);
                    // System.out.println(rains[i]);
                }

                if (i_last == 0 && rains[i] != 0) {
                    // System.out.println(rains[i]);
                    if (!danger.isEmpty()) {
                        int[] a = new int[0];
                        return a;
                    }
                }
                rains[i] = -1;
            } else {
                // System.out.println(rains[i]);
                i_last = rains[i];

                if (danger.isEmpty()) {

                    rains[i] = 100;
                    continue;
                } else {
                    // 遍历danger名单 并且按个寻找info 计算间距 如果
                    // 存储 元素:距离 进行进一步比较
                    Map<Integer, Integer> dis = new HashMap<Integer, Integer>();

                    for (Map.Entry<Integer, Integer> entry : danger.entrySet()) {
                        System.out.println("Danger key = " + entry.getKey() + ", value = " + entry.getValue());
                        ArrayList<Integer> temp = info.get(entry.getKey());

                        for (int j = 0; j < temp.size(); j++) {
                            if (i < temp.get(j)) {
                                dis.put(entry.getKey(), temp.get(j) - i);
                                break;
                            }
                        }
                    }


                    Integer min = 100000;
                    Integer min_key = 0;
                    for (Map.Entry<Integer, Integer> entry : dis.entrySet()) {
                        System.out.println("Dis key = " + entry.getKey() + ", value = " + entry.getValue());
                        if (min > entry.getValue()) {
                            min = entry.getValue();
                            min_key = entry.getKey();
                        }
                    }

                    rains[i] = min_key;//抽水
                    System.out.println("min key = " + min_key);
                    if (danger.get(min_key) <= 2) {
                        danger.remove(min_key);
                        info.remove(min_key);
                    } else danger.put(min_key, danger.get(min_key) - 1);
                }
            }
        }
        return rains;
    }


    /*
     * 1395. 统计作战单位数
     *
     * 思路 中间数固定 找两边 然后两边乘积就是所有的可能
     * */
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        // 枚举三元组中的 j
        for (int j = 1; j < n - 1; ++j) {
            int iless = 0, imore = 0;
            int kless = 0, kmore = 0;
            for (int i = 0; i < j; ++i) {
                if (rating[i] < rating[j]) {
                    ++iless;
                }
                // 注意这里不能直接写成 else
                // 因为可能有评分相同的情况
                else if (rating[i] > rating[j]) {
                    ++imore;
                }
            }
            for (int k = j + 1; k < n; ++k) {
                if (rating[k] < rating[j]) {
                    ++kless;
                } else if (rating[k] > rating[j]) {
                    ++kmore;
                }
            }
            ans += iless * kmore + imore * kless;
        }
        return ans;
    }

    public int[] createTargetArray(int[] nums, int[] index) {

        LinkedList<Short> target_ = new LinkedList<Short>();

        for (Short i = 0; i < nums.length; i++) {
            target_.add((short) index[i], (short) nums[i]);
        }

        int[] target = new int[target_.size()];
        for (Short i = 0; i < target_.size(); i++) {
            target[i] = target_.get(i);
        }


        return target;
    }

    /*
     * 1365. 有多少小于当前数字的数字
     * */

    public int[] smallerNumbersThanCurrent(int[] nums) {
        LinkedList<Short> a = new LinkedList<Short>();
        for (int i : nums) {
            a.add((short) i);
        }
//        Comparator<Short> comp = new Comparator<Short>() {
//            @Override
//            public int compare(Short o1, Short o2) {
//                if(o1>o2) return 1;
//                else
//                return 0;
//            }
//        };

        Collections.sort(a);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a.indexOf((short) nums[i]) + 1;

        }
        return nums;
    }


    public int[] smallerNumbersThanCurrent1(int[] nums) {
        // 统计出现频率 frequency
        Short[] freq = new Short[101]; // 索引即数值
        for (int num : nums) freq[num] = 1;

        // 对频率(而非对原数组nums)从前到后累加
        for (int i = 1; i < freq.length; i++) {
            freq[i] = (short) (freq[i] + freq[i - 1]);
        }

        // 输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) res[i] = freq[nums[i] - 1];
            else res[i] = 0;
        }
        return res;
    }


    /*### version 1 直接除法
        public int findNumbers(int[] nums) {
            int ans=0;
            for(int i:nums){
                for(int j=1; j<=5; j+=2){
                    short temp = (short)(i/Math.pow(10,j));
                    if(temp>=1&&temp<10) ans++;
                }

            }
            return ans;
        }
    ### version 2 字符串 valueof 统计字符数量
        public int findNumbers(int[] nums) {
            int res=0;
            for(int i:nums){
                if(String.valueOf(i).length()%2==0){
                    res++;
                }
            }

            return res;
        }

    ### version 3 对数的效果 在数据不大 没有超过int范围的情况下 貌似比value of还要好*/
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            if ((Math.log10(i) + 1) % 2 == 0) ans++;
        }

        return ans;
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int sec = 0;
        // int[] i = new int[2];
        for (int i = 0; i < points.length; i++) {
            int x = Math.abs(points[i + 1][0] - points[i][0]);
            int y = Math.abs(points[i + 1][1] - points[i][1]);
            sec += Math.max(x, y);
        }
        return sec;
    }

    public int[] processQueries(int[] queries, int m) {
        LinkedList<Short> a = new LinkedList<Short>();
        int[] result = new int[m];
        for (Short i = 1; i <= m; i++) {
            a.add(i);
        }
        for (Short i : a) {
            System.out.println(i);
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = a.indexOf((short) queries[i]);
            System.out.println(result[i]);
            a.remove(result[i]);
            a.add(0, (short) queries[i]);

        }
        return result;
    }


    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0, n = arr.length;
        int[] sum = new int[1001];
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk)), r = Math.min(1000, Math.min(rj, rk));
                    if (l <= r) {
                        if (l == 0) {
                            ans += sum[r];
                        } else {
                            ans += sum[r] - sum[l - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; ++k) {
                ++sum[k];
            }
        }
        return ans;
    }

    public int[] replaceElements(int[] arr) {
        LinkedList<Integer> index = new LinkedList<Integer>();
        LinkedList<Integer> value = new LinkedList<Integer>();

//        int[] temp = new int[arr.length];
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(j);
            temp.add(arr[i]);
        }
        Arrays.sort(arr);
        Integer max_index = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            Integer index_ = temp.indexOf(arr[j]);
            if (index_ > max_index) {
                value.add(arr[j]);
                index.add(index_);
                max_index = temp.indexOf(arr[j]);
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (value.get(0) > temp.get(i) && i < index.get(0)) temp.set(i, value.get(0));
            else if (i == index.get(0)) {
                value.remove(0);
                index.remove(0);
                temp.set(i, value.get(0));
            }

        }
        temp.set(arr.length - 1, -1);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.get(i);

        }
        return arr;
    }

}

