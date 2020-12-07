package HW.HW2;

public class HW2_3 {

    static int[] mostTask(int[] tasks, int[] s, int[] f){
        int[] result = new int[tasks.length];

        int begin = s[0];   //其实时间
        int min = Integer.MAX_VALUE;    //记录最小的持续时间
        int num = 0;

        for (int i = 0; i < tasks.length; i++){

            if (s[i] < begin){
                continue;
            }

            int index = i;  //记录最小持续时间的任务位置
            for (int j = i; j < tasks.length; j++){
                if (s[j] < begin){
                    continue;
                }

                if ((f[j] - begin) < min){
                    min = f[j] - begin;
                    index = j;
                }
            }

            begin = f[index];
            result[num] = index+1;
            num++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] tasks = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s = {2, 2, 3, 4, 6, 7, 9, 10, 13};
        int[] f = {3, 4, 5, 7, 8, 11, 12, 15, 17};

        int[] result = HW2_3.mostTask(tasks, s, f);

        for(int i : result){
            if (i == 0){
                break;
            }
            System.out.println(i);
        }
    }
}
