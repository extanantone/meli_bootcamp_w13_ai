package com.bootcamp.socialmeliSprint1.dto.comparator;

import com.bootcamp.socialmeliSprint1.dto.response.user.BasicUserInfoDTO;

import java.util.Comparator;

public class ComparatorUserNameBasicUserDTO implements Comparator<BasicUserInfoDTO> {

    SortOrder order;

    public ComparatorUserNameBasicUserDTO(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(BasicUserInfoDTO o1, BasicUserInfoDTO o2) {
        return (order == SortOrder.ASC)
                ? o1.getUserName().compareTo(o2.getUserName())
                : o1.getUserName().compareTo(o2.getUserName()) * -1;
    }
}
