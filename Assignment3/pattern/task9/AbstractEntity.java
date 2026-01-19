import java.util.Date;

public abstract class AbstractEntity {
    public int id;
    public Date createdTime;
    public Date updatedTime;

    public AbstractEntity(){

    }
    public AbstractEntity(AbstractEntity other){
        this.id = other.id;
        this.createdTime = other.createdTime;
        this.updatedTime = other.updatedTime;
    }

    public abstract AbstractEntity
    AbstractEntityClone();
}
