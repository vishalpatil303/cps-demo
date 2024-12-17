package com.cps.model;

import jakarta.persistence.*;


@Entity
@Table(name = "proformaf")
public class ProformaF implements Proforma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer srNo;
    private Long documentNo;
    private Integer postingYear;
    private Integer profitCenter;
    private String sapId;
    private Long cpfNo;
    private String employeeName;
    private String claimDescription;
    private Float payableAmount;
    @ManyToOne
    private File file;

    public ProformaF()  {
    }

    public Long getId() {
        return id;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(Long documentNo) {
        this.documentNo = documentNo;
    }

    public Integer getPostingYear() {
        return postingYear;
    }

    public void setPostingYear(Integer postingYear) {
        this.postingYear = postingYear;
    }

    public Integer getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(Integer profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getSapId() {
        return sapId;
    }

    public void setSapId(String sapId) {
        this.sapId = sapId;
    }

    public Long getCpfNo() {
        return cpfNo;
    }

    public void setCpfNo(Long cpfNo) {
        this.cpfNo = cpfNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public Float getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Float payableAmount) {
        this.payableAmount = payableAmount;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "ProformaF{" +
                "id=" + id +
                ", srNo=" + srNo +
                ", documentNo=" + documentNo +
                ", postingYear=" + postingYear +
                ", profitCenter=" + profitCenter +
                ", sapId='" + sapId + '\'' +
                ", cpfNo=" + cpfNo +
                ", employeeName='" + employeeName + '\'' +
                ", claimDescription='" + claimDescription + '\'' +
                ", payableAmount=" + payableAmount +
                '}';
    }
}
