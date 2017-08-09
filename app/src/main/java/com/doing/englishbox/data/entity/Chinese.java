package com.doing.englishbox.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-02.
 */
@Entity
public class Chinese {

    @Id(autoincrement = true)
    private Long chineseId;

    private Long boxItemId;

    @NotNull
    private String content;

    @Generated(hash = 378564136)
    public Chinese(Long chineseId, Long boxItemId, @NotNull String content) {
        this.chineseId = chineseId;
        this.boxItemId = boxItemId;
        this.content = content;
    }

    @Generated(hash = 2127649856)
    public Chinese() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getChineseId() {
        return chineseId;
    }

    public void setChineseId(Long chineseId) {
        this.chineseId = chineseId;
    }

    public Long getBoxItemId() {
        return this.boxItemId;
    }

    public void setBoxItemId(Long boxItemId) {
        this.boxItemId = boxItemId;
    }
}