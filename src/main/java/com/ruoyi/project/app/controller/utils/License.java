package com.ruoyi.project.app.controller.utils;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.project.app.controller.request.BodyLicenses;
import com.ruoyi.project.app.controller.request.LicensesCreate;
import com.ruoyi.project.app.domain.AppCiphertexts;
import com.ruoyi.project.app.domain.AppDevicesStatus;
import com.ruoyi.project.app.domain.AppLicenses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

public class License {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static Map<String, String> createLicense(LicensesCreate bodyLicenses) {

        String uuid = IdUtils.simpleUUID();
        String licPath = "data/lic/" + uuid + ".lic";
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
        String limitEnd = format2.format(bodyLicenses.getLimitEnd());

      //  String[] array = bodyLicenses.getDeviceId().toArray(new String[bodyLicenses.getDeviceId().size()]);
        System.out.println(bodyLicenses.getDeviceId());
        System.out.println(String.join(",",bodyLicenses.getDeviceId()));
        try {
            // 设置命令参数
            List<String> cmds = new ArrayList<>();
            cmds.add("clt_license");
            cmds.add("--deviceId");
            cmds.add( String.join(",",bodyLicenses.getDeviceId()));
            cmds.add("--password");
            cmds.add("123456");
            cmds.add("--date1");
            cmds.add(limitEnd);
            cmds.add("--mode");
            cmds.add("0");
            cmds.add("--output");
            cmds.add(licPath);

            ProcessBuilder processBuilder = new ProcessBuilder().command(cmds);

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


        } catch (Exception e) {
            String msg = "启动任务失败:" + e.getMessage();
            log.error(msg, e);
        }
        Map<String, String> res=new HashMap<>();


        res.put("fileName",licPath);
        res.put("licenseId",uuid);


        return res;

    }

    public static AppLicenses createThreeMonthLicense(List<String> deviceIds) {

        Date dNow = new Date();   //当前时间
        Date dAfterThreeMonth = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, 3);  //设置为后3月
        dAfterThreeMonth = calendar.getTime();   //得到前3月的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd "); //设置时间格式
        String defaultEndDate = sdf.format(dAfterThreeMonth);    //格式化前3月的时间

        System.out.println("到期时间===========" + defaultEndDate);
        System.out.println("设备id" + deviceIds);

        LicensesCreate bodyLicenses = new LicensesCreate();
        bodyLicenses.setDeviceId(deviceIds);

        bodyLicenses.setLimitEnd(dAfterThreeMonth);

        Map<String, String> newLicense=License.createLicense(bodyLicenses);

        AppLicenses licenses = new AppLicenses();
        BeanUtils.copyBeanProp(licenses, bodyLicenses);
        List<AppDevicesStatus> list = new ArrayList<AppDevicesStatus>();
        for (int i = 0; i < deviceIds.size(); i++) {
            AppDevicesStatus appDevicesStatus=new AppDevicesStatus();
            appDevicesStatus.setDeviceId(deviceIds.get(i));
            appDevicesStatus.setUsed("0");
            appDevicesStatus.setEnabled("1");
            list.add(appDevicesStatus);
        }

        licenses.setLicenseId(newLicense.get("licenseId"));
        licenses.setFileName(newLicense.get("fileName"));
        licenses.setAppDevicesStatusList(list);

        return licenses;

    }




}
