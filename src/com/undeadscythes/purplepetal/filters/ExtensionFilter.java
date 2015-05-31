package com.undeadscythes.purplepetal.filters;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * A file filter to select extensions.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class ExtensionFilter extends FileFilter {
    final String ext;
    final String display;
    
    /**
     * Set a filter with the given extension and name.
     * @param ext
     * @param display
     */
    public ExtensionFilter(String ext, String display) {
        this.ext = ext;
        this.display = display;
    }
    
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(ext);
    }
    
    @Override
    public String getDescription() {
        return String.format("%s (%s)", display, ext);
    }
}
