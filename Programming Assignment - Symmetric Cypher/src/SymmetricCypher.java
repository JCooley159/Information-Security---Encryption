import java.security.*;


public class SymmetricCypher
{
	// Provided Methods
	public static char keyGenOneByte()
	{
		SecureRandom rand = new SecureRandom();
		return (char) rand.nextInt(256);
	}

	public static char otpEncOneByte(char plain, char key)
	{
		char cipher = (char) (plain ^ key);
		return cipher;
	}

	public static char otpDecOneByte(char cipher, char key)
	{
		char plain = (char) (cipher ^ key);
		return plain;
	}



	// My Methods for the Assignment
	public static String keyGen(int keyLen)
	{
		String key = "";
		for (int i=0; i<keyLen; i++)
		{
			key = key + keyGenOneByte();
		}
		return key;
	}

	public static String otpEnc(String plain, String key)
	{
		String cipher = "";
		for (int i=0; i<plain.length(); i++)
		{
			cipher = cipher + otpEncOneByte(plain.charAt(i), key.charAt(i));
		}

		return cipher;
	}

	public static String otpDec(String cipher, String key)
	{
		String plain = "";
		for (int i=0; i<cipher.length(); i++)
		{
			plain = plain + otpDecOneByte(cipher.charAt(i), key.charAt(i));
		}

		return plain;
	}

	public static String shiftEnc(String plain, String key)
	{
		String cipher = "";
		for (int i=0; i<plain.length(); i++)
		{
			int sum = (plain.charAt(i) + key.charAt(i)) % 256;


			cipher = cipher + ((char) sum);
		}

		return cipher;
	}

	public static String shiftDec(String cipher, String key)
	{
		String plain = "";
		for (int i=0; i<cipher.length(); i++)
		{
			int diff = (cipher.charAt(i) - key.charAt(i)) % 256;


			plain = plain + ((char) diff);
		}

		return plain;
	}

}
