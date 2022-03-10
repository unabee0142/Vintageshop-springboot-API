package nvc.it.vintageshop.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("sale")
@Getter @Setter @NoArgsConstructor
public class Sale {
    @Id
    private String _id;
    private String name;
    private String tel;
    private String nameProduct;
    private String img;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updataDate;
}
