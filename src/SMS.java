// BEGIN CUT HERE
/*
 // PROBLEM STATEMENT
 // Short message service (SMS) has become a fast and quick method for communication. Most service providers place a restriction on the size of messages and hence it is important to write concise messages. Mobile phone users have found methods for compressing their messages such that the content of the messages remains unaltered. One such method is to take the original message and remove all interior vowels from each word. A vowel is interior if there is at least one consonant to the left and right (not necessarily adjacent) of the vowel in the same word.

 Given a String originalMessage with words separated by spaces return the compressed version of the message.


 DEFINITION
 Class:SMS
 Method:compress
 Parameters:String
 Returns:String
 Method signature:String compress(String originalMessage)


 NOTES
 -Vowels are 'a', 'e', 'i', 'o' and 'u' (in both upper and lower cases).


 CONSTRAINTS
 -originalMessage will contain between 0 and 50 characters inclusive.
 -originalMessage will contain only letters ('a'-'z', 'A'-'Z') and spaces.


 EXAMPLES

 0)
 "Lets meet tomorrow"

 Returns: "Lts mt tmrrw"

 "Lets" becomes "Lts". "meet" becomes "mt". "tomorrow" becomes "tmrrw".

 1)
 "Please come to my party"

 Returns: "Plse cme to my prty"

 Note that vowels on the end of words are not compressed.

 2)
 " I  like your   style "

 Returns: " I  lke yr   style "

 Note that 'y' is always considered a consonant in this problem.

 */
// END CUT HERE
import java.util.*;

public class SMS {
	public String compress(String originalMessage) {

		List<String> words = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		String w = "";
		for (int i = 0; i < originalMessage.length(); i++) {
			char ch = originalMessage.charAt(i);
			if (ch == ' ') {
				sb.append(ch);
			} else {
				int j = originalMessage.indexOf(" ", i);
				
				//end of the sentence
				if (j < 0) {
					w = originalMessage.substring(i);
					words.add(w);
					w = processedWord(w);
					sb.append(w);
					break;
				} else {
					w = originalMessage.substring(i, j);
					words.add(w);
					w = processedWord(w);
					sb.append(w);
					i = j-1;
				}
			}
		}
		return sb.toString();
	}

	private String processedWord(String w) {
		Set<Integer> s = new HashSet<Integer>();
		boolean leftV = false, rightV = false;
		for (int i = 0; i < w.length(); i++) {
			if (isVowel(w.charAt(i))) {
				//searchLeft
				for(int k = i-1; k >=0; k--) {
					if (!isVowel(w.charAt(k))) {
						leftV = true;
						break;
					}
				}
				//searchRight
				for (int k = i+1; k < w.length(); k++) {
					if (!isVowel(w.charAt(k))) {
						rightV = true;
						break;
					}
				}
				if (leftV && rightV)
					s.add(i);
				leftV = false; rightV = false;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < w.length(); i++) {
			if (!s.contains(i)) sb.append(w.charAt(i));
		}
		return sb.toString();
	}
	
	private boolean isVowel(char ch) {
		return "AEIOUaeiou".indexOf(ch) != -1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		try {
			eq(0, (new SMS()).compress("Lets meet tomorrow"), "Lts mt tmrrw");
			eq(1, (new SMS()).compress("Please come to my party"),
					"Plse cme to my prty");
			eq(2, (new SMS()).compress(" I  like your   style "),
					" I  lke yr   style ");
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
