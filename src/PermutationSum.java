// BEGIN CUT HERE
/*
 // PROBLEM STATEMENT
 // We define a permutation of an integer n as an integer that has the same digits as n, but in an arbitrary order. Two permutations of n are considered different if the numbers they represent are not the same. For instance, the set of all possible permutations of the number n = 313 is: {133, 313, 331}. 

 Given an int n, your task is to find the sum of all its permutations. 


 DEFINITION
 Class:PermutationSum
 Method:add
 Parameters:int
 Returns:int
 Method signature:int add(int n)


 CONSTRAINTS
 -n is between 1 and 99999, inclusive.
 -No digits of n are zero.


 EXAMPLES

 0)
 157

 Returns: 2886

 We have: 157 + 175 + 517 + 571 + 715 + 751 = 2886

 1)
 313

 Returns: 777

 We have: 133 + 313 + 331 = 777

 2)
 1234

 Returns: 66660

 3)
 5

 Returns: 5

 4)
 54321

 Returns: 3999960

 5)
 99999

 Returns: 99999

 */
// END CUT HERE
import java.util.*;

public class PermutationSum {
	public int add(int n) {
		int res = 0;
		String num = String.valueOf(n);
		Set<String> permutations = new HashSet<String>();
		permutations = getPermutations(num, permutations);
		System.out.println(permutations);
		for(String str: permutations) {
			res += Integer.valueOf(str);
		}
		return res;
	}

	private Set<String> getPermutations(String num, Set<String> res) {
		if (num.length() == 1) {
			res.add(num);
			return res;
		}
		Set<String> result = new HashSet<String>();
		Set<String> s = new HashSet<String>();
		char prefix = num.charAt(0);
		String remaining = num.substring(1);
		result = getPermutations(remaining, result);
		for (String str: result) {
			for(int j = 0; j <= remaining.length(); j++) {
				String b = str.substring(0,j) + prefix + str.substring(j,remaining.length());
				s.add(b);
			}
		}
		return s;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		try {
			eq(0, (new PermutationSum()).add(157), 2886);
			eq(1, (new PermutationSum()).add(313), 777);
			eq(2, (new PermutationSum()).add(1234), 66660);
			eq(3, (new PermutationSum()).add(5), 5);
			eq(4, (new PermutationSum()).add(54321), 3999960);
			eq(5, (new PermutationSum()).add(99999), 99999);
		} catch (Exception exx) {
			System.err.println(exx);
			exx.printStackTrace(System.err);
		}
	}

	private static void eq(int n, int a, int b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected " + b
					+ ", received " + a + ".");
	}

	private static void eq(int n, char a, char b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected '" + b
					+ "', received '" + a + "'.");
	}

	private static void eq(int n, long a, long b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected \"" + b
					+ "L, received " + a + "L.");
	}

	private static void eq(int n, boolean a, boolean b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected " + b
					+ ", received " + a + ".");
	}

	private static void eq(int n, String a, String b) {
		if (a != null && a.equals(b))
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected \"" + b
					+ "\", received \"" + a + "\".");
	}

	private static void eq(int n, int[] a, int[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: returned " + a.length
					+ " elements; expected " + b.length + " elements.");
			return;
		}
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i]) {
				System.err
						.println("Case "
								+ n
								+ " failed. Expected and returned array differ in position "
								+ i);
				print(b);
				print(a);
				return;
			}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, long[] a, long[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: returned " + a.length
					+ " elements; expected " + b.length + " elements.");
			return;
		}
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i]) {
				System.err
						.println("Case "
								+ n
								+ " failed. Expected and returned array differ in position "
								+ i);
				print(b);
				print(a);
				return;
			}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, String[] a, String[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: returned " + a.length
					+ " elements; expected " + b.length + " elements.");
			return;
		}
		for (int i = 0; i < a.length; i++)
			if (!a[i].equals(b[i])) {
				System.err
						.println("Case "
								+ n
								+ " failed. Expected and returned array differ in position "
								+ i);
				print(b);
				print(a);
				return;
			}
		System.err.println("Case " + n + " passed.");
	}

	private static void print(int a) {
		System.err.print(a + " ");
	}

	private static void print(long a) {
		System.err.print(a + "L ");
	}

	private static void print(String s) {
		System.err.print("\"" + s + "\" ");
	}

	private static void print(int[] rs) {
		if (rs == null)
			return;
		System.err.print('{');
		for (int i = 0; i < rs.length; i++) {
			System.err.print(rs[i]);
			if (i != rs.length - 1)
				System.err.print(", ");
		}
		System.err.println('}');
	}

	private static void print(long[] rs) {
		if (rs == null)
			return;
		System.err.print('{');
		for (int i = 0; i < rs.length; i++) {
			System.err.print(rs[i]);
			if (i != rs.length - 1)
				System.err.print(", ");
		}
		System.err.println('}');
	}

	private static void print(String[] rs) {
		if (rs == null)
			return;
		System.err.print('{');
		for (int i = 0; i < rs.length; i++) {
			System.err.print("\"" + rs[i] + "\"");
			if (i != rs.length - 1)
				System.err.print(", ");
		}
		System.err.println('}');
	}

	private static void nl() {
		System.err.println();
	}
	// END CUT HERE
}
