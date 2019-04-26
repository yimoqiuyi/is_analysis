package com.yp.common.utils.excel;

import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.Performance;
import com.yp.common.utils.Myutils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class PerformanceExcel extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Performance> performanceList= (List<Performance>) map.get("performanceList");
        HSSFSheet sheet = hssfWorkbook.createSheet("performanceList");//list
        sheet.setDefaultColumnWidth((short) 12);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "�ŶӼ�Ч��");
        HSSFCellStyle dateStyle = hssfWorkbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
        cell = getCell(sheet, 1, 0);
        cell.setCellStyle(dateStyle);
        getCell(sheet, 2, 0).setCellValue("��Ч����");
        getCell(sheet, 2, 1).setCellValue("��ʼʱ��");
        getCell(sheet, 2, 2).setCellValue("����ʱ��");
        getCell(sheet, 2, 3).setCellValue("�Ŷ�����");
        HSSFRow sheetRow = sheet.createRow(3);
        for (Performance performance : performanceList) {
            sheetRow.createCell(0).setCellValue(performance.getPerformanceScore());
            sheetRow.createCell(1).setCellValue(performance.getStartTime());
            sheetRow.createCell(2).setCellValue(performance.getEndTime());
            sheetRow.createCell(3).setCellValue(performance.getGroupName());
        }
        String filename = "�ŶӼ�Ч��.xls";//��������ʱ�ͻ���Excel������
        filename = Myutils.encodeFilename(filename, httpServletRequest);//���������ļ���
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream =httpServletResponse.getOutputStream();
        hssfWorkbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
