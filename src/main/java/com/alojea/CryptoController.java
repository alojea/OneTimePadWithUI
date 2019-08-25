package com.alojea;

import com.alojea.utils.CryptoUtils;

public class CryptoController{

    static final int MODULE = 26;
    
    public String encrypt(String clearText, String keyStream) {
        int[] clearTextConvertedInNumber = convertStringIntoNumber(clearText);
        int[] keyStreamConvertedInNumber = convertStringIntoNumber(keyStream);
        int[] textConverted = addCleartextWithKeystream(clearTextConvertedInNumber,keyStreamConvertedInNumber);
        
        return returnCipherText(textConverted);
    }

    public String decrypt(String cipherText, String keyStream) {
        int[] cipherTextConvertedInNumber = convertStringIntoNumber(cipherText);
        int[] keyStreamConvertedInNumber = convertStringIntoNumber(keyStream);
        int[] textConverted = substractKeystreamWithCiphertext(cipherTextConvertedInNumber,keyStreamConvertedInNumber);

        return returnCipherText(textConverted);
    }

    /**
     * addCleartextWithKeystream
     *
     * Function for add Cleartext with keystream
     * The result of add need to be less than the module 26
     * if the number is > 26 subtract 26
     *
     * @return int[] with result of add cleartext and keystream
     */
    public int[] addCleartextWithKeystream(int[] cleartextConverted, int[] keystreamConverted){
        int minLenght = 0;
        int[] result = null;

        try {
            if(cleartextConverted.length >=  keystreamConverted.length){
                minLenght = keystreamConverted.length;
                result = cleartextConverted.clone();
            } else {
                minLenght = cleartextConverted.length;
                result = keystreamConverted.clone();
            }

            for(int index=0;index<minLenght;index++){
                result[index] = cleartextConverted[index] + keystreamConverted[index];
                if(result[index] > MODULE){
                    result[index] = result[index] - MODULE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * substractKeystreamWithciphertext
     *
     * Substract keystream and Ciphertext
     * if first number is less than second
     * add module 26 to the first number before
     * subtracting
     *
     * @return  int[] with result of subtract cipher and keystream
     *
     */
    public int[] substractKeystreamWithCiphertext(int[] cipherTextConverted, int[] keyStreamConverted){
        int minLenght = 0;
        int[] result = null;

        try {
            if(cipherTextConverted.length >=  keyStreamConverted.length){
                minLenght = keyStreamConverted.length;
                result = cipherTextConverted.clone();
            } else {
                minLenght = cipherTextConverted.length;
                result = keyStreamConverted.clone();
            }

            for(int index=0;index<minLenght;index++){

                if(cipherTextConverted[index] < keyStreamConverted[index]){
                    result[index] = ( cipherTextConverted[index] + MODULE ) - keyStreamConverted[index];
                } else {
                    result[index] = cipherTextConverted[index] - keyStreamConverted[index];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    /**
     *
     * convertNumberToString
     *
     *
     * @param numberToConvert
     * @return
     */
    public String returnCipherText(int[] numberToConvert){
        char[] arrayChar = new char[numberToConvert.length];

        try {
            for(int index = 0 ; index < numberToConvert.length; index++){
                arrayChar[index] = CryptoUtils.returnChar(numberToConvert[index]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(arrayChar);
    }

    /**
     * Convert String into Number
     *
     * @param textToConvert
     * @return String converted in number
     */
    public int[] convertStringIntoNumber(String textToConvert){
        int[] intArray = new int[textToConvert.length()];

        try {
            for(int i=0;i<textToConvert.length();i++){
                intArray[i] = CryptoUtils.returnNumber(textToConvert.charAt(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return intArray;
    }

}
