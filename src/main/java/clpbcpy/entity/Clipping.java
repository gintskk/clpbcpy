package clpbcpy.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CLIPPING", schema = "PUBLIC")
@Entity
public class Clipping {

    @Id
    @Getter
    @Setter
    @Column(name = "ID")
    @Generated
    private long id;

    @Getter
    @Setter
    @Column(name = "MESSAGE")
    private String message;

    @Getter
    @Setter
    @Column(name = "CREATED_AT")
    @Generated
    private long createdAt;

    @Getter
    @Setter
    @Column(name = "CONTENT_LINKS_JSON")
    private String contentLinksJson;
}
