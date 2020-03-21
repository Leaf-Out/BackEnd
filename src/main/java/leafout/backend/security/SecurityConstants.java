/*
 * PayU Latam - Copyright (c) 2013 - 2015
 * http://www.payulatam.com
 * Date: 3/03/2015
 */

package leafout.backend.security;

public final class SecurityConstants {

	public static final String AUTH_LOGIN_URL = "/login";

	// Signing key for HS512 algorithm
	// You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
	public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

	// JWT token defaults
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String TOKEN_TYPE = "JWT";

	private SecurityConstants() {
		throw new IllegalStateException("Cannot create instance of static util class");
	}
}