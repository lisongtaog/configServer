package com.bestgo.common.dto;
import java.io.Serializable;
import java.util.List;

public class AppCountryCodeDictDto extends BaseQueryConditionDto implements Serializable{
    private String countryCode;

    private String countryName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }
}
