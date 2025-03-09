package past.Summary_of_Interview_Problem.Hash;

public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 0){
            return 0;
        }else if (columnTitle.length() == 1){
            return columnTitle.charAt(0) - 'A' + 1;
        }

        int num = 0;
        for (int i = 0; i < columnTitle.length(); i++){
            int j = columnTitle.length() - 1 - i;
            int tmp = (columnTitle.charAt(i) - 'A' + 1) * (int) Math.pow(26, j);
            num += tmp;
        }

        return num;
    }

    public static void main(String[] args) {
        TitleToNumber ttn = new TitleToNumber();

        String str = "ZY";
        System.out.print(ttn.titleToNumber(str));
    }
}
