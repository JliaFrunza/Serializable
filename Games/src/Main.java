import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress copy1 = new GameProgress(78, 3, 5, 63.5);
        GameProgress copy2 = new GameProgress(70, 2, 4, 69.5);
        GameProgress copy3 = new GameProgress(69, 1, 6, 67.5);
        saveGame("C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save1.dat", copy1);
        saveGame("C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save2.dat", copy2);
        saveGame("C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save3.dat", copy3);

        zipFiles("C:\\Users\\Юлия\\Desktop\\Games\\savegames\\zip.zip",
                new String[]{"C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save1.dat",
                        "C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save2.dat",
                        "C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save3.dat"});

        deleteNonZippedFiles(new String[]{"C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save1.dat",
                "C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save2.dat",
                "C:\\Users\\Юлия\\Desktop\\Games\\savegames\\save3.dat"});
    }

    public static void saveGame(String path, GameProgress copy) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream cos = new ObjectOutputStream(fos)) {
            cos.writeObject(copy);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String zipFilePath, String[] filesToZip) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (String fileToZip : filesToZip) {
                try (FileInputStream fileInputStream = new FileInputStream(fileToZip)) {
                    ZipEntry entry = new ZipEntry(new File(fileToZip).getName());
                    zipOutputStream.putNextEntry(entry);

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fileInputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }

                    zipOutputStream.closeEntry();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNonZippedFiles(String[] filesToDelete) {
        for (String fileToDelete : filesToDelete) {
            File file = new File(fileToDelete);
            if (!file.getPath().endsWith(".zip")) { // do not delete the zip file
                if (file.delete()) {
                    System.out.println("File " + fileToDelete + " deleted successfully.");
                } else {
                    System.out.println("Failed to delete " + fileToDelete);
                }
            }
        }
    }
}






