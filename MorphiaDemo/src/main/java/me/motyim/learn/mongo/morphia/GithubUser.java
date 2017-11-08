package me.motyim.learn.mongo.morphia;


import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 08-Nov-17
 */
@Entity(value = "user",noClassnameStored = true)
@Indexes({
        //this is index it's name popular and asc on username and desc on followers
        @Index(value = "username -followers" , name = "popular"),
        //this index on lastActive on date so we can make expire option which reomve form idx if not update after 10^6 ms
        @Index(value = "lastActive" , name = "idle" , expireAfterSeconds = 1000000)
})
public class GithubUser {

    @Id
    private String username ;

    private String fullname ;
    @Property(value = "since")      // value will be in mongo db
    private Date memberSince ;

    private Date lastActive ;

    private List<Repository> repositories = new ArrayList<>();

    private int followers ;

    private int following ;

    public GithubUser(){

    }

    public GithubUser(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "username : "+getUsername() ;
    }
}
