package com.dugu.ddd.infra.mw.tools.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.font.FontProvider;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @author cihun
 * @date 2024/5/14 09:36
 */
public class HtmlToPdf {

    /**
     * @param templatePath 模板全路径
     * @param path         生成pdf文件夹
     * @param fileName     生成pdf文件名
     * @param context      填充参数
     */
    public static void htmlToPdf(String templatePath, String path, String fileName, Context context) {
        String linuxPath = HtmlToPdf.getFileAbsolutePath(templatePath, "/Users/cihun/duguddd/temp1.html", true);
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider dfp = new DefaultFontProvider();
//      dfp.addSystemFonts(); //添加中文字体库 方式a   -window环境有自带字体 linux环境需要安装中文字体，可参考 https://www.zhihu.com/question/423159370/answer/2706867741
        //添加中文字体库 方式b 使用项目导入的字体库 （已验证linux环境不安装中文字体，能正常显示中文）
        dfp.addFont(getFileAbsolutePath("/templates/font/simhei.ttf", "/Users/cihun/duguddd/simhei.ttf", false));
        converterProperties.setFontProvider(dfp);

        //将本地的模板转换成字符串
        String htmlStr = toHtmlString(new File(linuxPath));
        //模板参数替换
        String replaceHtmlStr = new TemplateEngine().process(htmlStr, context);
        File destDir = new File(path);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        try (OutputStream out = new FileOutputStream(new File(path + fileName))) {
            HtmlConverter.convertToPdf(replaceHtmlStr, out, converterProperties);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("pdf转换异常3{}" + e);
        }
    }

    public static void htmlToPdfWatchMask(String templatePath, String path, String fileName, Context context) {
        String linuxPath = HtmlToPdf.getFileAbsolutePath(templatePath, "/Users/cihun/duguddd/temp1.html", true);
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider dfp = new DefaultFontProvider();
//      dfp.addSystemFonts(); //添加中文字体库 方式a   -window环境有自带字体 linux环境需要安装中文字体，可参考 https://www.zhihu.com/question/423159370/answer/2706867741
        //添加中文字体库 方式b 使用项目导入的字体库 （已验证linux环境不安装中文字体，能正常显示中文）
        dfp.addFont(getFileAbsolutePath("/templates/font/simhei.ttf", "/Users/cihun/duguddd/simhei.ttf", false));
        converterProperties.setFontProvider(dfp);


        //将本地的模板转换成字符串
        String htmlStr = toHtmlString(new File(linuxPath));
        //模板参数替换
        String replaceHtmlStr = new TemplateEngine().process(htmlStr, context);
        File destDir = new File(path);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        try (OutputStream out = new FileOutputStream(new File(path + fileName))) {
            PdfWriter pdfWriter = new PdfWriter(out);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new WaterMarkEventHandler("刺魂(124454)"));
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new PageEventHandler());
            HtmlConverter.convertToPdf(replaceHtmlStr, pdfDocument, converterProperties);
            // flush触发写操作，此时才会触发已经注册的事件处理器
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("pdf转换异常3{}" + e);
        }
    }

    /**
     * 读取本地html文件里的html代码
     *
     * @param file File file=new File("文件的绝对路径")x
     * @return
     */
    public static String toHtmlString(File file) {
        // 获取HTML文件流
        StringBuffer htmlSb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "utf-8"));
            while (br.ready()) {
                htmlSb.append(br.readLine());
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // HTML文件字符串
        String htmlStr = htmlSb.toString();
        // 返回经过清洁的html文本
        return htmlStr;
    }

    /**
     * 解决linux下运行jar，无法加载jar包下文件（window环境能正常加载）
     *
     * @param templatePath 模板路径 传相对路径 比如 /templates/template.htm
     * @param createPath   生成路径  比如  /mnt/pdf/templates/template.html
     * @param isCovered    是否覆盖模板，默认false.  如模板变化，需覆盖生成
     * @return 返回的路径就是放在linux服务器上的文件路径
     */
    public static String getFileAbsolutePath(String templatePath, String createPath, boolean isCovered) {
        try {
            // 创建临时文件，获取jar里面的配置文件
            File file = new File(createPath);
            if (file.exists() && !isCovered) {
                return file.getAbsolutePath();
            }
            InputStream inputStream = null;
            try {
                ClassPathResource resource = new ClassPathResource(templatePath);
                inputStream = resource.getInputStream();
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                OutputStream outStream = new FileOutputStream(file);
                outStream.write(buffer);
                return file.getAbsolutePath();
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        } catch (Exception e) {
            System.out.println("FileUtil getFilePath Fail cause by:" + e);
        }
        return null;
    }
}
