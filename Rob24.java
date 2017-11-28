import java.util.Scanner;

public class Rob24 {

    private static Scanner scanner;
    // 终点
    private static int numsize = 24;
    // 步长
    private static int numstep = 3;
    // 游戏进度
    private static int press = 0;
    // 起步值
    private static int start = 0;
    // 角色 1表示计算机，-1表示玩家
    private static int role = 0;

    public static void main(String[] args) {
	scanner = new Scanner(System.in);
	numsize = intputnum("请输入终点数：", 24, Integer.MAX_VALUE, 2);
	numstep = intputnum("请输入步长：", 3, numsize, 2);
	// 计算起步值
	start = numsize % (numstep + 1);
	// 计算开局优势，有开局优势计算机开始，否则玩家开始
	role = start != 0 ? 1 : -1;
	int go = 0;

	while (press < numsize) {
	    if (role == 1) {
		go=press == 0?start:((numstep + 1) - (press - start) % (numstep + 1));
		press += go;
		System.out.println("计算机加" + go + "步，当前进度为：" + press + "\r\n");
	    } else {
		go = intputnum("请输入进步值", 1, numstep, 1);
		press += go;
		System.out.println("你加" + go + "步，当前进度为：" + press + "\r\n");
	    }
	    if (press == numsize) {
		String strrole = role == 1 ? "计算机" : "你";
		System.out.println("游戏结束!" + strrole + "胜利");
	    }
	    role *= -1;
	}
    }

    public static int intputnum(String message, int def, int max, int min) {
	System.out.println(message);
	int mun = 0;
	try {
	    mun = scanner.nextInt();
	    if (mun > max || mun < min) {
		throw new Exception();
	    }
	} catch (Exception e) {
	    mun = def;
	    System.out.println("输入错误：恢复默认值为：" + mun);
	}
	return mun;
    }
}