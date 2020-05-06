package cn.hokii.ontheroad.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class Article {
    private int articleId;
    private String author;
    private String title;
    private String Date;
    private String destination;
    private int days;
    private int pay;
    private String content;
    private int collect;
    private int likes;
    private int review;
}
