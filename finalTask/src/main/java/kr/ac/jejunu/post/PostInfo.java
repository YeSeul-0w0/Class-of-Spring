package kr.ac.jejunu.post;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PostInfo {
    private Integer id;
    private String day;
    private String title;
    private String content;
    private String writer;

}
