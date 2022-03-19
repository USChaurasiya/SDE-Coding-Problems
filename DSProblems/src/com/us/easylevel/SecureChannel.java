package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ---------------------------------------------------------------------------------------
 * Carer cup Persons A and B uses an encryption based system for their conversation.
 * Each conversation message is encoded from the source and decoded in
 * the destination using a shared private positive number key known to each other.
 * The algorithm is illustrated with an example.
 *
 *
 * Input Format with explanation:
 *	
 * Operation (1 for Encoding and 2 for Decoding)
 * Input message
 * Input private key
 *
 * Example:
 *	Input 1 Message: Open Key: 123
 *	Output: Oppeeen
 *	
 *	Input: 2 Message : Oppeeen  Key: 123
 *	Output: Open
 * ----------------------------------------------------------------------------------------
 */
public class SecureChannel {
	
	static final String failureResponse = "-1";
	
	public static String secureChannel(int operation, String message, String key) {
		
		
		return "";
	}

	private static String isEmpty(String message, String key) {
		if (message == null || key == null)
			return failureResponse;

		if (message.isEmpty() && key.isEmpty())
			return message;

		if (!message.isEmpty() && key.isEmpty())
			return message;

		if (message.isEmpty() && !key.isEmpty())
			return failureResponse;

		return null;

	}
}
