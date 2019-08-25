# OneTimePad

Exercise 4: Cryptography with a One-time Pad
The task in this exercise is to implement a class Crypto which contains methods for encrypting and decrypting a message using a one-time pad. A one-time pad is an encryption technique where the plaintext message is combined with a random key or "pad" that is as long as the plaintext and used only once. Modular addition is used to combine the plaintext with the pad. If the key is truly random, never reused, and kept secret, the one-time pad provides perfect secrecy. The pad is sometimes called a "keystream".

Here is a brief description of the technique by Bruce Schneier, taken from the Appendix of Neal Stephenson's novel Cryptonomicon.

Assume your cleartext is the string:

DONOTUSEPC
(i.e. "do not use PC"). Note that this technique only represents the 26 letter of the alphabet, and doesn't do anything with punctuation or spaces. Assume your keystream string is:

KDWUPONOWT
Encryption
Step 1. Convert the cleartext message from letters to numbers: A = 1, B = 2, etc:

4 15 14 15 20 21 19 5 16 3
Step 2. Convert the keystream letters similarly:

11 4 23 21 16 15 14 15 23 20
Step 3. Add the cleartext number stream to the keystream numbers, modulo 26. (I.e., if the sum is more than 26, substract 26 from the result.) For example, 1 + 1 = 2, 26 + 1 = 27, and 27 - 26 = 1, so 26 + 1 = 1:

15 19 11 10 10 10 7 20 13 23
Step 4. Convert the numbers back to letters:

OSKJJJGTMW
This string of letters is the ciphertext.

Decryption
Assume you have a ciphertext message like the string above. To decrypt, you have to use the same keystream that way used for encryption.

Step 1. Convert the ciphertext message into numbers:

15 19 11 10 10 10 7 20 13 23
Step 2. Convert the keystream letters similarly:

11 4 23 21 16 15 14 15 23 20
Step 3. Subtract the keystream numbers from the ciphertext numbers, modulo 26. For example, 22 - 1 = 20, 1 - 22 = 5 (If the first number is less than the second number, add 26 to the first number before subtracting. So 1 - 22 = ? becomes 27 - 22 = 5.):

4 15 14 15 20 21 19 5 16 3
Step 3. Convert the numbers back to letters:

DONOTUSEPC
For an alternative source of information, you can look at these Wikipedia articles:

http://en.wikipedia.org/wiki/One-time_pad </br>
http://en.wikipedia.org/wiki/Keystream </br>
In the Crypto class, you should implement methods corresponding to the following declarations:

public String encrypt(String clearText, String keyStream) {
...
}

public String decrypt(String cipherText, String keyStream) {
...
}
These should satisfy the following pair of equations:

cipherText = encrypt(clearText, keyStream)
clearText = decrypt(cipherText, keyStream)
Here is a ciphertext:

CUFNFLRQMLWBLARVJDALMURNGSHILXXMVDUMFPYG
which I encrypted using this keystream:

ACWZYRJYHGVNHUCARNVXJPUIFACBWOJFBOTIEBVBBZHANSLYOP

Reference: http://www.inf.ed.ac.uk/teaching/courses/inf1/op/Labs/2008/doc/lab5_with_solutions.html </br>

Cloud Foundry endpoint: http://crypto.cfapps.io


