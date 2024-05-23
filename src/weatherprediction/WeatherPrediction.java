///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package weatherprediction;
//
//import java.util.Scanner;
//
//public class WeatherPrediction {
//
//    public static double combineCF(double cf1, double cf2) {
//        if (cf1 > 0 && cf2 > 0) {
//            return cf1 + cf2 * (1 - cf1);
//        } else if (cf1 < 0 && cf2 < 0) {
//            return cf1 + cf2 * (1 + cf1);
//        } else if (cf1 < 0 || cf2 < 0) {
//            return (cf1 + cf2) / (1 - Math.min(Math.abs(cf1), Math.abs(cf2)));
//        }
//        return 0;
//    }
//
//    public static double getUserInput(String str, Scanner scanner) {
//        while (true) {
//            System.out.print(str);
//            try {
//                double cf = Double.parseDouble(scanner.nextLine().trim());
//                if (cf >= -1 && cf <= 1) {
//                    return cf;
//                } else {
//                    System.out.println("Please enter a value between -1 and 1.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a numerical value between -1 and 1.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("********************");
//        System.out.println("Tala Mahmoud Ismail*");
//        System.out.println("********************");
//        System.out.println("Id: 202010022");
//        System.out.println("********************");
//        System.out.println("Enter the conditions for today:");
//        System.out.print("Is it raining today? type(yes/no): ");
//        String today = scanner.nextLine().trim().toLowerCase();
//
//        boolean todayIsRain;
//        boolean todayIsDry;
//
//        if (today.equals("yes")) {
//            todayIsRain = true;
//            todayIsDry = false;
//        } else if (today.equals("no")) {
//            todayIsRain = false;
//            todayIsDry = true;
//        } else {
//            System.out.println("Invalid input.");
//            return;
//        }
//
//        boolean rainfallIsLow = false;
//        double rainfallCF = 0;
//        if (todayIsRain) {
//            System.out.print("Is there rainfall? type(yes/no): ");
//            String rainfall = scanner.nextLine().trim().toLowerCase();
//            if (rainfall.equals("yes")) {
//                System.out.print("Is the rainfall low? type(yes/no): ");
//                String rainfallLow = scanner.nextLine().trim().toLowerCase();
//                if (rainfallLow.equals("yes")) {
//                    rainfallIsLow = true;
//                    rainfallCF = getUserInput("To what degree do you believe the rainfall is low? (Enter CF between -1 and 1): ", scanner);
//                }
//            }
//        }
//
//        System.out.print("Is the temperature cold or warm? (cold/warm): ");
//        String temp = scanner.nextLine().trim().toLowerCase();
//        boolean tempIsCold = false;
//        boolean tempIsWarm = false;
//        double tempCF = 0;
//        if (temp.equals("cold")) {
//            tempIsCold = true;
//            tempCF = getUserInput("To what degree do you believe the temperature is cold? (Enter CF between -1 and 1): ", scanner);
//        } else if (temp.equals("warm")) {
//            tempIsWarm = true;
//            tempCF = getUserInput("To what degree do you believe the temperature is warm? (Enter CF between -1 and 1): ", scanner);
//        } else {
//            System.out.println("Invalid input.");
//            return;
//        }
//
//        System.out.print("Is the sky overcast? (yes/no): ");
//        String skyOvercast = scanner.nextLine().trim().toLowerCase();
//        boolean skyIsOvercast = false;
//        double skyCF = 0;
//        if (skyOvercast.equals("yes")) {
//            skyIsOvercast = true;
//            skyCF = getUserInput("To what degree do you believe the sky is overcast? (Enter CF between -1 and 1): ", scanner);
//        }
//
//        double cfRain = 0;
//        double cfDry = 0;
//
//        // Apply rules and update CFs
//        if (todayIsRain) {
//            cfRain = 0.5;
//            if (rainfallIsLow) {
//                cfDry = 0.6 * rainfallCF;
//                if (tempIsCold) {
//                    double combinedCF = 0.7 * Math.min(rainfallCF, tempCF);
//                    cfDry = combineCF(cfDry, combinedCF);
//                }
//            }
//        }
//        if (todayIsDry) {
//            cfDry = 0.5;
//            if (tempIsWarm) {
//                cfRain = 0.65 * tempCF;
//                if (skyIsOvercast) {
//                    double combinedCF = 0.55 * Math.min(tempCF, skyCF);
//                    cfRain = combineCF(cfRain, combinedCF);
//                }
//            }
//        }
//
//        System.out.println("Tomorrow is dry with CF = " + cfDry);
//        System.out.println("Tomorrow is rain with CF = " + cfRain);
//
//    }
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherprediction;

