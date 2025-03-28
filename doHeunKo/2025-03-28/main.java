package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

   public static void main(String[] args) throws FileNotFoundException {
      // TODO Auto-generated method stub
      System.setIn(new FileInputStream("src/algorithm/input.txt"));

           // P10808 클래스의 객체를 생성

      P1159();


           // test() 메서드를 호출
      //P10808();
      //P2979();

   }


   public static void P2309() {
      Scanner scanner = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int sum = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }

        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == sum - 100) {
                    first = a[i];
                    second = a[j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == first || a[i] == second) {
                continue;
            }
            res.add(a[i]);
        }

        Collections.sort(res);

        for (int ele : res) {
            System.out.println(ele);
        }

   }

   public static void P10808(){
      Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();


        int[] cnt = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // 소문자인 경우에만 처리
                cnt[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(cnt[i] + " ");
        }

   }

   public static void P2979(){
      Scanner scanner = new Scanner(System.in);

              int[] arr = new int[104];
              int from, to;
              int a = scanner.nextInt();
              int b = scanner.nextInt();
              int c = scanner.nextInt();
              int ret = 0;

              for (int i = 0; i < 3; i++) {
                  from = scanner.nextInt();
                  to = scanner.nextInt();
                  for (int j = from; j < to; j++) {
                      arr[j]++;
                  }
              }

              scanner.close();

              for (int i = 0; i < 104; i++) {
                  if (arr[i] == 1) {
                      ret += a;
                  } else if (arr[i] == 2) {
                      ret += 2 * b;
                  } else if (arr[i] == 3) {
                      ret += 3 * c;
                  }
              }

              System.out.println(ret);
          }

   public static void P10988() {
      Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        int sz = s.length();
        int res = 1;

        for (int i = 0; i < sz / 2; i++) {
            if (s.charAt(i) != s.charAt(sz - 1 - i)) {
                res = 0;
                break;
            }
        }

        System.out.println(res);
   }
   public static void P1159() {
      Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[26];
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            String name = scanner.next();
            arr[name.charAt(0) - 'a']++;
        }

        scanner.close();

        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                result.add((char) (i + 'a'));
            }
        }

        if (result.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            for (char c : result) {
                System.out.print(c);
            }
        }
   }

   public static void P11655() {
      Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                res.append((char) ((c + 13 > 'Z') ? (c + 13 - 26) : (c + 13)));
            } else if (c >= 'a' && c <= 'z') {
                res.append((char) ((c + 13 > 'z') ? (c + 13 - 26) : (c + 13)));
            } else {
                res.append(c);
            }
        }

        System.out.println(res);
   }
   public static void P9996() {
      Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String star = scanner.next();

        int pos = star.indexOf('*');
        String pre = star.substring(0, pos);
        String suf = star.substring(pos + 1);

        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            if (pre.length() + suf.length() > str.length()) {
                System.out.println("NE");
            } else if (!pre.equals(str.substring(0, pos)) ||
                       !suf.equals(str.substring(str.length() - suf.length()))) {
                System.out.println("NE");
            } else {
                System.out.println("DA");
            }
        }

        scanner.close();
   }
   public static void P2559() {
Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] psum = new int[n + 1];
        int max_n = -1000000;

        for (int i = 1; i <= n; i++) {
            int temp = scanner.nextInt();
            psum[i] = psum[i - 1] + temp;
        }

        for (int i = k; i <= n; i++) {
            max_n = Math.max(max_n, psum[i] - psum[i - k]);
        }

        System.out.println(max_n);

        scanner.close();
   }
   public static void P1620() {
Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();
        int t = scanner.nextInt();

        Map<Integer, String> mp1 = new HashMap<>();
        Map<String, Integer> mp2 = new HashMap<>();

        for (int i = 1; i <= cnt; i++) {
            String name = scanner.next();
            mp1.put(i, name);
            mp2.put(name, i);
        }

        for (int i = 0; i < t; i++) {
            String q = scanner.next();

            if (q.chars().allMatch(Character::isDigit)) {
                System.out.println(mp1.get(Integer.parseInt(q)));
            } else {
                System.out.println(mp2.get(q));
            }
        }

        scanner.close();
   }
   public static void P9375() {
      Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            Map<String, Integer> mp = new HashMap<>();
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                String k1 = scanner.next(); // 의상 이름 (사용하지 않음)
                String k2 = scanner.next(); // 의상 종류
                mp.put(k2, mp.getOrDefault(k2, 0) + 1);
            }

            int ret = 1;
            for (int count : mp.values()) {
                ret *= (count + 1);
            }

            System.out.println(ret - 1);
        }

        scanner.close();
   }
   public static void P1213() {
      Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        Map<Character, Integer> mp = new HashMap<>();
        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        char oddChar = 0;
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddChar = entry.getKey();
                oddCount++;
            }
        }

        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder firstHalf = new StringBuilder();
            StringBuilder secondHalf = new StringBuilder();

            for (char c = 'Z'; c >= 'A'; c--) {
                if (mp.containsKey(c)) {
                    while (mp.get(c) > 1) {
                        firstHalf.insert(0, c);
                        secondHalf.append(c);
                        mp.put(c, mp.get(c) - 2);
                    }
                }
            }

            if (oddCount == 1) {
                firstHalf.append(oddChar);
            }

            System.out.println(firstHalf.toString() + secondHalf.toString());
        }
   }
   public static void P1940() {
      Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        Map<Character, Integer> mp = new HashMap<>();
        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        char oddChar = 0;
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddChar = entry.getKey();
                oddCount++;
            }
        }

        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder firstHalf = new StringBuilder();
            StringBuilder secondHalf = new StringBuilder();

            for (char c = 'Z'; c >= 'A'; c--) {
                if (mp.containsKey(c)) {
                    while (mp.get(c) > 1) {
                        firstHalf.insert(0, c);
                        secondHalf.append(c);
                        mp.put(c, mp.get(c) - 2);
                    }
                }
            }

            if (oddCount == 1) {
                firstHalf.append(oddChar);
            }

            System.out.println(firstHalf.toString() + secondHalf.toString());
        }
   }
   public static void P3986() {
      Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        Map<Character, Integer> mp = new HashMap<>();
        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        char oddChar = 0;
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddChar = entry.getKey();
                oddCount++;
            }
        }

        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder firstHalf = new StringBuilder();
            StringBuilder secondHalf = new StringBuilder();

            for (char c = 'Z'; c >= 'A'; c--) {
                if (mp.containsKey(c)) {
                    while (mp.get(c) > 1) {
                        firstHalf.insert(0, c);
                        secondHalf.append(c);
                        mp.put(c, mp.get(c) - 2);
                    }
                }
            }

            if (oddCount == 1) {
                firstHalf.append(oddChar);
            }

            System.out.println(firstHalf.toString() + secondHalf.toString());
        }
   }
   public static void P1629() {

   }
   public static void P4375() {
      Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long num = scanner.nextLong();
            long cnt = 1;
            long ret = 1;
            while (true) {
                if (cnt % num == 0) {
                    System.out.println(ret);
                    break;
                } else {
                    cnt = cnt * 10 + 1;
                    cnt %= num;
                    ret++;
                }
            }
        }
        scanner.close();
   }

}