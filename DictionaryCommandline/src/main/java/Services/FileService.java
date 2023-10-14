package Services;

import java.io.*;
public class FileService {
    public static void writeFile(File sourceFile, String destinationPath) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    public static String readFile(File sourceFile) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return contentBuilder.toString();
    }

    public static void copyFile(InputStream is, OutputStream os) {
        try {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    public static void saveImageToFile(File sourceFile, String destinationPath) {
        try (InputStream is = new FileInputStream(sourceFile);
             OutputStream os = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            System.out.println("Image saved to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
}
