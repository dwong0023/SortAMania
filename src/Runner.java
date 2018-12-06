public class Runner {

    public static int[] intarr = new int[10000];
    public static String[] stringarr = new String[10000];
    public static int[] bigarr = new int[100000];
    public static int[][] dblintarr = new int[1000][1000];
    public static Comparable[] mysteryarr = new Comparable[10000];

    String[] x = {"lul","hah","memes","destruction","Bob Ross","is THE LORD"};

    public static void main(String args[])
    {
        Team9SortCompetition sorter = new Team9SortCompetition();
        arraysetup();
        System.out.println(sorter.challengeOne(intarr));
        System.out.println(sorter.challengeTwo(stringarr, "apples"));
        System.out.println(sorter.challengeThree(bigarr));
        System.out.println(sorter.challengeFour(dblintarr));
        System.out.println(sorter.challengeFive(mysteryarr, 586));
    }

    public static void arraysetup()
    {
        for(int i = 0; i < intarr.length; i++)
        {
            intarr[i] = (int)(Math.random()*10000);
        }

        for(int i = 0; i < stringarr.length; i++)
        {
            String word = "";
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s,","t","u","v","w","x","y","z"};
            for(int k =0; k < 5;k++)
            {
                word = word + alphabet[(int)(Math.random()*26)];
            }
            stringarr[i] = word;
        }

        for(int i = 0; i < bigarr.length; i++)
        {
            bigarr[i] = (int)(Math.random()*10000);
            //have to make 75% sorted
        }
        threequartsort(bigarr);

        for(int i = 0; i < 1000; i++)
        {
            for(int k = 0;k < 1000;k++)
            {
                dblintarr[i][k] = (int) (Math.random() * 10000);
            }
        }

        for(int i = 0; i < mysteryarr.length; i++)
        {
            mysteryarr[i] = intarr[(int)(Math.random()*10000)];
        }
    }

    public static void threequartsort(int[] array)
    {
        int temp = 0;
        for(int k = 0; k < 7500; k++)
        {
            for(int i = 0; i < 7500 - 1; i++)
            {
                if(array[i] > array[i+1])
                {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
}
