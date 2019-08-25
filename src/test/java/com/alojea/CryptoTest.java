package com.alojea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CryptoTest{

    CryptoController crypto;

    @Before
    public void setUp() throws Exception {
        crypto = new CryptoController();
    }

    @Test
    public void encryptTest(){
        Assert.assertEquals(crypto.encrypt("DONOTUSEPC","KDWUPONOWT"),"OSKJJJGTMW");
    }

    @Test
    public void decryptTest(){
        Assert.assertEquals(crypto.decrypt("OSKJJJGTMW","KDWUPONOWT"),"DONOTUSEPC");
    }

    @Test
    public void convertStringIntoNumberTest(){
        int [] numberTest = {4,15,14,15,20,21,19,5,16,3};
        Assert.assertArrayEquals(crypto.convertStringIntoNumber("DONOTUSEPC"),numberTest);
    }

    @Test
    public void addCleartextWithKeystreamTest(){
        int[] result = {15,19,11,10,10,10,7,20,13,23};
        int[] cleartextConverted = {4,15,14,15,20,21,19,5,16,3};
        int[] keystreamConverted = {11,4,23,21,16,15,14,15,23,20};
        Assert.assertArrayEquals(crypto.addCleartextWithKeystream(cleartextConverted,keystreamConverted),result);
    }

    @Test
    public void substractKeystreamWithCiphertextTest(){
        int[] result = {4,15,14,15,20,21,19,5,16,3};
        int[] ciphertext = {15,19,11,10,10,10,7,20,13,23};
        int[] keystreamConverted = {11,4,23,21,16,15,14,15,23,20};
        Assert.assertArrayEquals(crypto.substractKeystreamWithCiphertext(ciphertext,keystreamConverted),result);
    }

    @Test
    public void returnCipherTextTest(){
        int[] result = {4,15,14,15,20,21,19,5,16,3};
        Assert.assertEquals(crypto.returnCipherText(result),"DONOTUSEPC");

    }

}