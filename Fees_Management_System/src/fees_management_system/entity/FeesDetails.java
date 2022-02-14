package fees_management_system.entity;

import java.util.Date;

/**
 * @author Rijwank
 */
public class FeesDetails {

    private int receiptNo;
    private String paymentMode;
    private Date date;
    private String studentName;
    private String rollNo;
    private String chequeNo;
    private String bankName;
    private String ddNo;
    private String courseName;
    private String gstin;
    private float amount;
    private float totalAmount;
    private float cgst;
    private float sgst;
    private String totalInWords;
    private String remark;
    private int year1;
    private int year2;

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDdNo() {
        return ddNo;
    }

    public void setDdNo(String ddNo) {
        this.ddNo = ddNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getCgst() {
        return cgst;
    }

    public void setCgst(float cgst) {
        this.cgst = cgst;
    }

    public float getSgst() {
        return sgst;
    }

    public void setSgst(float sgst) {
        this.sgst = sgst;
    }

    public String getTotalInWords() {
        return totalInWords;
    }

    public void setTotalInWords(String totalInWords) {
        this.totalInWords = totalInWords;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public FeesDetails(int receiptNo, String paymentMode, Date date, String studentName, String rollNo, String chequeNo, String bankName, String ddNo, String courseName, String gstin, float amount, float totalAmount, float cgst, float sgst, String totalInWords, String remark, int year1, int year2) {
        this.receiptNo = receiptNo;
        this.paymentMode = paymentMode;
        this.date = date;
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.chequeNo = chequeNo;
        this.bankName = bankName;
        this.ddNo = ddNo;
        this.courseName = courseName;
        this.gstin = gstin;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.cgst = cgst;
        this.sgst = sgst;
        this.totalInWords = totalInWords;
        this.remark = remark;
        this.year1 = year1;
        this.year2 = year2;
    }

    public FeesDetails() {
    }

}
