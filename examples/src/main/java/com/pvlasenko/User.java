package com.pvlasenko;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
// import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// import javax.persistence.Enumerated; // JPWH - p. 120 used with enums

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Formula;

// import org.hibernate.annotations.Subselect; // view with subqueries JPWH - p. 108
// import org.hibernate.annotations.Synchronize; // JPWH - p. 107
// import org.hibernate.annotations.GenericGenerator; // JPWH - p. 98
// import org.hibernate.annotations.ColumnTransformer; // JPWH - p. 117

// @org.hibernate.annotations.DynamicInsert JPWH - p. 107
// @org.hibernate.annotations.DynamicUpdate JPWH - p. 107
@Entity // @Entity(name = 'otherName') optional name - override name witch used in queries
@Access(AccessType.PROPERTY) // can be used with class or single property JPWH - p. 115
@Table(name = "USERS")  // optional, set table name JPWH - p. 104
public class User {

    @Id  // JPWH - p. 94 if used with property, set access type for all properties
    @GeneratedValue // JPWH - p. 107, @GeneratedValue(generator = "ID_GENERATOR") JPWH - p. 97-98
    private Long id;

    @Immutable // org.hibernate.annotations JPWH - p. 107
    private String immutableProperty = "immutable value ";

    // @Basic(optional = false) // JPWH - p. 113
    // @Access(AccessType.PROPERTY) // can be used with class or single property JPWH - p. 115
    @NotNull  // do not used during DDL generation, JPWH - p. 113, 122, 123
    @Column(name = "FIRST_NAME", nullable = false) // nullable = false - used during DDL generation, JPWH - p. 122
    private String firstName;

    @Formula("substr(FIRST_NAME, 1, 1)") // org.hibernate.annotations JPWH - p. 116
    private String firstLatterOFName;

    // JPWH - p. 118
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS) // org.hibernate.annotations
    private Date updatedAt;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
