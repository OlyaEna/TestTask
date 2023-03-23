package com.task.task1;

import java.util.Scanner;

public class IpAddress {

    /**
     * Вариант реализации через long
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        System.out.println(ipToLong(ipAddress));
        long ipAddress2 = scanner.nextLong();
        System.out.println(longToIp(ipAddress2));
    }

    public static long ipToLong(String ipAddress) {

        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            result += (Integer.parseInt(ipAddressInArray[i]) % 256 * Math.pow(256, power));
        }
        return result;
    }

    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);

        for (int i = 0; i < 4; i++) {
            result.insert(0, Long.toString(ip & 0xff));

            if (i < 3) {
                result.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }


}
