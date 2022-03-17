package com.binar.grab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Where;



import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "barang")
@Where(clause = "deleted_date is null")
public class Barang extends AbstractDate implements Serializable {


    @Id
    @Setter
    @Getter
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Setter
    @Getter
    @Column(name = "stok", nullable = false, length = 11)
    private int stok;
    @Setter
    @Getter
    @Column(name = "satuan", nullable = false, length = 45)
    private String satuan;

    @Setter
    @Getter
    @Column(name = "harga",length = 11)
    private Double harga;

    // wajib
    @Setter
    @Getter
    @ManyToOne(targetEntity = Supplier.class, cascade = CascadeType.ALL)
    private Supplier supplier;//ok supplier_id
    @Setter
    @Getter
    @Column(name = "namafile")
    private String namaFile;
    @Transient
    private String url;

    public String getUrl() {
            if(  getNamaFile()== null ){
                return "";
            }
            return "http://localhost:9091/api/v1/showFile/"+getNamaFile();
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
