package com.persist.postventa.entity.base;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BasePostgresEntity  implements Serializable {
    private static final long serialVersionUID = 1374865634081118201L;
}
