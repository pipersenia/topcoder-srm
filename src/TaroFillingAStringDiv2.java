// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
// 
Cat Taro likes strings.
You are given a String S.
Each character of S is 'A', 'B', or '?'.




To Taro, the ugliness of a string is the number of pairs of equal consecutive characters.
For example, the ugliness of "ABABAABBB" is 3: there is one pair "AA" and two (overlapping) pairs "BB".




Taro now wants to change each question mark in S either to 'A' or to 'B'.
His goal is to minimize the ugliness of the resulting string.
Return the smallest ugliness that can be achieved.


DEFINITION
Class:TaroFillingAStringDiv2
Method:getNumber
Parameters:String
Returns:int
Method signature:int getNumber(String S)


CONSTRAINTS
-S will contain between 1 and 50 characters, inclusive.
-S will consist only of characters 'A', 'B' and '?'.


EXAMPLES

0)
"ABAA"

Returns: 1

There is initially one pair of consecutive digits that are equal in this case. There is no characters that Taro has to replace, hence the answer is 1.

1)
"??"

Returns: 0



2)
"A?A"

Returns: 0



3)
"A??B???AAB?A???A"

Returns: 3



4)
"?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?"

Returns: 10



*/
// END CUT HERE
import java.util.*;
public class TaroFillingAStringDiv2 {
    public int getNumber(String S) {
        int res = 0;
        if (S.indexOf("?") == -1) {
        	res = getUgliness(S);
        	return res;
        }
        char[] t = S.toCharArray();
        for(int i = 0; i < S.length(); i++) {
        	if (t[i] == '?') {
        		// two options for replacement
        		int p1 = getNumber(S.substring(0, i) + "A" + S.substring(i+1));
        		int p2 = getNumber(S.substring(0, i) + "B" + S.substring(i+1));
        		return (p1 <= p2) ? p1 : p2;
        	}
        }
        return res;
    }

    private int getUgliness(String s) {
    	int c = 0;
    	for(int i = 0; i < s.length()-1; i++) {
    		if (s.charAt(i) == s.charAt(i+1)) c++;
    	}
    	return c;
	}

	// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TaroFillingAStringDiv2()).getNumber("ABAA"),1);
            eq(1,(new TaroFillingAStringDiv2()).getNumber("??"),0);
            eq(2,(new TaroFillingAStringDiv2()).getNumber("A?A"),0);
            eq(3,(new TaroFillingAStringDiv2()).getNumber("A??B???AAB?A???A"),3);
            eq(4,(new TaroFillingAStringDiv2()).getNumber("?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?"),10);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
