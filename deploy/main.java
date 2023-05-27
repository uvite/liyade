

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Path;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String cpPath = "2d1a777f6da1486585dcfd0575855cb6.cp";

        try {
            File File_Path = new File(cpPath);

            FileInputStream File_Input_Stream = new FileInputStream(File_Path);

            // Create a byte array
            byte[] Demo_Array = new byte[(int) File_Path.length()];

            // Read file content to byte array
            File_Input_Stream.read(Demo_Array);

            //Close the instance
            File_Input_Stream.close();

            // Print the above byte array
            System.out.print(Arrays.toString(Demo_Array));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}