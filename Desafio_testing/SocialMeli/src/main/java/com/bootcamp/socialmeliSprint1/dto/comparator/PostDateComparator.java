package com.bootcamp.socialmeliSprint1.dto.comparator;

import com.bootcamp.socialmeliSprint1.dto.response.post.PostOutDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class PostDateComparator implements Comparator<PostOutDTO> {


    SortOrder order;

    public PostDateComparator(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(PostOutDTO o1, PostOutDTO o2) {

        int compared;

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date1 = LocalDate.parse(o1.getDate(),dt);
        LocalDate date2 = LocalDate.parse(o2.getDate(),dt);

        if(date1.equals(date2)){
            compared = 0;
        }else{
            if(date1.isBefore(date2)){
                compared =  1;
            }else{
                compared = -1;
            }

        }
        return (order.equals(SortOrder.ASC)) ? (compared*-1) : compared;
    }

}
