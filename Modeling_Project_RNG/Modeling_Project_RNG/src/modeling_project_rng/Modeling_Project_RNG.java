package modeling_project_rng;

import java.util.Scanner;

public class Modeling_Project_RNG {

    /*
        1. Linear Congruentail generator (LCG)
        implemented by : Ahmed Farouk
     */
    public static void LCG(int X0, int mod, int a, int c, float[] GeneratedNums, float LengthOfgeneratedNums) {

        GeneratedNums[0] = X0;

        for (int i = 1; i < LengthOfgeneratedNums; i++) {

            GeneratedNums[i] = ((GeneratedNums[i - 1] * a) + c) % mod;
        }
        for (int i = 0; i < LengthOfgeneratedNums; i++) {
            System.out.println(GeneratedNums[i] / mod);
        }
    }

    /*
        3. Inversive Congruentail generator (ICG)
        implemented by : Mahmoud Mustafa
     */
    public static void ICG(int seed, int modulus, int A, float[] GNums, float lenOfNum) {

        GNums[0] = seed;

        for (int i = 1; i < lenOfNum; i++) {

            GNums[i] = (A / GNums[i - 1]) % modulus;
        }
        for (int i = 0; i < lenOfNum; i++) {
            System.out.println("R" + i + " = " + GNums[i] / modulus);
        }
    }

    /*
        5. Lagged Fibonacci generator (LFG)
        implemented by : Erini Sabry
     */
    public static void LFG(int x0, int x1, int m, char sign, int size) {
        int nums[] = new int[size];
        nums[0] = x0;
        nums[1] = x1;
        for (int i = 2; i < size; i++) {
            switch (sign) {
                case '+':
                    nums[i] = (nums[i - 2] + nums[i - 1]) % m;
                    break;
                case '-':
                    nums[i] = (nums[i - 2] - nums[i - 1]) % m;
                    break;
                case '*':
                    nums[i] = (nums[i - 2] * nums[i - 1]) % m;
                    break;
                case '/':
                    nums[i] = (nums[i - 2] / nums[i - 1]) % m;
                    break;
                default:
                    System.out.println("incorrect sign");

            }

        }
        for (int j = 0; j < size; j++) {
            System.out.println("x" + j + " = " + nums[j]);
        }
    }

    /*
        6. Mid-Square method (MSM)
        implemented by : Ismail Ahmed
     */
    public static int MSM(int seed) {

        if (String.valueOf(seed).length() == 4) {

            int seedSquare = seed * seed;

            String temp = Integer.toString(seedSquare);
            int[] numbers = new int[temp.length()];

            for (int i = 0; i < temp.length(); i++) {

                numbers[i] = temp.charAt(i) - '0';
            }

            int[] midNum = new int[4];

            if (numbers.length < 8) {

                for (int i = 0; i < 4; i++) {
                    midNum[i] = numbers[i + 1];
                }

            } else {
                for (int i = 0; i < 4; i++) {
                    midNum[i] = numbers[i + 2];
                }
            }

            StringBuilder builder = new StringBuilder();
            for (int num : midNum) {
                builder.append(num);
            }

            int nextNumber = Integer.parseInt(builder.toString());

            return nextNumber;

        } else {

            return 0;
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int count = 1;

        while (count == 1) {
            System.out.println("---------------------------------");
            System.out.println("Please choose what you want     ");
            System.out.println("---------------------------------");
            System.out.println(" Options :                      |");
            System.out.println("|      0. Exit                  |");
            System.out.println("|      1. LCG                   |");
            System.out.println("|      2. MCG                   |");
            System.out.println("|      3. ICG                   |");
            System.out.println("|      4. MRG                   |");
            System.out.println("|      5. LFG                   |");
            System.out.println("|      6. MID                   |");
            System.out.println("---------------------------------");
            System.out.print(" : ");

            int Switcher;
            Switcher = scan.nextInt();

            switch (Switcher) {
                case 0:
                    count--;
                    break;

                case 1:
                    // Ahmed - LCG
                    System.out.println("LCG");
                    System.out.println("X0=?");
                    int X0 = scan.nextInt();
                    System.out.println("mod=?");
                    int mod = scan.nextInt();
                    System.out.println("a=?");
                    int a = scan.nextInt();
                    System.out.println("c=?");
                    int c = scan.nextInt();
                    System.out.println("Length of generated numbers=?");
                    int LengthOfgeneratedNums = scan.nextInt();
                    float[] GeneratedNums = new float[LengthOfgeneratedNums];
                    LCG(X0, mod, a, c, GeneratedNums, LengthOfgeneratedNums);
                    count--;
                    break;

                case 2:
                    // Nada - MCG
                    System.out.println("MCG");

                    count--;
                    break;

                case 3:
                    // Mahmoud - ICG
                    System.out.println("ICG");

                    System.out.println("Seed (X0) = ?");
                    int seed = scan.nextInt();

                    System.out.println("modulus=?");
                    int modulus = scan.nextInt();

                    System.out.println("A = ?");
                    int A = scan.nextInt();

                    System.out.println("Length of generated numbers=?");
                    int lenOfNum = scan.nextInt();

                    float[] GNums = new float[lenOfNum];
                    ICG(seed, modulus, A, GNums, lenOfNum);

                    count--;
                    break;

                case 4:
                    System.out.println("MRG");

                    count--;
                    break;

                case 5:
                    // Erini - LFG
                    System.out.println("LFG");

                    System.out.print("x0 (seed): ");
                    int x0 = scan.nextInt();

                    System.out.print("\nx1: ");
                    int x1 = scan.nextInt();

                    System.out.print("\nModulus: ");
                    int m = scan.nextInt();

                    System.out.print("\nBinary operator: ");
                    char sign = scan.next().charAt(0);

                    System.out.print("\nnum of random numbers: ");
                    int size = scan.nextInt();
                    LFG(x0, x1, m, sign, size);

                    count--;
                    break;

                case 6:
                    // Ismail - MSM
                    System.out.println("MSM");

                    System.out.print("Enter initial number from only 4 digits : ");
                    int initialNum = scan.nextInt();

                    int[] randNums = new int[4];
                    randNums[0] = initialNum;

                    for (int i = 0; i < 3; i++) {
                        if (MSM(randNums[i]) == 0) {
                            System.out.println("Only 4 digits numbers is allowed ! ");
                            break;
                        }
                        randNums[i + 1] = MSM(randNums[i]);

                    }

                    for (int i = 0; i <= 3; i++) {
                        if (MSM(randNums[i]) == 0) {
                            break;
                        }
                        System.out.print(((float) randNums[i] / 10000) + "  ");
                    }
                    System.out.println();

                    count--;
                    break;

            }
        }

    }
}
