package com.maodami.basketball.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "card_record")
public class CardRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime checkInTime = LocalDateTime.now();

    //无参的构造方法
    public CardRecord() {
    }

    //有参数的构造方法
    public CardRecord(User user, Card card, String imageUrl, LocalDateTime checkInTime) {
        this.user = user;
        this.card = card;
        this.imageUrl = imageUrl;
        this.checkInTime = checkInTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}
