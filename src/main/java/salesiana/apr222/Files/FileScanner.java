package salesiana.apr222.Files;

import java.io.File;
import java.io.FilenameFilter;

public class FileScanner {
    private final File folder;

    public FileScanner(String folderPath) {
        folder = new File(folderPath);
    }

    public File[] scanFiles(String termination) {
        if (folder.isDirectory()) {
            return folder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(termination);
                }
            });
        }
        return new File[0];
    }
}
