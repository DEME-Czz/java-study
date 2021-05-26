package com.javastudy.javabasics.common.uitl;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * CSV 工具类
 *
 * @author jing
 */
@Slf4j
@Component
public class CSVUtils<T>{

    /**
     * 将前台传递的数据生成csv文件
     * @param exportResults
     * @param fileName
     * @param header
     * @throws IOException
     * @throws CsvDataTypeMismatchException
     * @throws CsvRequiredFieldEmptyException
     */
    public static<T> void generateCsvFile(List<T> exportResults, String fileName, String[] header) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter(fileName);
        // 写表头
        CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        csvWriter.writeNext(header);
        //写内容
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
        beanToCsv.write(exportResults);
        csvWriter.close();
        writer.close();
    }

    /**
     * 读取csv文件流返回前端下载
     * @param fileName
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void readCsvFileStream(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        String myFileName = new String(fileName.getBytes("utf-8"), "gbk");
        File file = new File(myFileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + myFileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(file.delete()){
            log.error(file.getName() + " 文件已被删除！");
        }else{
            log.error("文件删除失败！");
        }
    }

}