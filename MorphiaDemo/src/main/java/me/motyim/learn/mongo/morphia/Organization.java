package me.motyim.learn.mongo.morphia;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Version;
import org.mongodb.morphia.utils.IndexDirection;

import java.util.Date;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 08-Nov-17
 */
@Entity("orgs")
public class Organization {
    @Id
    public String name ;

    public Date created ;
    @Version(value = "v")
    public long version ;

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
