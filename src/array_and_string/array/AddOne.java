package array_and_string.array;

public class AddOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0){
            return digits;
        }

        //从最后一位+1，如果+1后的数达到10，就进位（前一位+1），否则跳出
        for (int i = digits.length-1; i >= 0; i--){
            digits[i]++;
            if (digits[i] < 10){
                break;
            }else {
                digits[i] = 0;
            }
        }

        //如果第一位也变为0，说明进位后多出了一位，重新构造数组，新数组长度+1，第一位为1，其余都是0
        if (digits[0] == 0){
            int[] newdigits = new int[digits.length+1];
            newdigits[0] = 1;
            for (int i = 1; i < newdigits.length; i++){
                newdigits[i] = 0;
            }

            return newdigits;
        }


        return digits;
    }
}
