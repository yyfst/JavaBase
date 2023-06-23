package program.algorithm.greedy;

public class LeetCode_134 {
    public static void main(String[] args) {
        LeetCode_134 main = new LeetCode_134();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {30, 40, 50, 10, 20};

        System.out.println(main.canCompleteCircuit(gas, cost));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 剩余的油量。
        int cur = 0;
        // 如果不可达，缺多少油。
        int lack = 0;
        // 重试的起点，即不可达的点。
        int retryIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            // 计算如果到达下一个点，剩多少油。
            cur = cur + gas[i] - cost[i];
            // cur < 0 时不可到达下一个点
            if (cur < 0) {
                // 要想到达，缺多少油
                lack += -cur;
                // 剩余油量重置为零，从下一个点开始重试。
                cur = 0;
                retryIndex = i + 1;
            }
        }
        // 遍历完，看剩余油量能不能填补空缺。如果能，说明从重试节点开始，可以走完一圈。
        return cur >= lack ? retryIndex : -1;
    }
}
