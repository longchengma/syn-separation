/*
package com.home.spring.template;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

*/
/**
 * Created by li.ma on 2019/2/21.
 *//*

public

interface CatalogRepository extends CrudRepository<Catalog, Long> {




   */
/* @Query(value = "select * from Catalog a where a.id = :id for update", nativeQuery = true)
    Optional<Catalog> findCatalogsForUpdate(@Param("id") Long id);




    @Lock
            (value =
                    LockModeType
                            .PESSIMISTIC_WRITE)
//代表行级锁


    @Query
            (
                    "select a from Catalog a where a.id = :id"
            )


    Optional
            <
                    Catalog
                    > findCatalogWithPessimisticLock(
            @Param
                    (
                            "id"
                    )
            Long
                    id);




    @Modifying
            (clearAutomatically =
                    true
            )
//修改时需要带上


    @Query
            (value =
                    "update Catalog set browse_count = :browseCount, version = version + 1 where id = :id "
                            +


                            "and version = :version"
                    , nativeQuery =
                    true
            )


    int
    updateCatalogWithVersion(
            @Param
                    (
                            "id"
                    )
            Long
                    id,
            @Param
                    (
                            "browseCount"
                    )
            Long
                    browseCount,
            @Param
                    (
                            "version"
                    )
            Long
                    version);*//*




}*/
