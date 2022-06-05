/**
 * Combo Box Helper.
 *
 * @author raulsm
 */
package helpers;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Combo Box Helper
 *
 * @author raulsm
 */
public class ComboBox {

    /**
     * Fill Combo Box.
     *
     * @param <T> T
     * @param entities List of entities
     * @param comboBox JComboBox
     */
    public static <T> void fill(List<T> entities, JComboBox comboBox) {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
        defaultComboBoxModel.removeAllElements();

        for (T entity : entities) {
            defaultComboBoxModel.addElement(entity);
        }
    }

    /**
     * Clear Combo Box.
     *
     * @param comboBox JComboBox
     */
    public static void clear(JComboBox comboBox) {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) comboBox.getModel();
        defaultComboBoxModel.removeAllElements();
    }
}
