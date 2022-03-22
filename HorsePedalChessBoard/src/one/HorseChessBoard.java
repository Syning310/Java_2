package one;

import java.awt.*;
import java.util.ArrayList;

public class HorseChessBoard {

	private static int X = 6;  // col
	private static int Y = 6;  // row

	private static int[][] chessBoard = new int[Y][X];  // 棋盘
	private static boolean[] visited = new boolean[Y * X];  // 记录某个格子是否走过

	private static boolean finished = false;  // 记录马儿是否遍历完棋盘

	public static void main(String[] args) {

		int row = 2;
		int col = 2;

		// 测试算法
		traversalChessBoard(chessBoard, row - 1, col - 1, 1);

		for (int i = 0; i < Y; ++i){
			for (int j = 0; j < X; ++j) {
				System.out.print(chessBoard[i][j] + "\t");
			}
			System.out.println();
		}

	}

	// 核心算法，遍历棋盘，如果遍历成功，就把finshed设置为true
	// 并且，将马儿走的每一步step，记录到chessBoard
	public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {

		// 先把step记录到chessBoard
		chessBoard[row][col] = step;

		// 把这个位置设置为以访问
		visited[row * X + col] = true;

		// 获取当前这个位置，可以走的下一个位置有哪些
		ArrayList<Point> ps = next(new Point(col, row));

		// 遍历
		while (!ps.isEmpty()) {
			// 取出当前这个ps的第一个位置(点)
			Point p = ps.remove(0);
			// 判断该位置，是否走过，如果没有走过，我们递归遍历
			if (!visited[p.y * X + p.x]) {
				// 递归遍历
				traversalChessBoard(chessBoard, p.y, p.x, step + 1);
			}
		}

		// 当退出while循环后，看是否遍历成功，如果没有成功，就重置相应的值，然后进行回溯
		if (step < X * Y && !finished) {
			// 重置
			chessBoard[row][col] = 0;
			visited[row * X + col] = false;
		} else {
			finished = true;
		}

	}


	// 编写方法，可以获取当前位置，还可以走的下一步的所有位置
	private static ArrayList<Point> next(Point curPoint) {

		// 创建一个ArrayList
		ArrayList<Point> ps = new ArrayList<>();

		// 创建一个Point对象(点/位置)，准备放入到 ps 集合中
		Point p1 = new Point();

		// 判断 curPoint 是否可以走如下位置，如果可以走，就将该点(Point) 放入到 ps 集合

		// 判断是否可以走 5 位置
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 6 位置
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 7 位置
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 0 位置
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 1 位置
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 2 位置
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 3 位置
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}

		// 判断是否可以走 4 位置
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}

		return ps;
	}


}
