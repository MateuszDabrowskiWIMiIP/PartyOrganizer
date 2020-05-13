package pl.dabrowski.partyOrganizer.model;


import javax.persistence.*;

@Entity
public class Party {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nameartist;

    private String place;

    private String dayparty;

    private Integer allseats;

    private Integer emptyseats;

    private Integer price;

    public Party() {
    }

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameartist='" + nameartist + '\'' +
                ", place='" + place + '\'' +
                ", dayparty='" + dayparty + '\'' +
                ", allseats=" + allseats +
                ", emptyseats=" + emptyseats +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameartist() {
        return nameartist;
    }

    public void setNameartist(String nameartist) {
        this.nameartist = nameartist;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDayparty() {
        return dayparty;
    }

    public void setDayparty(String dayparty) {
        this.dayparty = dayparty;
    }

    public Integer getAllseats() {
        return allseats;
    }

    public void setAllseats(Integer allseats) {
        this.allseats = allseats;
    }

    public Integer getEmptyseats() {
        return emptyseats;
    }

    public void setEmptyseats(Integer emptyseats) {
        this.emptyseats = emptyseats;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Party(Long id, String name, String nameartist, String place, String dayparty, Integer allseats, Integer emptyseats, Integer price) {
        this.id = id;
        this.name = name;
        this.nameartist = nameartist;
        this.place = place;
        this.dayparty = dayparty;
        this.allseats = allseats;
        this.emptyseats = emptyseats;
        this.price = price;
    }
}
