package com.sprintboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FTPProperties {

    @Value("${ftp.server}")
    private String ftpserver;

    @Value("${ftp.port}")
    private String ftpport;

    @Value("${ftp.user}")
    private String ftpuser;

    @Value("${ftp.pass}")
    private String ftppass;

    public String getFtpserver() {
        return ftpserver;
    }

    public void setFtpserver(String ftpserver) {
        this.ftpserver = ftpserver;
    }

    public String getFtpport() {
        return ftpport;
    }

    public void setFtpport(String ftpport) {
        this.ftpport = ftpport;
    }

    public String getFtpuser() {
        return ftpuser;
    }

    public void setFtpuser(String ftpuser) {
        this.ftpuser = ftpuser;
    }

    public String getFtppass() {
        return ftppass;
    }

    public void setFtppass(String ftppass) {
        this.ftppass = ftppass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FTPProperties)) return false;
        FTPProperties that = (FTPProperties) o;
        return Objects.equals(getFtpserver(), that.getFtpserver()) &&
                Objects.equals(getFtpport(), that.getFtpport()) &&
                Objects.equals(getFtpuser(), that.getFtpuser()) &&
                Objects.equals(getFtppass(), that.getFtppass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFtpserver(), getFtpport(), getFtpuser(), getFtppass());
    }

    @Override
    public String toString() {
        return "FTPProperties{" +
                "ftpserver='" + ftpserver + '\'' +
                ", ftpport='" + ftpport + '\'' +
                ", ftpuser='" + ftpuser + '\'' +
                ", ftppass='" + ftppass + '\'' +
                '}';
    }
}