import java.util.Scanner;

public class WeatherPrediction {

    public static double combineCF(double cf1, double cf2) {
        if (cf1 > 0 && cf2 > 0) {
            return cf1 + cf2 * (1 - cf1);
        } else if (cf1 < 0 && cf2 < 0) {
            return cf1 + cf2 * (1 + cf1);
        } else if (cf1 < 0 || cf2 < 0) {
            return (cf1 + cf2) / (1 - Math.min(Math.abs(cf1), Math.abs(cf2)));
        }
        return 0;
    }

    public static double getUserInput(String str, Scanner scanner) {
        while (true) {
            System.out.print(str);
            try {
                double cf = Double.parseDouble(scanner.nextLine().trim());
                if (cf >= -1 && cf <= 1) {
                    return cf;
                } else {
                    System.out.println("Please enter a value between -1 and 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number value between -1 and 1.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************");
        System.out.println("Tala Mahmoud Ismail*");
        System.out.println("********************");
        System.out.println("Id: 202010022");
        System.out.println("********************");
        System.out.println("Enter the conditions for today:");
        System.out.print("Is it raining today? type(yes/no): ");
        String today = scanner.nextLine().trim().toLowerCase();

        boolean todayIsRain;
        boolean todayIsDry;

        if (today.equals("yes")) {
            todayIsRain = true;
            todayIsDry = false;
        } else if (today.equals("no")) {
            todayIsRain = false;
            todayIsDry = true;
        } else {
            System.out.println("Invalid input.");
            return;
        }

        boolean rainfallIsLow = false;
        double rainfallCF = 0;
        if (todayIsRain) {
            System.out.print("Is there rainfall? type(yes/no): ");
            String rainfall = scanner.nextLine().trim().toLowerCase();
            if (rainfall.equals("yes")) {
                System.out.print("Is the rainfall low? type(yes/no): ");
                String rainfallLow = scanner.nextLine().trim().toLowerCase();
                if (rainfallLow.equals("yes")) {
                    rainfallIsLow = true;
                    rainfallCF = getUserInput("To what degree do you believe the rainfall is low? (Enter CF between -1 and 1): ", scanner);
                }
            }
        }

        System.out.print("Is the temperature cold or warm? (cold/warm): ");
        String temp = scanner.nextLine().trim().toLowerCase();
        boolean tempIsCold = false;
        boolean tempIsWarm = false;
        double tempCF = 0;
        if (temp.equals("cold")) {
            tempIsCold = true;
            tempCF = getUserInput("To what degree do you believe the temperature is cold? (Enter CF between -1 and 1): ", scanner);
        } else if (temp.equals("warm")) {
            tempIsWarm = true;
            tempCF = getUserInput("To what degree do you believe the temperature is warm? (Enter CF between -1 and 1): ", scanner);
        } else {
            System.out.println("Invalid input.");
            return;
        }

        System.out.print("Is the sky overcast? type(yes/no): ");
        String skyOvercast = scanner.nextLine().trim().toLowerCase();
        boolean skyIsOvercast = false;
        double skyCF = 0;
        if (skyOvercast.equals("yes")) {
            skyIsOvercast = true;
            skyCF = getUserInput("To what degree do you believe the sky is overcast? (Enter CF between -1 and 1): ", scanner);
        }

        double cfRain = 0;
        double cfDry = 0;

        if (todayIsRain) {
            cfRain = 0.5;
            if (rainfallIsLow) {
                cfDry = 0.6 * rainfallCF;
                if (tempIsCold) {
                    double combinedCF = 0.7 * Math.min(rainfallCF, tempCF);
                    cfDry = combineCF(cfDry, combinedCF);
                }
            }
        }
        if (todayIsDry) {
            cfDry = 0.5;
            if (tempIsWarm) {
                cfRain = 0.65 * tempCF;
                if (skyIsOvercast) {
                    double combinedCF = 0.55 * Math.min(tempCF, skyCF);
                    cfRain = combineCF(cfRain, combinedCF);
                }
            }
        }

        System.out.println("Tomorrow is dry with CF = " + cfDry);
        System.out.println("Tomorrow is rain with CF = " + cfRain);

    }
}
