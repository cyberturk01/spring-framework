package org.yigit.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yigit.entity.Region;
import org.yigit.repository.RegionRepository;

import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------Region Start here---------");
        List<Region> canada =  regionRepository.findByCountry("Canada");

        System.out.println(canada);
        System.out.println(regionRepository.findDistinctByCountry("Canada"));
        System.out.println(regionRepository.findByCountryContains("United"));
        System.out.println(regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println(regionRepository.findTop2ByCountry("Canada"));

        System.out.println("--------Region end here---------");
    }
}
