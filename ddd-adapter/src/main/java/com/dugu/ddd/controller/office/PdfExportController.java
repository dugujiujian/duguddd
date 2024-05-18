package com.dugu.ddd.controller.office;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author cihun
 * @date 2024/5/13 20:14
 */
@RestController
public class PdfExportController {

    @PostMapping("/download")
    @SneakyThrows(Exception.class)
    public void download(HttpServletResponse response, HttpServletRequest request) {
        // 防止日志记录获取session异常
        request.getSession();
        // 设置编码格式
        response.setContentType("application/pdf;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("下载的PDF名称", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".pdf");
//        fumigationService.download(fumigationDTO, response);
    }
}
