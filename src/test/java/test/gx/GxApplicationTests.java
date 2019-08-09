package test.gx;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GxApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMongoConn(){
        try {
            MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
            MongoDatabase mongoDatabase = new MongoClient().getDatabase("mycol");

            System.out.println("connect to MongoDB Server successfully");

//            mongoDatabase.createCollection("test");
//            System.out.println("collection create successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("collection select successfully");

            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Document document = new Document("title", "MongoDB").
                    append("description", "database").
                    append("likes", 100).
                    append("by", "Fly");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");


            //更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();

            //删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("likes", 200));
            //删除所有符合条件的文档
            collection.deleteMany (Filters.eq("likes", 200));

            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
