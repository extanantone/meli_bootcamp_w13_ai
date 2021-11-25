package meli.bootcamp.socialmeli.model;

public class UserFollow {
    private int userFollower;
    private int followedUser;

    public UserFollow(int userFollower, int followedUser) {
        this.userFollower = userFollower;
        this.followedUser = followedUser;
    }

    public UserFollow() {
    }

    public int getUserFollower() {
        return userFollower;
    }

    public void setUserFollower(int userFollower) {
        this.userFollower = userFollower;
    }

    public int getFollowedUser() {
        return followedUser;
    }

    public void setFollowedUser(int followedUser) {
        this.followedUser = followedUser;
    }
}
