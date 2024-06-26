package com.dugu.ddd.infra.mw.tools.pdf;

import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.IOException;

/**
 * WaterMarkEventHandler 水印
 * @author cihun
 * @date 2024/5/14 16:52
 */
public class WaterMarkEventHandler implements IEventHandler
{

    /**
     * 水印内容
     */
    private String waterMarkContent;

    /**
     * 一页中有几列水印
     */
    private int waterMarkX;

    /**
     * 一页中每列有多少水印
     */
    private int waterMarkY;

    public WaterMarkEventHandler(String waterMarkContent) {
        this(waterMarkContent, 5, 5);
    }

    public WaterMarkEventHandler(String waterMarkContent, int waterMarkX, int waterMarkY) {
        this.waterMarkContent = waterMarkContent;
        this.waterMarkX = waterMarkX;
        this.waterMarkY = waterMarkY;
    }

    @Override
    public void handleEvent(Event event) {

        PdfDocumentEvent documentEvent = (PdfDocumentEvent) event;
        PdfDocument document = documentEvent.getDocument();
        PdfPage page = documentEvent.getPage();
        Rectangle pageSize = page.getPageSize();

        PdfFont pdfFont = null;
        try {
            pdfFont = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamAfter(), page.getResources(), document);

        Paragraph waterMark = new Paragraph(waterMarkContent).setOpacity(0.5f);
        Canvas canvas = new Canvas(pdfCanvas, pageSize)
                .setFontColor(WebColors.getRGBColor("lightgray"))
                .setFontSize(16)
                .setFont(pdfFont);

        for (int i = 0; i < waterMarkX; i++) {
            for (int j = 0; j < waterMarkY; j++) {
                canvas.showTextAligned(waterMark, (150 + i * 300), (160 + j * 150), document.getNumberOfPages(), TextAlignment.CENTER, VerticalAlignment.BOTTOM, 120);
            }
        }
        canvas.close();
    }
}
