package com.maodami.basketball.entity;

import com.maodami.basketball.enums.CardStatus;
import com.maodami.basketball.enums.CardType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //LAZY（懒加载）：当你查询 Card 时，不会立即查询关联的 User 数据；只有当你真正访问 card.getUser() 时，才会执行查询 User 的 SQL
    @ManyToOne(fetch = FetchType.LAZY)
    //name = "user_id"：在 cards 表中创建名为 user_id 的外键列的名字
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;

    //创建时间
    @Column(nullable = false)
    private LocalDateTime createTime = LocalDateTime.now();

    //更新时间
    private LocalDateTime updateTime = LocalDateTime.now();

    //JPA自动处理更新时间
    @PreUpdate
    public void preUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    public Card() {
    }

    public Card(User user, CardType type, CardStatus status) {
        this.user = user;
        this.type = type;
        this.status = status;
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

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
