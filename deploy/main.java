

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


        Map<String, Object> vAllowed = new HashMap<>();
        vAllowed.put("asdf",1);
        vAllowed.put("asd333f",new String[] { "kylin@163.com", "kylin@263.com" });

        System.out.print( vAllowed);

//        String cpPath = "1.lic.txt";
//
//        try {
//            File File_Path = new File(cpPath);
//
//            FileInputStream File_Input_Stream = new FileInputStream(File_Path);
//
//            // Create a byte array
//            byte[] Demo_Array = new byte[(int) File_Path.length()];
//
//            // Read file content to byte array
//            File_Input_Stream.read(Demo_Array);
//
//            //Close the instance
//            File_Input_Stream.close();
//            System.out.print( (Demo_Array));
//            // Print the above byte array
//            //System.out.print(Arrays.toString(Demo_Array));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}