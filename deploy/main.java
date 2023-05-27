

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


public class Main {


    public static void main(String[] args) {


        String uuid = "12323";
        String jsonPath = "data/temp/temp.json";
        String cpPath =  "data/cp/"+uuid + ".cp";
        try {
            // 设置命令参数
            List<String> cmds = new ArrayList<>();
            cmds.add("clt_cipherText");
            cmds.add("--input");
            cmds.add(jsonPath);
            cmds.add("--output");
            cmds.add(cpPath);
            cmds.add("--mode");
            cmds.add("0");
            cmds.add("--deviceId");
            cmds.add("123");
            //cmds.add(appCiphertexts.getDeviceId());
            ProcessBuilder processBuilder = new ProcessBuilder().command(cmds);
            // 设置工作目录这样他就会去D:\javaTool目录下找jar
            //   processBuilder.directory(new File("D:\\javaTool"));
            // 是否合并标准错误和标准输出
            processBuilder.redirectErrorStream(true);
            System.out.println( String.join(" ", processBuilder.command()));
            // 执行com.ruoyi.project.app.service.IAppCiphertextsService
            Process process = processBuilder.start();
            // 输出结果信息
            BufferedReader br1;
            br1 = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line1 = null;
            while ((line1 = br1.readLine()) != null) {
                System.out.println(line1);
            }
            // 关闭Process
            if (process.isAlive()) {
                process.destroy();
            }

        } catch (Exception e) {
            String msg = "启动任务失败:" + e.getMessage();
            System.out.println(msg);
        }

    }
}