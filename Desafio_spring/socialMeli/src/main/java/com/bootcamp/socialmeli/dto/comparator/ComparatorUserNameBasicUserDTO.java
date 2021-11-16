package com.bootcamp.socialmeli.dto.comparator;

import com.bootcamp.socialmeli.dto.response.user.BasicUserInfo;

import java.util.Comparator;

public class ComparatorUserNameBasicUserDTO implements Comparator<BasicUserInfo> {

    SortOrder order;

    public ComparatorUserNameBasicUserDTO(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(BasicUserInfo o1, BasicUserInfo o2) {
        return (order == SortOrder.ASC)
                ? o1.getUserName().compareTo(o2.getUserName())
                : o1.getUserName().compareTo(o2.getUserName()) * -1;
    }
}
