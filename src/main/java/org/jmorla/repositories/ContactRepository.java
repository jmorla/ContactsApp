package org.jmorla.repositories;

import org.jmorla.models.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jmorla on 26/10/2017.
 */
public interface ContactRepository extends JpaRepository<Contacts,String> {

}
