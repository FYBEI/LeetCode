package Summary_of_Interview_Problem.math;

public class UglyNum {
    public boolean isUgly(int n) {
        if (n == 0){
            return false;
        }

        if (n == 1 || n == 2 || n == 3 || n == 5){
            return true;
        }

        if (n % 5 == 0){
            return isUgly(n/5);
        }else if (n % 3 == 0){
            return isUgly(n/3);
        }else if (n % 2 == 0){
            return isUgly(n/2);
        }else {
            return false;
        }
    }
}
