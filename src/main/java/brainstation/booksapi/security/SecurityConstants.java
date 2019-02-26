package brainstation.booksapi.security;


public class SecurityConstants {
    public static final String SECRET = "MyCheekyLittleSecret";
    public static final long   EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String USERNAME_HEADER = "Username";
    static final String SIGN_UP_URL = "/user/sign-up";
    static final String PRODUCTS_URL = "/product/**";
    static final String REVIEWS_URL = "/review/**";
}
