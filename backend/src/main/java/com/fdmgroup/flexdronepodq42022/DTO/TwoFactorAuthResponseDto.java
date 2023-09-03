package com.fdmgroup.flexdronepodq42022.DTO;

public class TwoFactorAuthResponseDto {
    private String qrCodeUrl;

    public TwoFactorAuthResponseDto() {}

    public TwoFactorAuthResponseDto(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
}
