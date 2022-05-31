/**
 * File Type Filter PDF.
 *
 * @author raulsm
 */
package helpers.filters.files;

import javax.swing.filechooser.FileFilter;

/**
 * File Type Filter PDF.
 *
 * @author raulsm
 */
public final class FileTypeFilterPDF {

    /**
     * Extension File.
     */
    private static final String EXTENSION = ".pdf";
    
    /**
     * Description File.
     */
    private static final String DESCRIPTION = "PDF Documents";
    
    /**
     * Get File Filter
     * @return PDF File Filter
     */
    public static final FileFilter getFilter() {
       return new FileTypeFilter(EXTENSION, DESCRIPTION);
    }
    
    private FileTypeFilterPDF() {
        throw new IllegalStateException("Utility class");
    }
}

