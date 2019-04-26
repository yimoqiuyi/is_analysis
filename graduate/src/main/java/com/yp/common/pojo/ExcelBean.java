package com.yp.common.pojo;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.Serializable;

public class ExcelBean implements Serializable {
    private String headTextName; //��ͷ�����⣩��
    private String propertyName; //��Ӧ�ֶ���
    private Integer cols; //�ϲ���Ԫ����
    private XSSFCellStyle cellStyle;

    @Override
    public String toString() {
        return "ExcelBean{" +
                "headTextName='" + headTextName + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", cols=" + cols +
                ", cellStyle=" + cellStyle +
                '}';
    }

    public ExcelBean(){
    }
    public ExcelBean(String headTextName, String propertyName){
        this.headTextName = headTextName;
        this.propertyName = propertyName;
    }
    public ExcelBean(String headTextName, String propertyName, Integer cols) {
        super();
        this.headTextName = headTextName;
        this.propertyName = propertyName;
        this.cols = cols;
    }

    public String getHeadTextName() {
        return headTextName;
    }

    public void setHeadTextName(String headTextName) {
        this.headTextName = headTextName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public XSSFCellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(XSSFCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }
}