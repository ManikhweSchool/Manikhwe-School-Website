package com.manikhweschool.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "PYTHON_VISITATION_INFO")
@Component
public class PythonVisitationInfo extends VisitationInfo{

}
