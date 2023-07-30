package com.app.quest.Business.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
   // private long id;
    private String text;
    private String title;
    private long userId;

}
