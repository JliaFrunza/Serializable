import java.io.File;
import java.io.IOException;

public class Files {
    static StringBuilder end = new StringBuilder();

    public static void creationFolders(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            System.out.println("Файл существует");
        } else {
            dir.mkdir();
            end.append("Директория " + path + " успешно создана. \n");
        }
    }


    public static void creationFile(String path) throws Exception {
        File dir1 = new File(path);

        if (dir1.exists()) {
            System.out.println("Файл существует");
        } else {
            dir1.createNewFile();
            end.append("Файл " + path + " успешно создан. \n");
        }
    }
}
