package com.lifengming.tybs.pojo.utils;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * create by Lfm
 * on 2018-05-11 20:28
 */
public class BankCardAutoUtil {
    public static final String[] MASTERCARD_PREFIX_LIST = new String[]{"51",
            "52", "53", "54", "55"};

    static String strrev(String str) {
        if (str == null)
            return "";
        String revstr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revstr += str.charAt(i);
        }

        return revstr;
    }

    static String completed_number(String prefix, int length) {

        String ccnumber = prefix;


        while (ccnumber.length() < (length - 1)) {
            ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
        }
        String reversedCCnumberString = strrev(ccnumber);

        List reversedCCnumberList = new Vector();
        for (int i = 0; i < reversedCCnumberString.length(); i++) {
            reversedCCnumberList.add(new Integer(String
                    .valueOf(reversedCCnumberString.charAt(i))));
        }

        int sum = 0;
        int pos = 0;

        Integer[] reversedCCnumber = (Integer[]) reversedCCnumberList
                .toArray(new Integer[reversedCCnumberList.size()]);
        while (pos < length - 1) {

            int odd = reversedCCnumber[pos] * 2;
            if (odd > 9) {
                odd -= 9;
            }

            sum += odd;

            if (pos != (length - 2)) {
                sum += reversedCCnumber[pos + 1];
            }
            pos += 2;
        }

        int checkdigit = new Double(
                ((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
        ccnumber += checkdigit;

        return ccnumber;

    }

    public static String[] credit_card_number(String[] prefixList, int length,
                                              int howMany) {

        Stack result = new Stack();
        for (int i = 0; i < howMany; i++) {
            int randomArrayIndex = (int) Math.floor(Math.random()
                    * prefixList.length);
            String ccnumber = prefixList[randomArrayIndex];
            result.push(completed_number(ccnumber, length));
        }

        return (String[]) result.toArray(new String[result.size()]);
    }

    public static String[] generateMasterCardNumbers(int howMany) {
        return credit_card_number(MASTERCARD_PREFIX_LIST, 19, howMany);
    }

    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        boolean isValid = false;

        try {
            String reversedNumber = new StringBuffer(creditCardNumber)
                    .reverse().toString();
            int mod10Count = 0;
            for (int i = 0; i < reversedNumber.length(); i++) {
                int augend = Integer.parseInt(String.valueOf(reversedNumber
                        .charAt(i)));
                if (((i + 1) % 2) == 0) {
                    String productString = String.valueOf(augend * 2);
                    augend = 0;
                    for (int j = 0; j < productString.length(); j++) {
                        augend += Integer.parseInt(String.valueOf(productString
                                .charAt(j)));
                    }
                }
                mod10Count += augend;
            }
            if ((mod10Count % 10) == 0) {
                isValid = true;
            }
        } catch (NumberFormatException e) {
        }
        return isValid;
    }

    public static String get_Bank_account() {
        String[] creditcardnumbers = generateMasterCardNumbers(1);
        String bandcard_NO = creditcardnumbers[0];
        return bandcard_NO;
    }
}
