package ma.cu.lalewicz.examsystem.entity;

import javax.persistence.*;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;
    @Column(name = "category_desc")
    private String categoryDescription;

    public Category() {
    }

    public Category(String categoryName, String categoryDescription) {

        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
