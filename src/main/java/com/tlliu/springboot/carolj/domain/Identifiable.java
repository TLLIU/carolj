package com.tlliu.springboot.carolj.domain;

import java.io.Serializable;

public interface Identifiable<ID extends Serializable> extends Serializable {
    ID getBaseObjId();
}
