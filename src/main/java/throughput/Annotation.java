package throughput;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Annotation {

    @GraphId private Long id;

    private Person creator;
    private String target;
    private String body;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person person) {
        this.creator = person;
    }
}