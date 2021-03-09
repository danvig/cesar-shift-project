import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class shift {
	
	public static String encrypt(String plainText, int shift) 
	{
		if (shift > 26) 
		{
			shift = (shift%26);
		}
		else if (shift < 0) 
		{
			shift = (shift%26) + 26;
		}
		
		String cipherText = "";
		int length = plainText.length();
		
		for(int i = 0; i < length; i++)
		{
			char ch = plainText.charAt(i);
			
			if(Character.isLetter(ch)) 
			{
				if(Character.isLowerCase(ch))
				{
					char c = (char)(ch+shift);
					
					if(c>'z')
					{
						cipherText += (char)(ch - (26-shift));
					}
					else
					{
						cipherText += c;
					}
				}
				else if (Character.isUpperCase(ch))
				{
					char c = (char)(ch+shift);
					
					if(c>'Z')
					{
						cipherText += (char)(ch - (26-shift));
					}
					else
					{
						cipherText += c;
					}
				}
			}
			else 
			{
				cipherText += ch;
			}
		}
		
		return cipherText;
	}
	
	public static String decrypt(String plainText, int shift) 
	{
		if (shift > 26) 
		{
			shift = (shift%26);
		}
		else if (shift < 0) 
		{
			shift = (shift%26) + 26;
		}
		
		String cipherText = "";
		int length = plainText.length();
		
		for(int i = 0; i < length; i++)
		{
			char ch = plainText.charAt(i);
			
			if(Character.isLetter(ch)) 
			{
				if(Character.isLowerCase(ch))
				{
					char c = (char)(ch-shift);
					
					if(c<'a')
					{
						cipherText += (char)(ch + (26-shift));
					}
					else
					{
						cipherText += c;
					}
				}
				else if (Character.isUpperCase(ch))
				{
					char c = (char)(ch-shift);
					
					if(c<'A')
					{
						cipherText += (char)(ch + (26-shift));
					}
					else
					{
						cipherText += c;
					}
				}
			}
			else 
			{
				cipherText += ch;
			}
		}
		
		return cipherText;
	}
	
	public static void main(String[] args) 
	{	
		// ENCRYPTION/DECRYPTION
		System.out.println("WELCOME");	// Welcome message
		
		// STEP 1 - GET INPUT
		System.out.println("\nPlease enter a sentence or word to be encoded/decoded.");		// Terminal output
		String input = JOptionPane.showInputDialog(null, "Please enter a sentence or word that you wish to encode or decode. It will be converted to uppercase.");
		String upperCase = input.toUpperCase(); // Convert input to uppercase
		
		System.out.println("Your input: " + upperCase); // Terminal output
		
		// STEP 2 - CHOOSE METHOD (ENCRYPTION OR DECRYPTION)
		System.out.println("\nWould you like to encode or decode this message?");		// Terminal output
		
		String encryptOrDecrypt = JOptionPane.showInputDialog(null, "Please choose whether to encrypt or decrypt this message. \n"
		           + "Encrypt - press 1\nDecrypt - press 2");
		int choice = Integer.parseInt(encryptOrDecrypt);
		
		// Acknowledge Decision
		if (choice == 1)
		{
			System.out.println("\nYou have chosen to encode this message");
			System.out.println("\nENCRYPTION PROCESS HAS STARTED");
		}
		
		if (choice == 2)
		{
			System.out.println("\nYou have chosen to decode this message");
			System.out.println("\nDECRYPTION PROCESS HAS STARTED");
		}
		
		// STEP 3 - PERFORM OPERATION
		
		int[] shifts = {25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		
		for (int i = 0; i < shifts.length; i++)
		{
			if (choice == 1)
			{	
				String cipher = encrypt(upperCase, shifts[i]);
				System.out.println("Encrypted message when shifted by " + shifts[i] + " is: " + cipher);
			}
			else if (choice == 2)
			{
				String decrypted = decrypt(upperCase, shifts[i]);
				System.out.println("Decrypted message when shifted by " + shifts[i] + " is: " + decrypted);
			}
		}
		
		System.out.println("\nProcess complete!");
		
		
	}
}
