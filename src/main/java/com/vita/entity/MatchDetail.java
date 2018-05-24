package com.vita.entity;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
public abstract class MatchDetail {

    protected String id;
    private Double tl;  //投篮
    private Integer mz; //命中
    private Integer cs; //出手
    private Double sanfen; //三分
    private Integer sanfenmz; //三分命中
    private Integer sanfencs; //三分出手
    private Double fq;  //罚球
    private Integer fqmz; //罚球命中
    private Integer fqcs; //罚球出手

    private Double zsmz;  //真实命中
    private Integer lb; //篮板
    private Integer qc; //前场
    private Integer hc; //后场
    private Integer zg; //助攻
    private Integer qd; //抢断
    private Integer gm; //盖帽
    private Integer sw; //失误
    private Integer fg; //犯规
    private Integer df; //得分

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTl() {
        return tl;
    }

    public void setTl(Double tl) {
        this.tl = tl;
    }

    public Integer getMz() {
        return mz;
    }

    public void setMz(Integer mz) {
        this.mz = mz;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public Double getSanfen() {
        return sanfen;
    }

    public void setSanfen(Double sanfen) {
        this.sanfen = sanfen;
    }

    public Integer getSanfenmz() {
        return sanfenmz;
    }

    public void setSanfenmz(Integer sanfenmz) {
        this.sanfenmz = sanfenmz;
    }

    public Integer getSanfencs() {
        return sanfencs;
    }

    public void setSanfencs(Integer sanfencs) {
        this.sanfencs = sanfencs;
    }

    public Double getFq() {
        return fq;
    }

    public void setFq(Double fq) {
        this.fq = fq;
    }

    public Integer getFqmz() {
        return fqmz;
    }

    public void setFqmz(Integer fqmz) {
        this.fqmz = fqmz;
    }

    public Integer getFqcs() {
        return fqcs;
    }

    public void setFqcs(Integer fqcs) {
        this.fqcs = fqcs;
    }

    public Double getZsmz() {
        return zsmz;
    }

    public void setZsmz(Double zsmz) {
        this.zsmz = zsmz;
    }

    public Integer getLb() {
        return lb;
    }

    public void setLb(Integer lb) {
        this.lb = lb;
    }

    public Integer getQc() {
        return qc;
    }

    public void setQc(Integer qc) {
        this.qc = qc;
    }

    public Integer getHc() {
        return hc;
    }

    public void setHc(Integer hc) {
        this.hc = hc;
    }

    public Integer getZg() {
        return zg;
    }

    public void setZg(Integer zg) {
        this.zg = zg;
    }

    public Integer getQd() {
        return qd;
    }

    public void setQd(Integer qd) {
        this.qd = qd;
    }

    public Integer getGm() {
        return gm;
    }

    public void setGm(Integer gm) {
        this.gm = gm;
    }

    public Integer getSw() {
        return sw;
    }

    public void setSw(Integer sw) {
        this.sw = sw;
    }

    public Integer getFg() {
        return fg;
    }

    public void setFg(Integer fg) {
        this.fg = fg;
    }

    public Integer getDf() {
        return df;
    }

    public void setDf(Integer df) {
        this.df = df;
    }

}
