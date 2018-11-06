package com.dto;

import com.pojo.Ad;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AdDto extends Ad {

    private String img;

    private CommonsMultipartFile imgFile;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CommonsMultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(CommonsMultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
