package salesiana.apr222.Files;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class DuplicateFileFinder {
    public void processData() {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String termination = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(path);
        File[] files = fileScanner.scanFiles(termination);

        FileHashGenerator hashGenerator = new FileHashGenerator();
        Map<String, List<String>> fileMap = new HashMap<>();
        Set<String> uniqueFiles = new HashSet<>();
        Set<String> duplicatedFiles = new HashSet<>();

        for (File file : files) {
            try {
                String hash = hashGenerator.generateFileHash(file.toPath());
                if (fileMap.containsKey(hash)) {
                    duplicatedFiles.add(fileMap.get(hash).get(0));
                    duplicatedFiles.add(file.getAbsolutePath());
                } else {
                    fileMap.computeIfAbsent(hash, k -> new ArrayList<>()).add(file.getAbsolutePath());
                    uniqueFiles.add(file.getAbsolutePath());
                }
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        printResults(files.length, uniqueFiles.size(), duplicatedFiles.size(), duplicatedFiles);

        scanner.close();
    }

    private static void printResults(int scannedFiles, int uniqueFiles, int duplicatedFiles, Set<String> duplicatedFilePaths) {
        System.out.println("Files scanned: " + scannedFiles);
        System.out.println("Unique files: " + uniqueFiles);
        System.out.println("Potentially duplicated files: " + duplicatedFiles);

        System.out.println("List of duplicated files:");
        for (String filePath : duplicatedFilePaths) {
            System.out.println(filePath);
        }
    }
}
