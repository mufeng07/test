package com.mufeng.test.http;

import java.util.Date;

/**
 * @Auther: mufeng
 * @Date: 2019/5/20 16:51
 */
public class Record {
    private int id;
    private String record;
    private Date visitDate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRecord() {
        return record;
    }
    public void setRecord(String record) {
        this.record = record;
    }
    public Date getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
