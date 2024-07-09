package com.rishi.ChallengeApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Challenge {

    @Id
    private Long id;

    @Column(name = "challengeMonth")
    private String month;
    private String desc;


    public Challenge() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Challenge(Long id, String month, String desc) {
        this.id = id;
        this.month = month;
        this.desc = desc;
    }
}
