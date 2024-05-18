package com.dugu.ddd.infra.mw.tools.pdf;

import org.junit.Test;
import org.thymeleaf.context.Context;

/**
 *  
 *  @date 2024/5/14 10:13
 *  @author cihun
 */
public class HtmlToPdfTest {


    @Test
    public  void pdf() throws Exception {
        //模板内容填充参数
        Context context = new Context();
        context.setVariable("name2", "晨曦话java");
        context.setVariable("name1", "晨曦话三国");
        HtmlToPdf.htmlToPdf("/templates/pdf/pdf.html", "/Users/cihun/duguddd/", "temp.pdf", context);
    }

    @Test
    public  void htmlToPdfWatchMask() throws Exception {
        //模板内容填充参数
        Context context = new Context();
        context.setVariable("name2", "晨曦话java");
        context.setVariable("name1", "晨曦话三国");
        HtmlToPdf.htmlToPdfWatchMask("/templates/pdf/pdf.html", "/Users/cihun/duguddd/", "temp2.pdf", context);
    }

  
}