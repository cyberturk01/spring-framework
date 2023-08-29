package org.yigit.model;

import lombok.Data;

@Data
//Pojo Classes dont get @Component has no dependency
public class Comment {
    private String author;
    private String text;

}
