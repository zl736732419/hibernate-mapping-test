package com.zheng.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * one one
 * Created by Administrator on 2017/3/15.
 */
public class QQZoom {
    private Long id;
    private String name;
    private QQNumber qqNumber;

    public QQZoom() {
        
    }
    
    public QQZoom(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QQNumber getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(QQNumber qqNumber) {
        this.qqNumber = qqNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (!(obj instanceof QQZoom)) {
            return false;
        }

        QQZoom other = (QQZoom) obj;

        return new EqualsBuilder().append(this.name, other.name).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.name).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.name).toString();
    }
}
