package org.tr.swapp.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//@Entity
//@Table(name = "Company")
public class Company {
    //@Id
    private String name;

    //@Column
    private Date founded;
}
