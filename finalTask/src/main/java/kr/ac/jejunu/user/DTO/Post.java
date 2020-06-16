package kr.ac.jejunu.user.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Integer id;

    private String title;

    private String content;

    private String day;

    private String writer;

}
