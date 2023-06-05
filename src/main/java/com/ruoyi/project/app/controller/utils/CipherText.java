package com.ruoyi.project.app.controller.utils;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.project.app.controller.request.BodyCiphertexts;
import com.ruoyi.project.app.controller.request.BodyLicenses;
import com.ruoyi.project.app.domain.AppCiphertexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class CipherText {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);


    //生成密文
    public static BodyCiphertexts createCiphertext(BodyCiphertexts appCiphertexts) {

        String uuid = IdUtils.simpleUUID();
        String jsonPath = "data/temp/temp.json";
        String cpPath = "data/cp/" + uuid + ".cp";

        JSONObject json = new JSONObject();
        try {
            json.put("deviceId", appCiphertexts.getDeviceId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jsonPath))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            cmds.add(appCiphertexts.getDeviceId());
            ProcessBuilder processBuilder = new ProcessBuilder().command(cmds);

            // 是否合并标准错误和标准输出
            processBuilder.redirectErrorStream(true);
            log.info("完整命令：{}", String.join(StringUtils.SPACE, processBuilder.command()));
            // 执行
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
            MessageDigest md = MessageDigest.getInstance("MD5");
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(cpPath))) {
                byte[] buffer = new byte[1024];
                int read = 0;
                while ((read = bis.read(buffer)) != -1) {
                    md.update(buffer, 0, read);
                }
            }
            byte[] digest = md.digest();
            String md5 = String.format("%032x", new BigInteger(1, digest));

            appCiphertexts.setMd5(md5);

            appCiphertexts.setCiphertextPath(cpPath);

        } catch (Exception e) {
            String msg = "启动任务失败:" + e.getMessage();
            log.error(msg, e);
        }

        return appCiphertexts;

    }

    //生成密文
    public static int[] getCiphertext(String filePath) {
        int[] intArray = new int[0];
        try {

            System.out.println("====="+filePath);
            File File_Path = new File(filePath);

            FileInputStream File_Input_Stream = new FileInputStream(File_Path);

            // Create a byte array
            byte[] Demo_Array = new byte[(int) File_Path.length()];

            // Read file content to byte array
            File_Input_Stream.read(Demo_Array);

            //Close the instance
            File_Input_Stream.close();

            intArray = IntStream.range(0, Demo_Array.length)
                    .map(i -> Demo_Array[i] & 0xff)
                    .toArray();

            System.out.println("=====");
            System.out.println(intArray);
            // appCiphertexts.setCiphertext(Arrays.toString(Demo_Array));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return intArray;

    }

}
