package salesiana.apr222;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import salesiana.apr222.Files.FileScanner;

public class FileScannerTest {

    private FileScanner fileScanner;

    @BeforeEach
    public void setUp() {
        fileScanner = new FileScanner("");
    }

    @TempDir
    static File tempDir;

    @Test
    public void testScanFiles() throws IOException {
        // Create temporary test files with specific extensions
        File tempFile1 = new File(tempDir, "test1.txt");
        File tempFile2 = new File(tempDir, "test2.csv");
        File tempFile3 = new File(tempDir, "other.txt");

        assertTrue(tempFile1.createNewFile());
        assertTrue(tempFile2.createNewFile());
        assertTrue(tempFile3.createNewFile());

        // Use FileScanner to scan for ".txt" files
        fileScanner = new FileScanner(tempDir.getAbsolutePath());
        File[] txtFiles = fileScanner.scanFiles(".txt");

        assertEquals(2, txtFiles.length);

        for (File file : txtFiles) {
            assertTrue(file.getName().endsWith(".txt"));
        }
    }
}
