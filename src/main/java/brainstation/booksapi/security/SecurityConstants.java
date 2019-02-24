package brainstation.booksapi.security;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
    public static final String SECRET = "MyCheekyLittleSecret";
    public static final long   EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String USERNAME_HEADER = "Username";
    public static final String SIGN_UP_URL = "/user/sign-up";
}
