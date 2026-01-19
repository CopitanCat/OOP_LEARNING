public abstract class RequisitionBase extends AbstractEntity {

    public User user;
    public String name;
    public String mail;
    public String utmMark;
    public String webinarType;
    public String promoCode;

    public RequisitionBase() {
    }

    public RequisitionBase(RequisitionBase other) {
        super(other);
        this.user = other.user != null ? (User) other.user.AbstractEntityClone() : null;
        this.name = other.name;
        this.mail = other.mail;
        this.utmMark = other.utmMark;
        this.webinarType = other.webinarType;
        this.promoCode = other.promoCode;
    }
}
