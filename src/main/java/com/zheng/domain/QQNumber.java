package com.zheng.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * one one
 * Created by Administrator on 2017/3/15.
 */
public class QQNumber {
    private Long id;
    private String numbers;
    private QQZoom qqZoom;

    public QQNumber() {
        
    }

    public QQNumber(String numbers) {
        this.numbers = numbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public QQZoom getQqZoom() {
        return qqZoom;
    }

    public void setQqZoom(QQZoom qqZoom) {
        this.qqZoom = qqZoom;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (!(obj instanceof QQNumber)) {
            return false;
        }

        QQNumber other = (QQNumber) obj;

        return new EqualsBuilder().append(this.numbers, other.getNumbers()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.numbers).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.numbers).toString();
    }
}
