/**
 * Role Helper.
 *
 * @author raulsm
 */
package helpers;

/**
 * Role Helper.
 *
 * @author raulsm
 */
public class Role {

    /**
     * Role Administrator.
     */
    public static final int ADMININISTRATOR = 1;
    
    /**
     * Role Fiscal.
     */
    public static final int FISCAL = 2;
    
    /**
     * Role Fiscal General.
     */
    public static final int FISCAL_GENERAL = 3;
    
    /**
     * Role Cuentadante.
     */
    public static final int CUENTADANTE = 4;

    /**
     * Role Constructor.
     */
    private Role() {
        throw new IllegalStateException("Utility class");
    }
}
