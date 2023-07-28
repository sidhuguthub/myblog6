package com.blogapi.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PostDto {

    private long id;

    @NotEmpty(message = "title should not be empty")
    @Size(min = 2, message = "Title Must Be More Then 2 Character")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Size(min = 5, message = "Description Must Be More Then 5 Character")
    private String description;

    @NotEmpty(message = "content should not be empty")
    @Size(min = 10,message = "Content must have more then 10 character")
    private String content;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
