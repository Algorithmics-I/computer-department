package salesiana.apr222;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import salesiana.apr222.Files.FileHashGenerator;

public class FileHashGeneratorTest {

    private FileHashGenerator fileHashGenerator;

    @BeforeEach
    public void setUp() {
        fileHashGenerator = new FileHashGenerator();
    }

    @TempDir
    static File tempDir;

    @Test
    public void testGenerateFileHash() throws IOException, NoSuchAlgorithmException {
        // Create a temporary test file
        File tempFile = new File(tempDir, "testFile.txt");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write("Hello, world!".getBytes());
        }

        Path tempPath = tempFile.toPath();

        String hash = fileHashGenerator.generateFileHash(tempPath);
        assertEquals("6cd3556deb0da54bca060b4c39479839", hash);
    }
}
