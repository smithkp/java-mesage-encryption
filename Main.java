package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String algorithm = "shift";
        String mode = "enc";
        int key = 0;
        String data = "";
        char[] buff = data.toCharArray();
        String inputPath = "";
        String outputPath = "";

        //Assigns values to arguments
        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                buff = args[i + 1].toCharArray();
            }
            if (args[i].equals("-in")) {
                inputPath = args[i+1];
            }
            if (args[i].equals("-out")) {
                outputPath = args[i+1];
            }
            if (args[i].equals("-alg")) {
                algorithm = args[i+1];
            }

        }

        try {
            Context context = new Context();
            context.setStrategy(new Shift());
            context.setKey(key);
            context.setMessage(buff);

            if(algorithm.equals("unicode")) {
                context.setStrategy(new Unicode());
            }
            if(data.equals("") && !inputPath.equals("")) {
                data = new String(Files.readAllBytes(Paths.get(inputPath)));    //sets data equal to file @ inputPath
                buff = data.toCharArray();
                context.setMessage(buff);
            }
            if (mode.equals("enc")) {
                buff = context.encrypt();
            }
            else {
                buff = context.decrypt();
            }

            if(outputPath.equals("")) {
                System.out.println(String.valueOf(buff));
            }
            else {
                File file = new File(outputPath);
                FileWriter writer = new FileWriter(file, false);
                for (int i=0; i<buff.length; i++) {
                    writer.write(buff[i]);
                }
                writer.close();
            }


        } catch (IOException e) {

        }


    }
}
