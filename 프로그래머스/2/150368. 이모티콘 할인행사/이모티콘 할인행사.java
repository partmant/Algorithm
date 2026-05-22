class Solution {
    private static final int[] DISCOUNTS = {10, 20, 30, 40};

    private int maxJoin = 0;
    private int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] selectedDiscounts = new int[emoticons.length];

        dfs(0, selectedDiscounts, users, emoticons);

        return new int[]{maxJoin, maxSales};
    }

    private void dfs(int depth, int[] selectedDiscounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            calculate(selectedDiscounts, users, emoticons);
            return;
        }

        for (int discount : DISCOUNTS) {
            selectedDiscounts[depth] = discount;
            dfs(depth + 1, selectedDiscounts, users, emoticons);
        }
    }

    private void calculate(int[] selectedDiscounts, int[][] users, int[] emoticons) {
        int joinCount = 0;
        int sales = 0;

        for (int[] user : users) {
            int userDiscount = user[0];
            int userLimit = user[1];

            int total = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (selectedDiscounts[i] >= userDiscount) {
                    total += emoticons[i] * (100 - selectedDiscounts[i]) / 100;
                }
            }

            if (total >= userLimit) {
                joinCount++;
            } else {
                sales += total;
            }
        }

        if (joinCount > maxJoin) {
            maxJoin = joinCount;
            maxSales = sales;
        } else if (joinCount == maxJoin && sales > maxSales) {
            maxSales = sales;
        }
    }
}
