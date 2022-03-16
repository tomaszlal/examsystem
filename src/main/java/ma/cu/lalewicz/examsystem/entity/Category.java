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
}
