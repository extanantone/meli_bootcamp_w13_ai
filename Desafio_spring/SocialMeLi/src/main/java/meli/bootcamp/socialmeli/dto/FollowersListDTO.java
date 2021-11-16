package meli.bootcamp.socialmeli.dto;

import java.util.List;

public class FollowersListDTO {
    private int userId;
    private String userName;
    private List<UserDTO> mListUsers;

    public FollowersListDTO(int userId, String userName, List<UserDTO> mListUsers) {
        this.userId = userId;
        this.userName = userName;
        this.mListUsers = mListUsers;
    }

    public FollowersListDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserDTO> getmListUsers() {
        return mListUsers;
    }

    public void setmListUsers(List<UserDTO> mListUsers) {
        this.mListUsers = mListUsers;
    }
}
