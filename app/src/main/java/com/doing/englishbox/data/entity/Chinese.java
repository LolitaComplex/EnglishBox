package com.doing.englishbox.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-02.
 */
@Entity
public class Chinese implements Item {

    @Id(autoincrement = true)
    private Long id;

    private Long boxItemId;

    @NotNull
    private String content;

    @Generated(hash = 177720952)
    public Chinese(Long id, Long boxItemId, @NotNull String content) {
        this.id = id;
        this.boxItemId = boxItemId;
        this.content = content;
    }

    @Generated(hash = 2127649856)
    public Chinese() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBoxItemId() {
        return this.boxItemId;
    }

    public void setBoxItemId(Long boxItemId) {
        this.boxItemId = boxItemId;
    }
}