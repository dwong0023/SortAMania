public class Runner {

    public static void main(String args[])
    {
        Team9SortCompetition sorter = new Team9SortCompetition();
        int[] testarr = {7,4,8,2,5,7,8,2,4};
        int[][] testarr2 = {{7,4,8,2,5,7,8,2,4},{0,3,9,1,2,6,10}};
        String[] x = {"lul","hah","memes","destruction","Bob Ross","is THE LORD"};
        System.out.println(sorter.challengeOne(testarr));
        System.out.println(sorter.challengeTwo(testarr, x));
        System.out.println(sorter.challengeThree(testarr));
        System.out.println(sorter.challengeFour(testarr2));
        System.out.println(sorter.challengeFive(testarr, x));
    }
}
