package com.fdmgroup.flexdronepodq42022.DTO;

public class TwoFactorAuthDto {
    private String username;

    public TwoFactorAuthDto() {}

    public TwoFactorAuthDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
