package me.motyim.learn.mongo.morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.logging.Logger;
import org.mongodb.morphia.logging.MorphiaLoggerFactory;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 08-Nov-17
 */
public class DemoTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private GithubUser user;
    private Date date;
    final Morphia morphia = new Morphia();
    private Datastore datastore;
    private Logger logger;

    public DemoTest() {

        try {
            //start up logger
            logger = MorphiaLoggerFactory.get(DemoTest.class);

            //parse date
            date = sdf.parse("01-15-2010");

            // tell Morphia where to find your classes
            // can be called multiple times with different packages or classes
            morphia.mapPackage("me.motyim.learn.mongo.morphia");

            // create the Datastore connecting to the default port on the local host
            datastore = morphia.createDatastore(new MongoClient(), "morphia_example");

            //drop the old schema
            datastore.getDB().dropDatabase();
            this.logger.info("old schema dropped");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test()
    public void basicUser() {
        user = new GithubUser("motyim");
        user.setFollowers(10);
        user.setFollowing(5);
        user.setFullname("mohamed ahmed");
        user.setMemberSince(date);

        datastore.save(user);

        logger.info("[basicUser] : user added to database");
    }


    @Test(dependsOnMethods = {"basicUser"})
    public void repositories(){

        Organization organization = new Organization("JMongo");
        datastore.save(organization);
        logger.info("[repositories] : organization added to database");

        Repository repository1 = new Repository("morphia",organization);
        Repository repository2 = new Repository("morphia",user);

        datastore.save(repository1);
        datastore.save(repository2);
        logger.info("[repositories] : 2 repository added to database");


        List<Repository> repositories = user.getRepositories();
        repositories.add(repository1);
        repositories.add(repository2);
        user.setRepositories(repositories);
        datastore.save(user);
        logger.info("[repositories] : user updated ");

    }

    @Test(dependsOnMethods = {"repositories"},enabled = false)
    public void queryFirst(){
        Query<Repository> query = datastore.createQuery(Repository.class);
        Repository repository = query.get();

        logger.info("[queryFirst] : get first repo");

        logger.info(repository.toString());


    }

    @Test(dependsOnMethods = {"repositories"},enabled = false)
    public void queryAllList(){
        Query<Repository> query = datastore.createQuery(Repository.class);
        List<Repository> repositories = query.asList();

        logger.info("[queryAllList] : get all repo");


        for (Repository repository : repositories) {
            logger.info(repository.toString());
        }

    }


    @Test(dependsOnMethods = {"repositories"},enabled = false)
    public void queryAllIteration(){
        Query<Repository> query = datastore.createQuery(Repository.class);
        Iterator<Repository> iterator = query.iterator();

        logger.info("[queryAllIteration] : get all repo");
        while(iterator.hasNext()){
            logger.info(iterator.next().toString());
        }

    }


    @Test(dependsOnMethods = {"repositories"} ,enabled = false)
    public void querybyOwner(){
        Query<Repository> query = datastore.createQuery(Repository.class);
        Repository repository = query.field("owner").equal(user).get();

        logger.info("[querybyOwner] : get repo by owner");

        logger.info(repository.toString());

    }

    @Test(dependsOnMethods = {"repositories"})
    public void updateUser(){

        //update query
        UpdateOperations<GithubUser> updateQuery = datastore.createUpdateOperations(GithubUser.class)
                                                            .inc("followers")
                                                            .set("following", 42);

        //search query
        Query<GithubUser> findQuery = datastore.createQuery(GithubUser.class).field("followers").equal(10);

        datastore.update(findQuery,updateQuery);
        logger.info("[updateUser] : user updated");


    }




}
