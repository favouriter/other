import java.util.HashSet;
import java.util.Scanner;

/**
 * @author android
 * @date 2017-11-28
 */
public class Black_Hole {
    private static Scanner scanner;
    private static int num;
    private static int min;
    private static int max;
    private static int[] numarr;

    public static void main(String[] args) {
	scanner = new Scanner(System.in);
	try {
	    num = scanner.nextInt();
	    if (num < 1000 || num > 9999) {
		throw new Exception();
	    }
	    while (num != 6174) {
		getarray(num);
		min = getminormax(num, 0);
		max = getminormax(num, 1);
		System.out.printf("原始值%-16d" ,num);
		System.out.printf("最大值%-16d" , max);
		System.out.printf("最小值%-16d" , min);
		System.out.printf("差值%-16d\r\n" , (max - min));
		num = max - min;
	    }
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	}
    }

    private static void getarray(int num) throws Exception {
	HashSet<Integer> set = new HashSet<Integer>();
	numarr = new int[4];
	for (int i = 0; i < 4; i++) {
	    numarr[i] = num % 10;
	    num /= 10;
	    set.add(numarr[i]);
	}
	if (set.size() <= 1) {
	    throw new Exception();
	}
    }

    private static int getminormax(int mun, int mode) {
	int temp = 0;
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if ((numarr[j] > numarr[i] && mode == 0) || (numarr[j] < numarr[i] && mode == 1)) {
		    temp = numarr[j];
		    numarr[j] = numarr[i];
		    numarr[i] = temp;
		}
	    }
	}
	temp = 0;
	temp += numarr[0] * 1000;
	temp += numarr[1] * 100;
	temp += numarr[2] * 10;
	temp += numarr[3];
	return temp;
    }
}
