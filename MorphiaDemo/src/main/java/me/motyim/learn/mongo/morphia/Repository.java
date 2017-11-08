package me.motyim.learn.mongo.morphia;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 08-Nov-17
 */
@Entity("repo")
public class Repository {
    @Id
    public String name ;

    @Reference
    public Organization organization ;

    @Reference
    public  GithubUser owner ;

    public Repository(){}

    public Repository(String name, GithubUser owner) {
        this.name = name;
        this.owner = owner;
    }

    public Repository(String name, Organization organization) {
        this.name = name;
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public GithubUser getOwner() {
        return owner;
    }

    public void setOwner(GithubUser owner) {
        this.owner = owner;
    }
}
