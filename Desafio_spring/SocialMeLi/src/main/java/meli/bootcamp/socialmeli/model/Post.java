package meli.bootcamp.socialmeli.model;

import java.time.LocalDate;

public class Post {
    private int userId;
    private int postId;
    private LocalDate date;
    public Product detail;
    public String category;
    public double price;

    public Post(int userId, int postId, LocalDate date, Product detail, String category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", postId=" + postId +
                ", date=" + date +
                ", detail=" + detail +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
