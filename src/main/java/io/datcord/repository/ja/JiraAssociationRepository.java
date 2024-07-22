package io.datcord.repository.ja;

import io.datcord.entity.ja.JiraAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The JiraAssociationRepository interface extends the JpaRepository interface, providing CRUD operations for the JiraAssociation entity.
 * It is annotated with @Repository to indicate that it is a Spring Data repository managed by the container, allowing it to be auto-detected and used as a bean.
 */
@Repository
public interface JiraAssociationRepository extends JpaRepository<JiraAssociation,Integer> {


        /**
         * Finds JiraAssociations by assignee name.
         *
         * @param assignee the name of the assignee
         * @return a collection of JiraAssociations that have the specified assignee name
         */
        Collection<JiraAssociation> findByAssigneeName(String assignee);

        /**
         * Finds JiraAssociations by user ID.
         *
         * @param userId the unique identifier of the user
         * @return a collection of JiraAssociations that have the specified user ID
         */
        Collection<JiraAssociation> findByUserId(long userId);

}
