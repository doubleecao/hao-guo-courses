import java.io.*;
import java.util.*;

public class Transcoder {

    public static void main(String[] args) {
        if (args.length != 3) {
            return;
        }
        String input = args[0];
        String output = args[1];
        String quality = args[2];
        ArrayList<String> argsArr = new ArrayList<>();
        argsArr.add("ffmpeg");
        if (quality.equals(" ")) {

        } else if (quality.equals("  ")) {

        } else if (quality.equals("gif")) {
            argsArr.add("-ss");
            argsArr.add("1");
            argsArr.add("-t");
            argsArr.add("3");
            argsArr.add("-i");
            argsArr.add(input);
            argsArr.add("-vf");
            argsArr.add("fps=10,scale=320:-1:flags=lanczos,split[s0][s1];[s0]palettegen[p];[s1][p]paletteuse");
            argsArr.add("-loop");
            argsArr.add("0");
            argsArr.add(output);

        } else {
            return;
        }
        try {
            String[] arg = argsArr.toArray(new String[0]);

            Process process = Runtime.getRuntime().exec(arg);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}