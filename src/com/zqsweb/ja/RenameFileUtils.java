package com.zqsweb.ja;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;

/**
 * @Author zhangqisheng
 * @Date 2020-05-27 17:36
 */
public class RenameFileUtils {

    public static void main(String[] args) {
        String configPath;
        configPath = "D:"+File.separator+"Destory"+File.separator+"rename_config.txt";
        listRenameFileConfig(configPath);
    }

    private static void listRenameFileConfig(String configPath) {
        Properties prop = new Properties();
        File file = new File(configPath);
        try {
            Reader reader = new FileReader(file);
            prop.load(reader);
            String inputFile=prop.getProperty("inputFile");
            String prefix = prop.getProperty("prefix");
            listRenameFile(inputFile, prefix);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件流读取出错:" + e.getMessage());
        }
    }

    /**
     * 批量随机重命名文件
     * @param inputFile 输入文件的文件夹地址
     * @param prefix 重命名前缀
     *               D:\Destory\rename_config.txt
     */
    private static void listRenameFile(String inputFile, String prefix) {
        File iFile = new File(inputFile);
        if (!iFile.exists()) {
            System.out.println("输入文件夹不存在:" + inputFile);
            return;
        }

        if (!iFile.isDirectory()) {
            System.out.println("输入文件不是目录:" + inputFile);
            return;
        }

        Arrays.asList(iFile.list()).stream()
                .map(filepath->{
                    return new File(inputFile + File.separator + filepath);
                })
                .forEach(file->{
                    String name="ic_"+prefix+"_"+ UUID.randomUUID().toString().substring(0,4)+file.getName().substring(file.getName().lastIndexOf("."));
                    if (FileUtils.renameFile(file, name)) {
                        System.out.println(file.getAbsolutePath() + "重命名成功:" + name);
                    } else {
                        System.err.println(file.getAbsolutePath() + "重命名失败:" + name);
                    }
                });




    }


}
