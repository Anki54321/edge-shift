package com.ns05.ns05.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashCodeGenearate {
    
 /* Driver Code */  
 public static void gethash(String s)  
 {  
     /* Plain text Password. */  
     String password = s;  
       
     /* generates the Salt value. It can be stored in a database. */  
     String saltvalue = PassBasedEnc.getSaltvalue(30);  
       
     /* generates an encrypted password. It can be stored in a database.*/  
     String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue);  
       
     /* Print out plain text password, encrypted password and salt value. */  
     System.out.println("Plain text password = " + password);  
     System.out.println("Secure password = " + encryptedpassword);  
     System.out.println("Salt value = " + saltvalue);  
       
     /* verify the original password and encrypted password */  
     Boolean status = PassBasedEnc.verifyUserPassword(s,encryptedpassword,saltvalue);  
     if(status==true)  
         System.out.println("Password Matched!!");  
     else  
         System.out.println("Password Mismatched");  
 } 
 public static String getHashValue(String s) {
     
       String password = s;  
       
       /* generates the Salt value. It can be stored in a database. */  
       String saltvalue = PassBasedEnc.getSaltvalue(30);  
         
       /* generates an encrypted password. It can be stored in a database.*/  
       String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue); 
       
       return encryptedpassword;
     
 }
} 



class PassBasedEnc   
{  
 /* Declaration of variables */   
 private static final Random random = new SecureRandom();  
 private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  
 private static final int iterations = 10000;  
 private static final int keylength = 256;  
   
 /* Method to generate the salt value. */  
 public static String getSaltvalue(int length)   
 {  
     StringBuilder finalval = new StringBuilder(length);  

     for (int i = 0; i < length; i++)   
     {  
         finalval.append(characters.charAt(random.nextInt(characters.length())));  
     }  

     return new String(finalval);  
 }     

 /* Method to generate the hash value */  
 public static byte[] hash(char[] password, byte[] salt)   
 {  
     PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);  
     Arrays.fill(password, Character.MIN_VALUE);  
     try   
     {  
         SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");  
         return skf.generateSecret(spec).getEncoded();  
     }   
     catch (NoSuchAlgorithmException | InvalidKeySpecException e)   
     {  
         throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);  
     }   
     finally   
     {  
         spec.clearPassword();  
     }  
 }  

 /* Method to encrypt the password using the original password and salt value. */  
 public static String generateSecurePassword(String password, String salt)   
 {  
     String finalval = null;  

     byte[] securePassword = hash(password.toCharArray(), salt.getBytes());  

     finalval = Base64.getEncoder().encodeToString(securePassword);  

     return finalval;  
 }  
   
 /* Method to verify if both password matches or not */  
 public static boolean verifyUserPassword(String providedPassword,  
         String securedPassword, String salt)  
 {  
     boolean finalval = false;  
       
     /* Generate New secure password with the same salt */  
     String newSecurePassword = generateSecurePassword(providedPassword, salt);  
       
     /* Check if two passwords are equal */  
     finalval = newSecurePassword.equalsIgnoreCase(securedPassword);  
       
     return finalval;  
 }  

}
