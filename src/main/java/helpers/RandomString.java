/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/**
 * RandomString Helper.
 *
 * @author raulsm
 * @see <a href="https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string">
 * how-to-generate-a-random-alpha-numeric-string</a>
 */
public class RandomString {

    /**
     * Generate a random string.
     *
     * @return Random String
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    /**
     * Available Letters.
     */
    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Available Letters in lower case.
     */
    public static final String LOWER = UPPER.toLowerCase(Locale.ROOT);

    /**
     * Available Digits.
     */
    public static final String DIGITS = "0123456789";

    /**
     * Available alphanumeric Letters And Digits.
     */
    public static final String ALPHANUM = UPPER + LOWER + DIGITS;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    /**
     * RandomString constructor
     *
     * @param length Length.
     * @param random Random.
     * @param symbols Symbols.
     */
    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public RandomString(int length, Random random, String symbols) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        if (symbols.length() < 2) {
            throw new IllegalArgumentException();
        }
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     *
     * @param length Length
     * @param random Random
     */
    public RandomString(int length, Random random) {
        this(length, random, ALPHANUM);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     *
     * @param length Length
     */
    public RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Create session identifiers.
     */
    public RandomString() {
        this(21);
    }
}
