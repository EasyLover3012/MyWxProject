package com.hao.app.wx.manage.pojo;

import java.io.Serializable;
import java.util.Date;


public class ProductParts implements Serializable {
    private Integer id;

    private String contractNo;

    private String proNo;

    private String partsNo;

    private String partsName;

    private String yongliang;

    private String lingyong;

    private String partsFmt;

    private String partsImg;

    private String units;

    private Double hetongNum;

    private Double kucunNum;

    private String buyNum;

    private Integer isReceive;

    private Integer isSendout;//是否外发发齐
    private Integer isSendoutReceive;//是否外发收货收齐

    private Double receiveNum; //已经收货总数

    private Double sendoutNum; //已经外发总数
    
    private Double sendoutReceiveNum;//外发已经收货的总数

    private Double skSumkg;

    private Double skHszb;

    private Double skHskg;

    private String remark;

    private String userName;

    private Date createTime;

    private Date updateTime;



    public Integer getIsSendoutReceive() {
        return isSendoutReceive;
    }


    public void setIsSendoutReceive(Integer isSendoutReceive) {
        this.isSendoutReceive = isSendoutReceive;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getProNo() {
        return proNo;
    }

    public void setProNo(String proNo) {
        this.proNo = proNo == null ? null : proNo.trim();
    }

    public String getPartsNo() {
        return partsNo;
    }

    public void setPartsNo(String partsNo) {
        this.partsNo = partsNo == null ? null : partsNo.trim();
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName == null ? null : partsName.trim();
    }

    public String getPartsFmt() {
        return partsFmt;
    }

    public void setPartsFmt(String partsFmt) {
        this.partsFmt = partsFmt == null ? null : partsFmt.trim();
    }

    public String getPartsImg() {
        return partsImg;
    }

    public void setPartsImg(String partsImg) {
        this.partsImg = partsImg == null ? null : partsImg.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public Double getHetongNum() {
        return hetongNum;
    }

    public void setHetongNum(Double hetongNum) {
        this.hetongNum = hetongNum;
    }

    public Double getKucunNum() {
        return kucunNum;
    }

    public void setKucunNum(Double kucunNum) {
        this.kucunNum = kucunNum;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(Integer isReceive) {
        this.isReceive = isReceive;
    }

    public Integer getIsSendout() {
        return isSendout;
    }

    public void setIsSendout(Integer isSendout) {
        this.isSendout = isSendout;
    }

    public Double getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(Double receiveNum) {
        this.receiveNum = receiveNum;
    }

    public Double getSendoutNum() {
        return sendoutNum;
    }

    public void setSendoutNum(Double sendoutNum) {
        this.sendoutNum = sendoutNum;
    }

    public Double getSkSumkg() {
        return skSumkg;
    }

    public void setSkSumkg(Double skSumkg) {
        this.skSumkg = skSumkg;
    }

    public Double getSkHszb() {
        return skHszb;
    }

    public void setSkHszb(Double skHszb) {
        this.skHszb = skHszb;
    }

    public Double getSkHskg() {
        return skHskg;
    }

    public void setSkHskg(Double skHskg) {
        this.skHskg = skHskg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


	public Double getSendoutReceiveNum() {
		return sendoutReceiveNum;
	}


	public void setSendoutReceiveNum(Double sendoutReceiveNum) {
		this.sendoutReceiveNum = sendoutReceiveNum;
	}


    @Override
    public String toString() {
        return "ProductParts{" + "id=" + id + ", contractNo='" + contractNo + '\'' + ", proNo='" + proNo + '\'' + ", partsNo='" + partsNo + '\'' + ", partsName='" + partsName + '\'' + ", " +
                "yongliang='" + yongliang + '\'' + ", lingyong='" + lingyong + '\'' + ", partsFmt='" + partsFmt + '\'' + ", partsImg='" + partsImg + '\'' + ", units='" + units + '\'' + ", " +
                "hetongNum=" + hetongNum + ", kucunNum=" + kucunNum + ", buyNum='" + buyNum + '\'' + ", isReceive=" + isReceive + ", isSendout=" + isSendout + ", isSendoutReceive=" +
                isSendoutReceive + ", receiveNum=" + receiveNum + ", sendoutNum=" + sendoutNum + ", sendoutReceiveNum=" + sendoutReceiveNum + ", skSumkg=" + skSumkg + ", skHszb=" + skHszb + ", " +
                "skHskg=" + skHskg + ", remark='" + remark + '\'' + ", userName='" + userName + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }


    public String getYongliang() {
        return yongliang;
    }


    public void setYongliang(String yongliang) {
        this.yongliang = yongliang;
    }


    public String getLingyong() {
        return lingyong;
    }


    public void setLingyong(String lingyong) {
        this.lingyong = lingyong;
    }

}