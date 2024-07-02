package ru.accelerator.sdt.gateway.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.accelerator.sdt.gateway.entities.Area;

import java.time.LocalDate;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    @Modifying
    @Query( value = "Update [areas]" +
            "set    title = coalesce(:title, title" +
            "set    longitude = coalesce(:longitude, longitude)" +
            "set    latitude = coalesce(:latitude, latitude)" +
            "set    soil_type = coalesce(:soilType, soil_type)" +
            "set    sowing_date = coalesce(:sowingDate, sowing_date)" +
            "where id = :id",
        nativeQuery = true)
    void updateArea(Integer id, String title, Double longitude, Double latitude, String soilType, LocalDate sowingDate);

    @Query("Select a from area a where a.title like :title ")
    Page<Area> findAreasByTitle(String title, Pageable pageable);
}
