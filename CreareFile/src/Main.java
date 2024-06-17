import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> paths = new ArrayList<>();
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\src");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\res");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\savegames");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\temp");

        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\src\\main");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\src\\test");

        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\src\\main\\Main.java");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\src\\main\\Utils.java");

        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\res\\drawables");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\res\\vectors");
        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\res\\icons");

        paths.add("C:\\Users\\Юлия\\Desktop\\Games\\temp\\temp.txt");

        for (String pat : paths) {
            try {
                if (pat.contains("."))

                    Files.creationFile(pat);
                else {
                    Files.creationFolders(pat);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


        try (FileWriter writer = new FileWriter("C:\\Users\\Юлия\\Desktop\\Games\\temp\\temp.txt", true)) {
            writer.write(String.valueOf(Files.end));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());


        }
    }
}

