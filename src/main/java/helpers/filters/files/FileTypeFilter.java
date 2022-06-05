/**
 * File Type Filter.
 *
 * @author raulsm
 */
package helpers.filters.files;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * File Type Filter.
 *
 * @author raulsm
 */
public final class FileTypeFilter extends FileFilter {

    private String extensionFile;
    private String descriptionFile;

    /**
     * File Type Filter Constructor.
     * @param extension Extension.
     * @param description Description.
     */
    public FileTypeFilter(String extension, String description) {
        setExtensionFile(extension);
        setDescriptionFile(description);
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().endsWith(getExtensionFile());
    }

    @Override
    public String getDescription() {
        return getDescriptionFile() + String.format(" (*%s)", getExtensionFile());
    }

    /**
     * Get Extension File.
     *
     * @return Extension File.
     */
    public String getExtensionFile() {
        return extensionFile;
    }

    /**
     * Set Extension File.
     *
     * @param extensionFile Extension File.
     */
    public void setExtensionFile(String extensionFile) {
        this.extensionFile = extensionFile;
    }

    /**
     * Get Description File.
     *
     * @return Description File.
     */
    public String getDescriptionFile() {
        return descriptionFile;
    }

    /**
     * Set Description File.
     *
     * @param descriptionFile Description File.
     */
    public void setDescriptionFile(String descriptionFile) {
        this.descriptionFile = descriptionFile;
    }
}
